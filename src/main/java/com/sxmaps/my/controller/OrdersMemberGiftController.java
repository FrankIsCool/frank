package com.sxmaps.mms.controller;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.model.JsonMessage;
import com.sxmaps.mms.service.IOrdersMemberGiftService;
import com.sxmaps.mms.vo.req.ReqQryOrdersMemberGiftListVO;
import com.sxmaps.mms.vo.req.ReqUpdateOrdersMemberGiftVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersMemberGiftListVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 礼品赠送相关controller
 * @author liwenxin
 *
 */
@RestController
@RequestMapping("/gift")
@Api(value = "礼品赠送相关接口", tags = "礼品赠送相关接口")
public class OrdersMemberGiftController {
	
	@Autowired
	IOrdersMemberGiftService ordersMemberGiftService;
	
	/**
	 * 查询礼品赠送记录列表
	 * @return
	 */
	@PostMapping("/qryOrdersMemberGiftList")
	@ApiOperation(value = "查询礼品赠送记录列表", notes = "查询礼品赠送记录列表", response = RespQryOrdersMemberGiftListVO.class)
	@ApiImplicitParam(name = "req", value = "查询礼品赠送记录列表实体", dataType = "ReqQryOrdersMemberGiftListVO")
	public Object qryOrdersMemberGiftList(@RequestBody @Validated ReqQryOrdersMemberGiftListVO req) {
		return ordersMemberGiftService.qryOrdersMemberGiftList(req);
	}
	
	/**
	 * 更新礼品赠送记录
	 * @return
	 */
	@PostMapping("/updateOrdersMemberGift")
	@ApiOperation(value = "更新礼品赠送记录", notes = "更新礼品赠送记录", response = JsonMessage.class)
	@ApiImplicitParam(name = "req", value = "更新礼品赠送记录实体", dataType = "ReqUpdateOrdersMemberGiftVO")
	public Object updateOrdersMemberGift(@RequestBody @Validated ReqUpdateOrdersMemberGiftVO req) {
		return ordersMemberGiftService.updateOrdersMemberGift(req);
	}
	
	@GetMapping("/notcheck/exportOrdersMemberGift")
	@ApiOperation(value = "导出礼品赠送记录列表", notes = "导出礼品赠送记录列表")
	public void exportOrdersMemberGift(HttpServletResponse response,String dataParm) {
		try {
		dataParm = dataParm.replaceAll(" ", "+");
		dataParm = dataParm.replaceAll("\n", "");
		dataParm = new String(Base64.decodeBase64(dataParm.getBytes("utf-8")), "utf-8");
		ReqQryOrdersMemberGiftListVO req = JSONObject.parseObject(dataParm, ReqQryOrdersMemberGiftListVO.class);
		ordersMemberGiftService.exportOrdersMemberGift(req, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
