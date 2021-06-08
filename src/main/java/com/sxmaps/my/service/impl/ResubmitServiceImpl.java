package com.sxmaps.mms.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.sxmaps.mms.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Sets;
import com.sxmaps.mms.client.AuthenticationClient;
import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.common.OperationEnum;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MemberMapper;
import com.sxmaps.mms.mapper.MmsCallBackMapper;
import com.sxmaps.mms.mapper.MmsMemberTypeMapper;
import com.sxmaps.mms.mapper.MmsResubmitEvaluateMapper;
import com.sxmaps.mms.mapper.MmsResubmitListMapper;
import com.sxmaps.mms.mapper.MmsResubmitMemberMapper;
import com.sxmaps.mms.model.MmsCallBack;
import com.sxmaps.mms.model.MmsMemberType;
import com.sxmaps.mms.model.MmsResubmitEvaluate;
import com.sxmaps.mms.model.MmsResubmitList;
import com.sxmaps.mms.model.MmsResubmitMember;
import com.sxmaps.mms.service.IResubmitService;
import com.sxmaps.mms.service.IworkChatService;
import com.sxmaps.mms.task.ImportExcelTask;
import com.sxmaps.mms.vo.ReqMemberTypeVO;
import com.sxmaps.mms.vo.req.ReqCallBackVO;
import com.sxmaps.mms.vo.req.ReqDistributionVO;
import com.sxmaps.mms.vo.req.ReqEvaluateVO;
import com.sxmaps.mms.vo.req.ReqMemberResubmitVO;
import com.sxmaps.mms.vo.req.ReqResubmitPageVO;
import com.sxmaps.mms.vo.req.ReqResubmitUidVO;
import com.sxmaps.mms.vo.resp.RespDistributionLog;
import com.sxmaps.mms.vo.resp.RespEvaluateRantVO;
import com.sxmaps.mms.vo.resp.RespEvaluateVO;
import com.sxmaps.mms.vo.resp.RespExcelResubmitVO;
import com.sxmaps.mms.vo.resp.RespKafkaMessageVO;
import com.sxmaps.mms.vo.resp.RespMemberEvaluateVO;
import com.sxmaps.mms.vo.resp.ResqResubmitVO;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
@AutoConfigureOrder
public class ResubmitServiceImpl implements IResubmitService {

	@Autowired
	private final MmsResubmitMemberMapper resubmitMemberMapper;

	@Autowired
	private final MmsResubmitListMapper resubmitListMapper;

	@Autowired
	private final MmsResubmitEvaluateMapper mmsResubmitEvaluateMapper;

	@Autowired
	private final MmsCallBackMapper mmsCallBackMapper;

	@Autowired
	private final MmsMemberTypeMapper mmsMemberTypeMapper;

	@Autowired
	private final MemberMapper memberMapper;

	@Autowired
	private final IworkChatService wChatService;

	@Autowired
	private final ImportExcelTask importExcelTask;

	@Autowired
	private final RedisUtils redisUtils;

	public ResubmitServiceImpl(RedisUtils redisUtils, IworkChatService wChatService, MemberMapper memberMapper,
			MmsMemberTypeMapper mmsMemberTypeMapper, AuthenticationClient authClient,
			MmsResubmitMemberMapper resubmitMemberMapper, MmsResubmitListMapper resubmitListMapper,
			MmsResubmitEvaluateMapper mmsResubmitEvaluateMapper, MmsCallBackMapper mmsCallBackMapper,
			ImportExcelTask importExcelTask) {
		this.memberMapper = memberMapper;
		this.resubmitMemberMapper = resubmitMemberMapper;
		this.resubmitListMapper = resubmitListMapper;
		this.mmsResubmitEvaluateMapper = mmsResubmitEvaluateMapper;
		this.mmsCallBackMapper = mmsCallBackMapper;
		this.mmsMemberTypeMapper = mmsMemberTypeMapper;
		this.wChatService = wChatService;
		this.importExcelTask = importExcelTask;
		this.redisUtils = redisUtils;
	}

