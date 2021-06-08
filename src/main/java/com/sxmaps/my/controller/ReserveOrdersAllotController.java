/**
 * 
 */
package com.sxmaps.mms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IReserveOrdersAllotService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.req.ReqReserveOrdersAllotVO;
import com.sxmaps.mms.vo.resp.RespOrdersAllotVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
@RestController
@RequestMapping("/reserveOrders")
@Api(value = "预约单分配管理", tags = "预约单分配管理")
public class ReserveOrdersAllotController extends BaseController {

	@Autowired
	private IReserveOrdersAllotService iReserveOrdersAllotService;

	/**
	 * 保存预约单分配
	 * 
	 * @param reqReserveOrdersAllotVo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/saveReserveOrders")
	@ApiOperation(notes = "保存预约单分配", value = "保存预约单分配", response = RespOrdersAllotVO.class)
	@ApiImplicitParam(name = "reqReserveOrdersAllotVo", value = "reqReserveOrdersAllotVo 实体", dataType = "ReqReserveOrdersAllotVO")
	public Object saveReserveOrders(@RequestHeader("token") String token,
			@RequestBody @Validated ReqReserveOrdersAllotVO reqReserveOrdersAllotVo) throws Exception {
		try {
			Map<String, Object> cur = getCurrentUser(token);
			return iReserveOrdersAllotService.saveReserveOrders(reqReserveOrdersAllotVo, cur);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}
}
