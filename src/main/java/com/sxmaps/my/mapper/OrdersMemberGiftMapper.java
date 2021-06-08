package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.OrdersMemberGift;
import com.sxmaps.mms.vo.ExportOrderOnlineVO;
import com.sxmaps.mms.vo.req.ReqQryOrdersMemberGiftListVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersMemberGiftListVO;

public interface OrdersMemberGiftMapper extends CommonMapper<OrdersMemberGift> {
	
	/**
	 * 查询礼品赠送记录列表
	 * @param req
	 * @return
	 */
	List<RespQryOrdersMemberGiftListVO> qryOrdersMemberGiftList(ReqQryOrdersMemberGiftListVO req);
	
	/**
	 * 导出礼品赠送记录列表
	 * @param req
	 * @return
	 */
	List<ExportOrderOnlineVO> exportOrdersMemberGift(ReqQryOrdersMemberGiftListVO req);
}