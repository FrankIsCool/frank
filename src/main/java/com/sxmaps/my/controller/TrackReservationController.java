package com.sxmaps.mms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.client.ReserveOrdersAllotClient;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IReserveOrdersAllotService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.TrackReservationVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqTrackReservationUidVo;
import com.sxmaps.mms.vo.resp.RespReservationVO;
import com.sxmaps.mms.vo.resp.RespUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "预约单列表查询", value = "TrackReservation")
@RestController
@RequestMapping("/trackReservation")
public class TrackReservationController extends BaseController{

	@Autowired
	private ReserveOrdersAllotClient reserveOrdersAllotClient;

	@Autowired
	private IReserveOrdersAllotService iReserveOrdersAllotService;

	/**
	 * 预约单列表查询
	 * 
	 * @param trackReservationVo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/qryTrackReservation")
	@ApiOperation(notes = "预约单列表查询", value = "预约单列表查询", response = RespReservationVO.class)
	@ApiImplicitParam(name = "trackReservationVo", value = "trackReservationVo 实体", dataType = "TrackReservationVO")
	public Object qryTrackReservation(@RequestHeader("token") String token,@RequestBody @Validated TrackReservationVO trackReservationVo) throws Exception {
		Map<String, Object> cur = getCurrentUser(token);
		return iReserveOrdersAllotService.qryReserveOrdersInfo(trackReservationVo,cur);
	}

	/**
	 * 预约单详情备注信息
	 * 
	 * @param reqMmsQryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trackReservationDetail")
	@ApiOperation(notes = "预约单详情备注信息", value = "预约单详情备注信息", response = RespReservationVO.class)
	@ApiImplicitParam(name = "mmsQueryVO", value = "mmsQueryVO 实体", dataType = "ReqMmsQueryVO")
	public Object trackReservationDetail(@RequestBody @Validated ReqMmsQueryVO mmsQueryVO) throws Exception {
		return reserveOrdersAllotClient.trackReservationDetail(mmsQueryVO);
	}

	/**
	 * 获取咨询师信息
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/getReservationConsultantInfo")
	@ApiOperation(notes = "获取咨询师信息", value = "获取咨询师信息", response = RespUserVO.class)
	@ApiImplicitParam(name = "vo", value = "vo 实体", dataType = "ReqTrackReservationUidVo")
	public Object getReservationConsultantInfo(@RequestBody @Validated ReqTrackReservationUidVo vo) throws Exception {
		try {
			return iReserveOrdersAllotService.getReservationConsultantInfo(vo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}

	}
	
	/**
	 * 预约单全部查询
	 * 
	 * @param trackReservationVo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/qryAllReservation")
	@ApiOperation(notes = "全部预约单列表查询", value = "预约单列表查询", response = RespReservationVO.class)
	@ApiImplicitParam(name = "trackReservationVo", value = "trackReservationVo 实体", dataType = "TrackReservationVO")
	public Object qryAllReservation(@RequestBody @Validated TrackReservationVO trackReservationVo) throws Exception {
		//Map<String, Object> cur = getCurrentUser(token);
		return iReserveOrdersAllotService.qryReserveOrdersInfo(trackReservationVo,null);
	}
}
