package com.sxmaps.mms.mapper;

import java.util.List;
import java.util.Map;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.OrdersMemberProp;
import com.sxmaps.mms.vo.req.ReqOrderTypeVO;
import com.sxmaps.mms.vo.req.ReqPersonnelVO;
import com.sxmaps.mms.vo.req.ReqQryOrdersByDeptIdVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersByDeptIdVO;

public interface OrdersMemberPropMapper extends CommonMapper<OrdersMemberProp> {

	Map<String, String> qryOrderItemIdByperson(ReqPersonnelVO personnelVO);

	Map<String, String> qryOrderUidByperson(ReqOrderTypeVO orderTypeVO);

	int qryCountByUid(Long uid);
	
	List<RespQryOrdersByDeptIdVO> qryOrdersByDeptIdVO(ReqQryOrdersByDeptIdVO req);
}