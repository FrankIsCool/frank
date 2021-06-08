package com.sxmaps.mms.service;

import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.model.JsonMessage;
import com.sxmaps.mms.vo.req.ReqQryOrdersMemberGiftListVO;
import com.sxmaps.mms.vo.req.ReqUpdateOrdersMemberGiftVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersMemberGiftListVO;

public interface IOrdersMemberGiftService {
	/**
	 * 查询礼品赠送记录列表
	 * @param req
	 * @return
	 */
	PageInfo<RespQryOrdersMemberGiftListVO> qryOrdersMemberGiftList(ReqQryOrdersMemberGiftListVO req);
	
	/**
	 * 更新礼品收件人信息
	 * @param req
	 * @return
	 */
	JsonMessage updateOrdersMemberGift(ReqUpdateOrdersMemberGiftVO req);
	
	/**
	 * 导出礼品赠送记录列表
	 * @param req
	 * @return
	 */
	void exportOrdersMemberGift(ReqQryOrdersMemberGiftListVO req, HttpServletResponse response) throws Exception;
}
