package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsReserveOrdersAllot;
import com.sxmaps.mms.vo.resp.RespReserveOrdersAllotVO;

public interface MmsReserveOrdersAllotMapper extends CommonMapper<MmsReserveOrdersAllot> {

	List<RespReserveOrdersAllotVO> qryPageReserveOrders();
	
	String queryUserName(String uid);
}