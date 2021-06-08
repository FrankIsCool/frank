package com.sxmaps.mms.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxmaps.mms.vo.resp.RespProtocolInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sxmaps.mms.client.FileClient;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsScoreStarMapper;
import com.sxmaps.mms.service.IProtocolService;
import com.sxmaps.mms.utils.AmountCodeUtils;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.utils.RetOut;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.vo.OssFilePathVo;
import com.sxmaps.mms.vo.req.ReqProtocolLevelVO;
import com.sxmaps.mms.vo.req.ReqProtocolVO;
import com.sxmaps.mms.vo.resp.RespProtocolLevelVO;
import com.sxmaps.mms.vo.resp.RespProtocolVO;

@Service
public class ProtocolServiceImpl implements IProtocolService {

	@Autowired
	MmsScoreStarMapper mapper;

	@Autowired
	FileClient fileClient;

	@Autowired
	AmountCodeUtils amountCodeUtils;

	//2019-09-10时间戳
	final long oldStampTime = 1568044800000l;
	//2020-01-05时间戳
	final long showMBATime = 1578153600000l;
	//2020-09-23时间戳
	final long showCollegeTime = 1600704000000l;
	/**
	 * 根据层级ID获取协议信息
	 * 
	 * @param levelVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public RespProtocolLevelVO qryProtocolByProLevel(ReqProtocolLevelVO levelVO) throws MmsBizException {
		RespProtocolLevelVO level = mapper.qryProtocolByProLevel(levelVO);
		if (level == null) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败,查无数据");
		}
		if (!StringUtils.isEmpty(level.getSignUrl())) {
			OssFilePathVo path = new OssFilePathVo();
			List<String> pathList = new ArrayList<>();
			pathList.add(level.getSignUrl());
			path.setFilePaths(pathList);
			try {
				Map<String, Object> resp = (Map<String, Object>) fileClient.getOssPrivateBucketFilesUrl("1", path);
				if (resp == null || !resp.get("code").equals(200)) {
					throw new MmsBizException(500, "查询文件服务错误");
				}
				Map<String, String> data = (Map<String, String>) resp.get("data");
				level.setSignUrl(data.get(level.getSignUrl()));
			} catch (Exception e) {
				throw new MmsBizException(500, "查询文件服务错误");
			}
		}
		return level;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RespProtocolVO qryProtocolByOrderItemSn(ReqProtocolVO reqProtocolVO) throws Exception {
		RespProtocolVO protocol = mapper.qryProtocolByOrderItemSn(reqProtocolVO.getOrderItemSn());
		if (null == protocol) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "查无协议记录");
		}
		Map<String,Object> order = mapper.qryItemAmountAndPaidAmount(reqProtocolVO.getOrderItemSn());
		if(order == null) {
			throw new MmsBizException(500, "查无订单信息");
		}
		Date signDate = DateUtil2.toDate(protocol.getSignTime(), DateUtil2.FORMAT_DATE);
		long signTime = signDate.getTime();
		double percent = 1.0;
		String orderSn = order.get("orderSn").toString();
		int orderCount = mapper.countOrderItemByOrderSn(orderSn);
		BigDecimal firstPay = mapper.qryFirstPayByOrderSn(orderSn,percent);
		BigDecimal loanPay = BigDecimal.ZERO;
		String amountRemark = null;
		if(firstPay != null) {
			//protocol.setFirstPay(firstPay.toString());
			loanPay = mapper.qryLoanPayByOrderSn(orderSn,percent);
		}
		if(firstPay != null && loanPay != null && loanPay.compareTo(BigDecimal.ZERO) == 1) {
			amountRemark = "(首付"+firstPay.toString()+"元,分期付款"+loanPay.toString()+"元";
			if(orderCount == 1) {
				amountRemark = amountRemark + ")";
			}else if(orderCount == 2) {
				amountRemark = amountRemark + " 注:首付、分期金额针对主订单,多个订单一起支付显示合计的值)";
			}
			protocol.setAmountRemark(amountRemark);
		}
		if (ValidatorUtil.isNotEmpty(protocol.getSignTime())) {
			if(signTime > oldStampTime) {
				protocol.setShowStamp(1);
			}else {
				protocol.setShowStamp(2);
			}
		}
		Long orderItemId = (long)order.get("uid");
		Integer exchangeContract = mapper.countExchangedContract(orderItemId);
		if(exchangeContract > 0) {
			protocol.setShowSign(2);
		}else {
			protocol.setShowSign(1);
		}
		//通过协议名称+签名日期判断是否为国际MBA协议(需修改协议头部分内容)
		String contractName = protocol.getProName();
		if(contractName == null || !contractName.equals("升学教育国际硕士学位培训协议")) {
			protocol.setShowMBAsupply("2");
		}else {
			try {
				if(signTime > showMBATime) {
					protocol.setShowMBAsupply("1");
				}else {
					protocol.setShowMBAsupply("2");
				}
			} catch (Exception e) {
				protocol.setShowMBAsupply("2");
			}
		}
		//通过签名日期+订单级别判断是否需要展示学校
		if(signTime > showCollegeTime) {
			if(ValidatorUtil.isNotEmpty(protocol.getLevelId()) && (protocol.getLevelId().equals(RetOut.ONE_STR) || protocol.getLevelId().equals(RetOut.TWO_STR))) {
				protocol.setCollegeName(null);
			}else if(ValidatorUtil.isNotEmpty(protocol.getLevelTypeName()) && (protocol.getLevelTypeName().equals("自考本科") || protocol.getLevelTypeName().equals("自考本科"))) {
				protocol.setCollegeName(null);
			}
		}
		
		if (!StringUtils.isEmpty(protocol.getCostFee())) {
			protocol.setCostFeeUppercase(amountCodeUtils.digitUppercase(Double.parseDouble(protocol.getCostFee())));
		}
		String signUrl = protocol.getSignUrl();
		if (StringUtils.isEmpty(signUrl) || signUrl.substring(0, 10).equals("http://and")) {
		}else {
			OssFilePathVo path = new OssFilePathVo();
			List<String> pathList = new ArrayList<>();
			pathList.add(signUrl);
			path.setFilePaths(pathList);
			try {
				Map<String, Object> resp = (Map<String, Object>) fileClient.getOssPrivateBucketFilesUrl(RetOut.ONE_STR,
						path);
				if (resp == null || !RetOut.SUCCESS_CODE.equals(resp.get("code").toString())) {
					// throw new MmsBizException(500, "服务超时,请多刷新重试几下");
				} else {
					Map<String, String> data = (Map<String, String>) resp.get("data");
					protocol.setSignUrl(data.get(signUrl));
				}
			} catch (Exception e) {
				throw new MmsBizException(500, "服务器正在拼命加载签名图片,请多刷新重试几下");
			}
		}
		return protocol;
	}
	@SuppressWarnings("unchecked")
	@Override
	public RespProtocolInfoVO qryProtocolByOrderItemSn2(String orderItemSn) throws Exception {
		RespProtocolInfoVO protocol = mapper.qryProtocolByOrderItemSn2(orderItemSn);
		if (null == protocol) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "查无协议记录");
		}
		Date signDate = DateUtil2.toDate(protocol.getSignTime(), DateUtil2.FORMAT_DATE);
		long signTime = signDate.getTime();
		double percent = 1.0;
		int orderCount = mapper.countOrderItemByOrderSn(protocol.getOrderSn());
		BigDecimal firstPay = mapper.qryFirstPayByOrderSn(protocol.getOrderSn(),percent);
		BigDecimal loanPay = BigDecimal.ZERO;
		String amountRemark = null;
		if(firstPay != null) {
			loanPay = mapper.qryLoanPayByOrderSn(protocol.getOrderSn(),percent);
		}
		if(firstPay != null && loanPay != null && loanPay.compareTo(BigDecimal.ZERO) == 1) {
			amountRemark = "(首付"+firstPay.toString()+"元,分期付款"+loanPay.toString()+"元";
			if(orderCount == 1) {
				amountRemark = amountRemark + ")";
			}else if(orderCount == 2) {
				amountRemark = amountRemark + " 注:首付、分期金额针对主订单,多个订单一起支付显示合计的值)";
			}
			protocol.setAmountRemark(amountRemark);
		}
		if (ValidatorUtil.isNotEmpty(protocol.getSignTime())) {
			if(signTime > oldStampTime) {
				protocol.setShowStamp(1);
			}else {
				protocol.setShowStamp(2);
			}
		}
		Integer exchangeContract = mapper.countExchangedContract(protocol.getOrderItemUid());
		if(exchangeContract > 0) {
			protocol.setShowSign(2);
		}else {
			protocol.setShowSign(1);
		}
		//通过协议名称+签名日期判断是否为国际MBA协议(需修改协议头部分内容)
		String contractName = protocol.getProName();
		if(contractName == null || !contractName.equals("升学教育国际硕士学位培训协议")) {
			protocol.setShowMBAsupply("2");
		}else {
			try {
				if(signTime > showMBATime) {
					protocol.setShowMBAsupply("1");
				}else {
					protocol.setShowMBAsupply("2");
				}
			} catch (Exception e) {
				protocol.setShowMBAsupply("2");
			}
		}
		//通过签名日期+订单级别判断是否需要展示学校
		if(signTime > showCollegeTime) {
			if(ValidatorUtil.isNotEmpty(protocol.getLevelId()) && (protocol.getLevelId().equals(RetOut.ONE_STR) || protocol.getLevelId().equals(RetOut.TWO_STR))) {
				protocol.setCollegeName(null);
			}else if(ValidatorUtil.isNotEmpty(protocol.getLevelTypeName()) && (protocol.getLevelTypeName().equals("自考本科") || protocol.getLevelTypeName().equals("自考本科"))) {
				protocol.setCollegeName(null);
			}
		}
		if (!StringUtils.isEmpty(protocol.getCostFee())) {
			protocol.setCostFeeUppercase(amountCodeUtils.digitUppercase(Double.parseDouble(protocol.getCostFee())));
		}
		String signUrl = protocol.getSignUrl();
		if (StringUtils.isEmpty(signUrl)) {
			protocol.setSignUrl("");
		}
		else if(signUrl.startsWith("http://and"))
		{
			protocol.setSignUrl(signUrl+"?date="+System.currentTimeMillis());
		}
		else {
			OssFilePathVo path = new OssFilePathVo();
			List<String> pathList = new ArrayList<>();
			pathList.add(signUrl);
			path.setFilePaths(pathList);
			try {
				Map<String, Object> resp = (Map<String, Object>) fileClient.getOssPrivateBucketFilesUrl(RetOut.ONE_STR,
						path);
				if (resp == null || !RetOut.SUCCESS_CODE.equals(resp.get("code").toString())) {
					// throw new MmsBizException(500, "服务超时,请多刷新重试几下");
				} else {
					Map<String, String> data = (Map<String, String>) resp.get("data");
					protocol.setSignUrl(data.get(signUrl));
				}
			} catch (Exception e) {
				throw new MmsBizException(500, "服务器正在拼命加载签名图片,请多刷新重试几下");
			}
		}
		return protocol;
	}
	@SuppressWarnings("unchecked")
	@Override
	public RespProtocolVO qryProtocolByOrderItemSnForTeacher(ReqProtocolVO reqProtocolVO) throws Exception {
		RespProtocolVO protocol = mapper.qryProtocolByOrderItemSn(reqProtocolVO.getOrderItemSn());
		if (null == protocol) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "查无协议记录");
		}
		if (ValidatorUtil.isEmpty(reqProtocolVO.getIsWatchable()) || !reqProtocolVO.getIsWatchable()) {
			if(protocol.getCellphone().length() >= 11) {
				protocol.setCellphone(protocol.getCellphone().substring(0, 3).concat("****").concat(protocol.getCellphone().substring(7,11)));
				protocol.setLoginName(protocol.getLoginName().substring(0, 3).concat("****").concat(protocol.getLoginName().substring(7,11)));
			}
			protocol.setIdCard("****");
		}
		Map<String,Object> order = mapper.qryItemAmountAndPaidAmount(reqProtocolVO.getOrderItemSn());
		if(order == null) {
			throw new MmsBizException(500, "查无订单信息");
		}
		Date signDate = DateUtil2.toDate(protocol.getSignTime(), DateUtil2.FORMAT_DATE);
		long signTime = signDate.getTime();
		double percent = 1.0;
		String orderSn = order.get("orderSn").toString();
		int orderCount = mapper.countOrderItemByOrderSn(orderSn);
		BigDecimal firstPay = mapper.qryFirstPayByOrderSn(orderSn,percent);
		BigDecimal loanPay = BigDecimal.ZERO;
		String amountRemark = null;
		if(firstPay != null) {
			//protocol.setFirstPay(firstPay.toString());
			loanPay = mapper.qryLoanPayByOrderSn(orderSn,percent);
		}
		if(firstPay != null && loanPay != null && loanPay.compareTo(BigDecimal.ZERO) == 1) {
			amountRemark = "(首付"+firstPay.toString()+"元,分期付款"+loanPay.toString()+"元";
			if(orderCount == 1) {
				amountRemark = amountRemark + ")";
			}else if(orderCount >= 2) {
				amountRemark = amountRemark + " 注:首付、分期金额针对主订单,多个订单一起支付显示合计的值)";
			}
			protocol.setAmountRemark(amountRemark);
		}
		if (ValidatorUtil.isNotEmpty(protocol.getSignTime())) {
			if(signTime > oldStampTime) {
				protocol.setShowStamp(1);
			}else {
				protocol.setShowStamp(2);
			}
		}
		Long orderItemId = (long)order.get("uid");
		Integer exchangeContract = mapper.countExchangedContract(orderItemId);
		if(exchangeContract > 0) {
			protocol.setShowSign(2);
		}else {
			protocol.setShowSign(1);
		}
		//通过协议名称+签名日期判断是否为国际MBA协议(需修改协议头部分内容)
		String contractName = protocol.getProName();
		if(contractName == null || !contractName.equals("升学教育国际硕士学位培训协议")) {
			protocol.setShowMBAsupply("2");
		}else {
			try {
				if(signTime > showMBATime) {
					protocol.setShowMBAsupply("1");
				}else {
					protocol.setShowMBAsupply("2");
				}
			} catch (Exception e) {
				protocol.setShowMBAsupply("2");
			}
		}
		//通过签名日期+订单级别判断是否需要展示学校
		if(signTime > showCollegeTime) {
			if(ValidatorUtil.isNotEmpty(protocol.getLevelId()) && (protocol.getLevelId().equals(RetOut.ONE_STR) || protocol.getLevelId().equals(RetOut.TWO_STR))) {
				protocol.setCollegeName(null);
			}else if(ValidatorUtil.isNotEmpty(protocol.getLevelTypeName()) && (protocol.getLevelTypeName().equals("自考本科") || protocol.getLevelTypeName().equals("自考本科"))) {
				protocol.setCollegeName(null);
			}
		}
		if (!StringUtils.isEmpty(protocol.getCostFee())) {
			protocol.setCostFeeUppercase(amountCodeUtils.digitUppercase(Double.parseDouble(protocol.getCostFee())));
		}
		String signUrl = protocol.getSignUrl();
		if (StringUtils.isEmpty(signUrl)) {
			protocol.setSignUrl("");
		}else if(signUrl.startsWith("http://and")) {
			protocol.setSignUrl(signUrl+"?date="+System.currentTimeMillis());
		}else {
			OssFilePathVo path = new OssFilePathVo();
			List<String> pathList = new ArrayList<>();
			pathList.add(signUrl);
			path.setFilePaths(pathList);
			try {
				Map<String, Object> resp = (Map<String, Object>) fileClient.getOssPrivateBucketFilesUrl(RetOut.ONE_STR,
						path);
				if (resp == null || !RetOut.SUCCESS_CODE.equals(resp.get("code").toString())) {
					// throw new MmsBizException(500, "服务超时,请多刷新重试几下");
				} else {
					Map<String, String> data = (Map<String, String>) resp.get("data");
					protocol.setSignUrl(data.get(signUrl));
				}
			} catch (Exception e) {
				throw new MmsBizException(500, "服务器正在拼命加载签名图片,请多刷新重试几下");
			}
		}
		return protocol;
	}
}
