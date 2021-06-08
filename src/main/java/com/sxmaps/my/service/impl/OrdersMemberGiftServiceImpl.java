package com.sxmaps.mms.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.OrdersMemberGiftMapper;
import com.sxmaps.mms.model.JsonMessage;
import com.sxmaps.mms.model.OrdersMemberGift;
import com.sxmaps.mms.service.IOrdersMemberGiftService;
import com.sxmaps.mms.utils.EasyPoiUtils;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.ExportOrderOnlineVO;
import com.sxmaps.mms.vo.req.ReqQryOrdersMemberGiftListVO;
import com.sxmaps.mms.vo.req.ReqUpdateOrdersMemberGiftVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersMemberGiftListVO;

@Service
public class OrdersMemberGiftServiceImpl implements IOrdersMemberGiftService {
	
	@Autowired
	OrdersMemberGiftMapper ordersMemberGiftMapper;
	
	@Autowired
	EasyPoiUtils easyPoiUtils;

	@Override
	public PageInfo<RespQryOrdersMemberGiftListVO> qryOrdersMemberGiftList(ReqQryOrdersMemberGiftListVO req) {
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespQryOrdersMemberGiftListVO> resp = ordersMemberGiftMapper.qryOrdersMemberGiftList(req);
		return new PageInfo<RespQryOrdersMemberGiftListVO>(resp);
	}

	@Override
	public JsonMessage updateOrdersMemberGift(ReqUpdateOrdersMemberGiftVO req) {
		OrdersMemberGift gift = ordersMemberGiftMapper.selectByPrimaryKey(req.getUid());
		if(gift == null) {
			throw new MmsBizException(500, "查无指定礼品赠送记录");
		}
		OrdersMemberGift newGift = new OrdersMemberGift();
		BeanUtils.copyProperties(req, newGift);
		StringBuffer address = new StringBuffer();
		address.append(req.getProvinceName());
		address.append(req.getCityName());
		address.append(req.getCountyName());
		address.append(req.getStreet());
		newGift.setAddress(address.toString());
		int result = ordersMemberGiftMapper.updateByPrimaryKeySelective(newGift);
		if(result < 0) {
			throw new MmsBizException(500, "更新失败,请稍后再试");
		}
		return WebTools.createSuccessMessage("更新成功");
	}

	@Override
	public void exportOrdersMemberGift(ReqQryOrdersMemberGiftListVO req, HttpServletResponse response) throws Exception {
		req.setPageNum(null);
		req.setPageSize(null);
		List<ExportOrderOnlineVO> exportList = ordersMemberGiftMapper.exportOrdersMemberGift(req);
		easyPoiUtils.exportExcel(exportList, "礼品赠送记录", "礼品赠送记录", ExportOrderOnlineVO.class, "礼品赠送记录.xls", response);
	}

}