	@Override
	@Transactional(rollbackFor = MmsBizException.class)
	public int saveResubmitList(Map<String, Object> userInfo, List<ReqMemberResubmitVO> reqVO) {
		int result = 0;
		if (ValidatorUtil.isNotEmpty(reqVO)) {
			List<ReqMemberResubmitVO> reqVO2 = reqVO.stream().filter(distinctByKey(ReqMemberResubmitVO::getMemberUid))
					.collect(Collectors.toList());
			List<ReqMemberResubmitVO> addVO = new ArrayList<ReqMemberResubmitVO>();
			reqVO2.stream().filter(vo -> ValidatorUtil.isEmpty(resubmitMemberMapper.getResubmitUids(vo.getMemberUid())))
					.forEach(addVO::add);
			List<MmsResubmitMember> insertList = new ArrayList<MmsResubmitMember>();
			List<MmsResubmitList> resubmits = new ArrayList<MmsResubmitList>();
			MmsResubmitMember resub = null;
			MmsResubmitList mit = null;
			if (ValidatorUtil.isEmpty(addVO)) {
				throw new MmsBizException(MmsBizException.DB_CODE, "你选择的学员全部插入转续报");
			}
			List<String> memberUid = addVO.stream().map(ReqMemberResubmitVO::getMemberUid).distinct()
					.collect(Collectors.toList());
			Map<String, String> memberForCellPhone = getCellPhoneByUid(memberUid);
			for (ReqMemberResubmitVO mmsResubmitMember : addVO) {
				resub = new MmsResubmitMember();
				BeanUtils.copyProperties(mmsResubmitMember, resub);
				resub.setOrderTime(DateUtil2.toDate(mmsResubmitMember.getOrderTime(), DateUtil2.FORMAT_DATE));
				resub.setMemberPhone(memberForCellPhone.get(mmsResubmitMember.getMemberUid()));
				resub.setDistributionState(OperationConstant.STATE_ALLOCATED);
				resub.setCreateTime(new Date());
				resub.setMemberType(null);
				resub.setFirstUpdateTime(null);
				insertList.add(resub);
			}
			if (ValidatorUtil.isNotEmpty(insertList)) {
				result = resubmitMemberMapper.insertListAndUid(insertList);
				if (result >= 1) {
					for (MmsResubmitMember member : insertList) {
						mit = new MmsResubmitList();
						mit.setMemberUid(member.getMemberUid());
						mit.setResubmitUid(member.getUid());
						mit.setOperateState(OperationConstant.STATE_ALLOCATED);
						mit.setUpdateTime(new Date());
						mit.setCreateTime(new Date());
						mit.setUpdateBy(userInfo.get("userName").toString());

						resubmits.add(mit);
					}
					if (ValidatorUtil.isNotEmpty(resubmits)) {
						result = resubmitListMapper.insertList(resubmits);
					}
				} else {
					throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，操作失败");
				}
			}
		}

		return result;
	}

	@Transactional(readOnly = true)
	private Map<String, String> getCellPhoneByUid(List<String> memberUid) {

		List<Map<String, String>> memberForCellPhone = memberMapper.getCellPhoneByUid(memberUid);
		Map<String, String> result = new HashMap<>(memberForCellPhone.size());

		memberForCellPhone.forEach(cellPhone -> {
			result.put(cellPhone.get("memberUid"), cellPhone.get("cellPhone"));
		});

		return result;
	}

