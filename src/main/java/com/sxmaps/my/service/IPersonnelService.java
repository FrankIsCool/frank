package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.vo.req.ReqOrderTypeVO;
import com.sxmaps.mms.vo.req.ReqPersonnelVO;
import com.sxmaps.mms.vo.req.ReqQryOrdersByDeptIdVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersByDeptIdVO;
import com.sxmaps.mms.vo.resp.RespUserVO;

/**
 * sss
 * 
 * @author gongqingzhuan
 *
 * @data 2018年4月9日
 */
public interface IPersonnelService {

	/**
	 * 根据订单ItemID获取人员信息
	 * 
	 * @param qryOrderId
	 * @return
	 * @throws Exception
	 */

	List<RespUserVO> queryUserListByUserId(ReqPersonnelVO personnelVO) throws Exception;

	/**
	 * 根据订单ID获取人员信息
	 * 
	 * @param orderTypeVO
	 * @return
	 * @throws Exception
	 */
	List<RespUserVO> queryUserListByOrderId(ReqOrderTypeVO orderTypeVO) throws Exception;
	
	/**
	 * 部门查询订单信息
	 * @param req
	 * @return
	 */
	List<RespQryOrdersByDeptIdVO> qryOrdersByDeptIdVO(ReqQryOrdersByDeptIdVO req) throws Exception;

}
