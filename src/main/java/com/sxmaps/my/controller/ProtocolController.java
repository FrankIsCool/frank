package com.sxmaps.mms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sxmaps.mms.vo.resp.RespProtocolInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.service.IProtocolService;
import com.sxmaps.mms.vo.req.ReqProtocolLevelVO;
import com.sxmaps.mms.vo.req.ReqProtocolVO;
import com.sxmaps.mms.vo.resp.RespProtocolLevelVO;
import com.sxmaps.mms.vo.resp.RespProtocolVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年5月14日
 */
@RestController
@RequestMapping("/protocol")
@Api(value = "协议管理", tags = "协议管理")
public class ProtocolController extends BaseController{
	@Autowired
	private IProtocolService protocolService;

	/**
	 * 根据级别id查询订单详情
	 * 
	 * @param levelVO
	 * @return
	 */
	@PostMapping("/notcheck/qryProtocolByLevelId")
	@ApiOperation(value = "根据层级ID获取协议信息", notes = "根据层级ID获取协议信息", response = RespProtocolLevelVO.class)
	@ApiImplicitParam(name = "levelVO", value = "levelVO 实体", dataType = "ReqProtocolLevelVO")
	public Object qryProtocolByLevelId(@Validated @RequestBody ReqProtocolLevelVO levelVO) {
		return protocolService.qryProtocolByProLevel(levelVO);

	}

	/**
	 * 根据子订单号查询协议
	 * 
	 * @param reqProtocolVO
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/notcheck/qryProtocolByOrderItemSn")
	@ApiOperation(value = "根据子订单号查询协议", notes = "根据子订单号查询协议", response = RespProtocolVO.class)
	@ApiImplicitParam(name = "reqProtocolVO", value = "reqProtocolVO 实体", dataType = "ReqProtocolVO")
	public Object qryProtocolByOrderItemSn(@Validated @RequestBody ReqProtocolVO reqProtocolVO) throws Exception {
		return protocolService.qryProtocolByOrderItemSn(reqProtocolVO);
	}
	/**
	 * 根据子订单号查询协议
	 *
	 * @param reqProtocolVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/notcheck/qryProtocolByOrderItemSn2")
	@ApiOperation(value = "根据子订单号查询协议", notes = "根据子订单号查询协议", response = RespProtocolInfoVO.class)
	@ApiImplicitParam(name = "reqProtocolVO", value = "reqProtocolVO 实体", dataType = "ReqProtocolVO")
	public Object qryProtocolByOrderItemSn2(@Validated @RequestBody ReqProtocolVO reqProtocolVO) throws Exception {
		return protocolService.qryProtocolByOrderItemSn2(reqProtocolVO.getOrderItemSn());
	}
	/**
	 * 根据子订单号查询协议
	 * 
	 * @param reqProtocolVO
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/notcheck/qryProtocolByOrderItemSnForTeacher")
	@ApiOperation(value = "根据子订单号查询协议", notes = "根据子订单号查询协议", response = RespProtocolVO.class)
	@ApiImplicitParam(name = "reqProtocolVO", value = "reqProtocolVO 实体", dataType = "ReqProtocolVO")
	public Object qryProtocolByOrderItemSnForTeacher(@Validated @RequestBody ReqProtocolVO reqProtocolVO) throws Exception {
		return protocolService.qryProtocolByOrderItemSnForTeacher(reqProtocolVO);
	}
}