	@Transactional(readOnly = true)
	public Map<String, Long> getResubmitUid(List<String> memberUids) {
		Map<String, Long> result = new HashMap<>();
		List<Map<String, String>> tmp = resubmitMemberMapper.getResubmitUid(memberUids);
		for (Map<String, String> map : tmp) {
			result.put(map.get("memberUid").toString(), ConvertUtil.toLong(map.get("uid")));
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public PageInfo<ResqResubmitVO> getResubmitMemberByPage(ReqResubmitPageVO pageVO) {
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		List<ResqResubmitVO> result = resubmitMemberMapper.resubmitMemberMapper(pageVO);
		for (ResqResubmitVO resqResubmitVO : result) {
			if (ValidatorUtil.isEmpty(resqResubmitVO.getMemberType())) {
				resqResubmitVO.setMemberTypes(Arrays.asList(OperationConstant.MEMBER_TYPE_01));
			} else {
				resqResubmitVO.setMemberTypes(Arrays.asList(resqResubmitVO.getMemberType().split(",")));
			}
		}
		return new PageInfo<>(result);
	}

	@Override
	@Transactional(rollbackFor = MmsBizException.class)
	public int allocationMember(Map<String, Object> userInfo, ReqDistributionVO reqDistributionVO) {
		if (!ValidatorUtil.isNotEmpty(reqDistributionVO.getMemberList())) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "分配学员失败：学员信息不可为空");
		}
		List<Long> uids = reqDistributionVO.getMemberList().stream().map(ReqResubmitUidVO::getUid).collect(Collectors.toList());
		// 更新第一次分配字段
		Example example = new Example(MmsResubmitMember.class);
		example.createCriteria().andIn("uid", uids).andIsNull("firstUpdateTime");
		MmsResubmitMember resubmitMember = new MmsResubmitMember();
		resubmitMember.setFirstUpdateTime(new Date());
		resubmitMemberMapper.updateByExampleSelective(resubmitMember, example);

		int result = resubmitMemberMapper.updateConsultInfo(reqDistributionVO);
		if (result >= 1) {
			List<ReqResubmitUidVO> resubmitUids = reqDistributionVO.getMemberList();
			List<MmsResubmitList> resubmits = new ArrayList<MmsResubmitList>();
			MmsResubmitList resubmit = null;
			for (ReqResubmitUidVO memberVO : resubmitUids) {
				resubmit = new MmsResubmitList();
				resubmit.setConsultId(reqDistributionVO.getUserId());
				resubmit.setConsultName(reqDistributionVO.getUserName());
				resubmit.setResubmitUid(memberVO.getUid());
				resubmit.setMemberUid(memberVO.getMemberId());
				resubmit.setUpdateTime(new Date());
				resubmit.setCreateTime(new Date());
				resubmit.setUpdateBy(userInfo.get("userName").toString());
				resubmit.setOperateState(OperationConstant.TWO);
				resubmits.add(resubmit);
			}
			result = resubmitListMapper.insertList(resubmits);
		} else {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，操作失败");
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Object getResubmitLogById(ReqResubmitUidVO memberUidVO) {

		List<RespDistributionLog> result = resubmitListMapper.getResubmitLog(memberUidVO.getMemberId());
		if (ValidatorUtil.isEmpty(result)) {
			return result;
		}
		for (int i = 0; i < result.size(); i++) {
			if (i == OperationConstant.ZERO) {
				result.get(OperationConstant.ZERO).setOperationContent(OperationEnum.OPERATION_IMPORT.getMsg());
			}
			if (i == OperationConstant.ONE) {
				result.get(OperationConstant.ONE).setOperationContent(
						OperationEnum.OPERATION_OPERATION.getMsg() + result.get(1).getConsultName());
			} else if (i >= OperationConstant.TWO) {
				result.get(i)
						.setOperationContent(OperationEnum.OPERATION_OTHER.getMsg() + result.get(i).getConsultName());
			}
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public PageInfo<RespMemberEvaluateVO> getMemberEvaluateByPage(ReqResubmitPageVO pageVO) {
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		List<RespMemberEvaluateVO> result = mmsResubmitEvaluateMapper.getMemberEvaluateByPage(pageVO);
		if (ValidatorUtil.isEmpty(result)) {
			return new PageInfo<>(result);
		}
		List<Long> resubmitUids = result.stream().map(RespMemberEvaluateVO::getUid).collect(Collectors.toList());
		Map<Long, Double> rant = getMemberEvaluate(resubmitUids);
		for (RespMemberEvaluateVO evaluateVO : result) {
			evaluateVO.setEvaluateRank(rant.get(evaluateVO.getUid()) == null ? 0 : rant.get(evaluateVO.getUid()));
			evaluateVO.setCellPhone("");
		}
		return new PageInfo<>(result);
	}

	@SuppressWarnings({ "unlikely-arg-type" })
	private Map<Long, Double> getMemberEvaluate(List<Long> resubmitUids) {
		Map<Long, Double> result = new HashMap<>();
		List<Map<Long, String>> evaluateRant = mmsResubmitEvaluateMapper.getEvaluateByMitUid(resubmitUids);
		for (Map<Long, String> map : evaluateRant) {
			result.put(ConvertUtil.toLong(map.get("resubmitUid")), Double.valueOf(map.get("evaluateRank").toString()));
		}

		return result;
	}

	@Override
	public int evaluateMember(Map<String, Object> userInfo, ReqEvaluateVO reqEvaluateVO) {
		int result = 0;

		if (ValidatorUtil.isNotEmpty(reqEvaluateVO)) {
			MmsResubmitEvaluate evaluate = MmsResubmitEvaluate.builder().resubmitUid(reqEvaluateVO.getResubmitUid())
					.memberUid(reqEvaluateVO.getMemberUid()).evaluateRank(reqEvaluateVO.getEvaluateRank())
					.consultId(userInfo.get("userId").toString()).consultName(userInfo.get("userName").toString())
					.createTime(new Date()).updateTime(new Date()).updateBy(userInfo.get("userName").toString())
					.build();

			result = mmsResubmitEvaluateMapper.insert(evaluate);
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Object getEvaluateHistoryInfo(ReqEvaluateVO reqEvaluateVO) {
		RespEvaluateVO result = new RespEvaluateVO();

		List<RespEvaluateRantVO> historyEvaluate = mmsResubmitEvaluateMapper
				.getHistoryEvaluate(reqEvaluateVO.getMemberUid());
		result.setEvaluateRantList(historyEvaluate);
		RespEvaluateRantVO rant = mmsResubmitEvaluateMapper.getEvaluateRant(reqEvaluateVO.getMemberUid());
		result.setEvaluateRantVO(rant);

		return result;
	}

	@Override
	public Object getResubmitMember(List<String> memberUids) {
		Map<String, Long> result = new HashMap<>();
		resubmitMemberMapper.getResubmitUid(memberUids).stream().forEach(info -> {
			result.put(info.get("memberUid"), ConvertUtil.toLong(info.get("uid")));

		});

		return result;
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Object saveCallInfo(Map<String, Object> userInfo, ReqCallBackVO callBackVO) {
		MmsCallBack mmsCallBack = new MmsCallBack();
		BeanUtils.copyProperties(callBackVO, mmsCallBack);
		mmsCallBack.setCreateTime(new Date());
		mmsCallBack.setConsultId(userInfo.get("userId").toString());
		mmsCallBack.setConsultName(userInfo.get("userName").toString());
		mmsCallBack.setNextCallTime(DateUtil2.toDate(callBackVO.getNextCallTime(), DateUtil2.FORMAT_DATE_TIME));
		int result = mmsCallBackMapper.insert(mmsCallBack);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, MmsBizException.DB_MSG);
		}

		MmsResubmitMember resubmitMember = resubmitMemberMapper.selectByPrimaryKey(callBackVO.getResubmitUid());
		if (ValidatorUtil.isNotEmpty(resubmitMember)) {
			if(null == callBackVO.getChangeType()){
				callBackVO.setChangeType(RetOut.ZERO);
			}
			resubmitMember.setWxChart(callBackVO.getWxChart());
			resubmitMember.setChangeType(callBackVO.getChangeType());
			resubmitMemberMapper.updateByPrimaryKeySelective(resubmitMember);
		}

		return WebTools.createSuccessMessage("提交成功");
	}

	private void setMemberType(MmsResubmitMember resubmitMember, List<ReqMemberTypeVO> memberTypes) {
		List<String> typeNames = memberTypes.stream().map(ReqMemberTypeVO::getTypeName).collect(Collectors.toList());
		if (ValidatorUtil.isEmpty(resubmitMember.getMemberType())) {
			resubmitMember.setMemberType(typeNames.stream().collect(Collectors.joining(",")));
		} else {
			HashSet<String> typeNameForOld = Sets.newHashSet(resubmitMember.getMemberType().split(","));
			typeNameForOld.addAll(typeNames);
			resubmitMember.setMemberType(typeNameForOld.stream().collect(Collectors.joining(",")));
		}
	}

	@Override
	public List<MmsCallBack> qryCallBackInfo(ReqResubmitUidVO uidVO) {
		Example example = new Example(MmsCallBack.class);
		example.createCriteria().andEqualTo("resubmitUid", uidVO.getUid());
		return mmsCallBackMapper.selectByExample(example);
	}

	@Override
	public List<RespExcelResubmitVO> queryResubmitMember(ReqResubmitPageVO req) {
		req.setPageNum(null);
		req.setPageSize(null);
		List<RespExcelResubmitVO> result = resubmitMemberMapper.importMemberMapper(req);
		result.stream().forEach(resubmitVO -> {
			if(resubmitVO.getWxChart().equals(1)){
				resubmitVO.setWxChart("已添加");
			}
			if(resubmitVO.getWxChart().equals(2)){
				resubmitVO.setWxChart("未添加");
			}
			if(resubmitVO.getChangeType().equals(1)){
				resubmitVO.setChangeType("续报");
			}
			if(resubmitVO.getChangeType().equals(2)){
				resubmitVO.setChangeType("老带新");
			}
		});
		return result;
	}


	@Override
	public void improtMemberByOrderItemSn(Map<String, Object> userInfo, List<Map<String, Object>> data)
			throws Exception {
		String userId = userInfo.get("userId").toString();
		if (!redisUtils.setIfAbsent(OperationConstant.TASK_IMPORT + userId, OperationConstant.ONE,
				OperationConstant.time)) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "只允许一个后台导入任务，请稍后重试");
		}
		
		importExcelTask.improtMemberByOrderItemSn(userInfo, data);
	}

	public void sendMessage(List<String> users, String resultMessage) {
		wChatService.sendMessage(RespKafkaMessageVO.builder().url(null).title(OperationConstant.TITLE_RESUBMIT)
				.content(resultMessage).users(users).build());
	}

}