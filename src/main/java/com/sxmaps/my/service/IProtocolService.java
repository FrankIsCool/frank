package com.sxmaps.mms.service;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.req.ReqProtocolLevelVO;
import com.sxmaps.mms.vo.req.ReqProtocolVO;
import com.sxmaps.mms.vo.resp.RespProtocolInfoVO;
import com.sxmaps.mms.vo.resp.RespProtocolLevelVO;
import com.sxmaps.mms.vo.resp.RespProtocolVO;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年5月14日
 */
public interface IProtocolService {

	/**
	 * 根据层级ID获取协议信息
	 * 
	 * @param levelVO
	 * @return
	 */
	RespProtocolVO qryProtocolByOrderItemSn(ReqProtocolVO reqProtocolVO) throws Exception;
	/**
	 * 根据层级ID获取协议信息 - 电审之前获取协议内容
	 *
	 * @param orderItemSn 子订单号
	 * @return
	 */
	RespProtocolInfoVO qryProtocolByOrderItemSn2(String orderItemSn) throws Exception;
	
	/**
	 * 根据层级ID获取协议信息
	 * 
	 * @param levelVO
	 * @return
	 */
	RespProtocolVO qryProtocolByOrderItemSnForTeacher(ReqProtocolVO reqProtocolVO) throws Exception;

	/**
	 * 根据层级ID获取协议信息
	 * 
	 * @param levelVO
	 * @return
	 */
	RespProtocolLevelVO qryProtocolByProLevel(ReqProtocolLevelVO levelVO) throws MmsBizException;

}
