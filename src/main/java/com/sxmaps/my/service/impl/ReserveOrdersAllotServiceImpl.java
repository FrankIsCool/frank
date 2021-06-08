package com.sxmaps.mms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.client.AuthenticationClient;
import com.sxmaps.mms.client.ReserveOrdersAllotClient;
import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsCampusMapper;
import com.sxmaps.mms.mapper.MmsReserveOrdersAllotMapper;
import com.sxmaps.mms.model.AuthSxDept;
import com.sxmaps.mms.model.JsonMessage;
import com.sxmaps.mms.model.MmsReserveOrdersAllot;
import com.sxmaps.mms.service.IReserveOrdersAllotService;
import com.sxmaps.mms.utils.ConvertUtil;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.TrackReservationVO;
import com.sxmaps.mms.vo.req.ReqOrdersAllotVO;
import com.sxmaps.mms.vo.req.ReqReserveOrdersAllotVO;
import com.sxmaps.mms.vo.req.ReqTrackReservationUidVo;
import com.sxmaps.mms.vo.req.ReqTrackreservationStateVO;
import com.sxmaps.mms.vo.req.UserIdVO;
import com.sxmaps.mms.vo.resp.RespOrdersAllotVO;
import com.sxmaps.mms.vo.resp.RespUserVO;

@Service
public class ReserveOrdersAllotServiceImpl implements IReserveOrdersAllotService {
	@Autowired
	private MmsReserveOrdersAllotMapper reserveOrdersAllotMapper;

	@Autowired
	private ReserveOrdersAllotClient reserveOrdersAllotClient;

	@Autowired
	private AuthenticationClient orgStructureClient;
	
	@Autowired
	private MmsCampusMapper campusMapper;

