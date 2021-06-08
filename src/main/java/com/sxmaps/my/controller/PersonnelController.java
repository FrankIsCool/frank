package com.sxmaps.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IPersonnelService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.req.ReqOrderTypeVO;
import com.sxmaps.mms.vo.req.ReqPersonnelVO;
import com.sxmaps.mms.vo.resp.RespUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年4月16日
 */
@RestController
@RequestMapping("/personnel")
@Api(value = "人员信息接口管理", tags = "人员信息接口管理")
public class PersonnelController {
	@Autowired
	private IPersonnelService iPersonnelService;

	@PostMapping("/queryUserListByUserIds")
	@ApiOperation(value = "根据orderItemId查询用户信息List", notes = "根据orderItemId查询用户信息集合", response = RespUserVO.class)
	@ApiImplicitParam(name = "personnelVO", value = "personnelVO 实体", dataType = "ReqPersonnelVO")
	public Object queryUserListByUserIds(@Validated @RequestBody ReqPersonnelVO personnelVO) throws Exception {
		try {
			return iPersonnelService.queryUserListByUserId(personnelVO);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}

	}

	@PostMapping("/queryUserListByOrderId")
	@ApiOperation(value = "根据orderUid查询用户信息List", notes = "根据orderUid查询用户信息List", response = RespUserVO.class)
	@ApiImplicitParam(name = "orderTypeVO", value = "orderTypeVO 实体", dataType = "ReqOrderTypeVO")
	public Object queryUserListByOrderId(@Validated @RequestBody ReqOrderTypeVO orderTypeVO) throws Exception {
		try {
			return iPersonnelService.queryUserListByOrderId(orderTypeVO);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}
}