	/**
	 * 保存预约单分配单
	 * 
	 * @param reqReserveOrdersAllotVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, timeout = 3000)
	public RespOrdersAllotVO saveReserveOrders(ReqReserveOrdersAllotVO reqReserveOrdersAllotVo, Map<String, Object> cur)
			throws Exception {
		int result = 0;
		RespOrdersAllotVO allotVO = new RespOrdersAllotVO();
		List<MmsReserveOrdersAllot> mmsReserveOrdersAllots = new ArrayList<MmsReserveOrdersAllot>();
		if (ValidatorUtil.isEmpty(reqReserveOrdersAllotVo)
				|| ValidatorUtil.isEmpty(reqReserveOrdersAllotVo.getOrdersItemSn())) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "操作失败,分配单对象不可为空");
		}
		// 取出预约单uid
		for (ReqOrdersAllotVO opinionMapVo : reqReserveOrdersAllotVo.getOrdersItemSn()) {
			MmsReserveOrdersAllot record = new MmsReserveOrdersAllot();
			record.setOrderUid(opinionMapVo.getReservationUid());
			int count = reserveOrdersAllotMapper.selectCount(record);
			if (count > 0) {
				throw new MmsBizException(MmsBizException.BIZ_CODE, "操作失败，请检查预约单uid是否正确或已分配");
			}
			MmsReserveOrdersAllot mmsReserveOrdersAllot = new MmsReserveOrdersAllot();
			BeanUtils.copyProperties(reqReserveOrdersAllotVo, mmsReserveOrdersAllot);

			mmsReserveOrdersAllot.setOrderUid(opinionMapVo.getReservationUid());
			mmsReserveOrdersAllot.setCreateTime(DateUtil2.currentDate());
			mmsReserveOrdersAllot.setOperatorUid(ConvertUtil.toStringIgnoreBlank(cur.get("userId")));
			mmsReserveOrdersAllot.setOperatorName(ConvertUtil.toStringIgnoreBlank(cur.get("userName")));
			mmsReserveOrdersAllot.setState(OperationConstant.STATE_NORMAL);
			mmsReserveOrdersAllots.add(mmsReserveOrdersAllot);
		}
		// 添加预约单分配
		result = reserveOrdersAllotMapper.insertList(mmsReserveOrdersAllots);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常,保存预约分配单失败");
		}
		// 修改预约单状态
		for (ReqOrdersAllotVO opinionMapVo : reqReserveOrdersAllotVo.getOrdersItemSn()) {
			ReqTrackreservationStateVO stateVo = new ReqTrackreservationStateVO();
			stateVo.setState(OperationConstant.STATE_ALLOCATED);
			stateVo.setUid(opinionMapVo.getReservationUid());

			// 调用ftms服务修改状态
			JsonMessage ordersState = reserveOrdersAllotClient.ReserveOrdersState(stateVo);
			if (null == ordersState || null == ordersState.getData()) {
				throw new MmsBizException(MmsBizException.BIZ_CODE, "调用ftms服务异常,获取预约单信息列表失败");
			}
			Integer integer = ConvertUtil.toInteger(ordersState.getData());
			if (integer <= 0) {
				throw new MmsBizException(MmsBizException.DB_CODE, "调用ftms服务异常,修改预约单状态失败");
			}
		}
		BeanUtils.copyProperties(reqReserveOrdersAllotVo, allotVO);
		return allotVO;
	}

	/**
	 * 查询子预约单号是否已经存在
	 * 
	 * @param orderItemUid
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int qryOrderItemUidById(Long orderItemUid) throws MmsBizException {
		MmsReserveOrdersAllot mmsReserveOrdersAllot = new MmsReserveOrdersAllot();
		mmsReserveOrdersAllot.setOrderItemUid(orderItemUid);
		mmsReserveOrdersAllot.setState(OperationConstant.STATE_NORMAL);
		int result = reserveOrdersAllotMapper.selectCount(mmsReserveOrdersAllot);
		return result;
	}

	/**
	 * 查询子预约单uid是否已经存在
	 * 
	 * @param orderItemSn
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int qryOrderItemSnById(String orderItemSn) throws MmsBizException {
		MmsReserveOrdersAllot mmsReserveOrdersAllot = new MmsReserveOrdersAllot();
		mmsReserveOrdersAllot.setOrderItemSn(orderItemSn);
		mmsReserveOrdersAllot.setState(OperationConstant.STATE_NORMAL);
		int result = reserveOrdersAllotMapper.selectCount(mmsReserveOrdersAllot);
		return result;
	}

	@Override
	public List<RespUserVO> getReservationConsultantInfo(ReqTrackReservationUidVo vo) throws Exception {
		// 判断是否为空
		if (vo.getConsultantUid() == null) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "操作失败,咨询师uid不可为空");
		}
		// 赋值
		UserIdVO userIdVO = new UserIdVO();
		userIdVO.setUserId(vo.getConsultantUid());
		List<UserIdVO> userIds = new ArrayList<UserIdVO>();
		userIds.add(userIdVO);
		// 调用人员信息的接口
		JsonMessage result = orgStructureClient.queryUserListByUserIds(userIds);
		if (null == result || null == result.getData()) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "调用auth服务异常,获取人员组织架构信息失败");
		}
		List<RespUserVO> list = JSON.parseArray(JSONObject.toJSONString(result.getData()), RespUserVO.class);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object qryReserveOrdersInfo(TrackReservationVO trackReservationVo,Map<String, Object> user) {
		List<String> deptList;
		String deptId = null;
		if(user == null && ValidatorUtil.isEmpty(trackReservationVo.getDeptCodes())) {
			deptList = null;
		}else if(ValidatorUtil.isEmpty(trackReservationVo.getDeptCodes()) && user != null){
			//if(isManager(user)) {
				deptId = (String)user.get("sxDeptId");
				if(deptId == null) {
					return WebTools.createErrorMessage(500, "您的部门信息有误,请联系部门管理");
				}
			//}else {
			//	return WebTools.createSuccessMessage();
			//}
		}else {
			deptId = trackReservationVo.getDeptCodes().get(0);
		}
		deptList = getDeptList(deptId);
		
		if(!CollectionUtils.isEmpty(deptList) && deptList.size() < 20) {
			trackReservationVo.setDeptCodes(deptList);
		}
		
		
		
		
//		List<String> stateList = new ArrayList<>();
//		stateList.add("0");
//		stateList.add("1");
		//stateList.add("6");
		//stateList.add("8");
		//stateList.add("11");
//		trackReservationVo.setStateList(stateList);
		try {
			HashMap<String,Object> clientResult = (HashMap<String,Object>)reserveOrdersAllotClient.qryReserveOrdersInfo(trackReservationVo);
			/* HashMap<String,Object> clientData = (HashMap<String,Object>)clientResult.get("data");
			List<HashMap<String,Object>> clientList = (List<HashMap<String,Object>>)clientData.get("list");
			for(HashMap<String,Object> list:clientList) {
				String operatorUid = (String)list.get("operatorUid");
				list.put("operatorName", reserveOrdersAllotMapper.queryUserName(operatorUid));
			}
			clientData.put("list", clientList);
			clientResult.put("data", clientData); */
			return clientResult;
		} catch (Exception e) {
			return WebTools.createErrorMessage(500, "调取预约单错误.错误信息:"+e.getMessage());
		}
	}
	
	public List<String> getDeptList(String deptId) {
        List<AuthSxDept> depts = campusMapper.queryDeptList();
        List<AuthSxDept> tmp = new ArrayList<AuthSxDept>();
        for (AuthSxDept authDept : depts) {
            if (authDept.getDeptId().equals(deptId)) {
                tmp.add(authDept);
                treeDept(depts, authDept, tmp);
            }
        }
        if (tmp.size() == 0) {
            return null;
        }
        List<String> resultList = new ArrayList<String>();
        for (AuthSxDept authDept : tmp) {
            resultList.add(authDept.getDeptId());
        }
        return resultList;
    }

    /*
     * 获取当前部门下所有的子部门
     */
    public void treeDept(List<AuthSxDept> depts, AuthSxDept authDept, List<AuthSxDept> tmp) {
        for (AuthSxDept tm : depts) {
            if (authDept.getDeptId().equals(tm.getParentId())) {
                tmp.add(tm);
                treeDept(depts, tm, tmp);
            }
        }
    }
    
    public boolean isManager(Map<String,Object> map) throws MmsBizException{
		String isManager = (String)map.get("manger");
		if(ValidatorUtil.isEmpty(isManager)) {
			throw new MmsBizException(400, "您没有角色信息,请与部门管理员联系");
		}else if("0".equals(isManager)) {
			return false;
		}else {
			return true;
		}
	}

}
