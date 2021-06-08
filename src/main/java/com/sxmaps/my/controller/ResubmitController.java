package com.sxmaps.mms.controller;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.sxmaps.mms.model.JsonMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.model.MmsCallBack;
import com.sxmaps.mms.service.IResubmitService;
import com.sxmaps.mms.utils.EasyPoiUtils;
import com.sxmaps.mms.utils.ImportExcelUtil;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.req.ReqCallBackVO;
import com.sxmaps.mms.vo.req.ReqDistributionVO;
import com.sxmaps.mms.vo.req.ReqEvaluateVO;
import com.sxmaps.mms.vo.req.ReqMemberResubmitVO;
import com.sxmaps.mms.vo.req.ReqResubmitPageVO;
import com.sxmaps.mms.vo.req.ReqResubmitUidVO;
import com.sxmaps.mms.vo.resp.RespDistributionLog;
import com.sxmaps.mms.vo.resp.RespEvaluateVO;
import com.sxmaps.mms.vo.resp.RespExcelResubmitVO;
import com.sxmaps.mms.vo.resp.RespMemberEvaluateVO;
import com.sxmaps.mms.vo.resp.ResqResubmitVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "续报学员管理", tags = "续报学员管理")
@RestController
@RequestMapping("/resubmit")
public class ResubmitController extends BaseController {

	@Autowired
	private final IResubmitService resubmitService;

	@Autowired
	private final EasyPoiUtils easyPoiUtils;

	public ResubmitController(IResubmitService resubmitService, EasyPoiUtils easyPoiUtils) {
		this.resubmitService = resubmitService;
		this.easyPoiUtils = easyPoiUtils;
	}

	@ApiOperation(notes = "批量转续报学员", value = "批量转续报学员")
	@PostMapping("/saveResubmit")
	public Object saveResubmit(@RequestHeader("token") String token, @RequestBody List<ReqMemberResubmitVO> req) {
		Map<String, Object> userInfo = this.getCurrentUser(token);

		int result = resubmitService.saveResubmitList(userInfo, req);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，操作失败");
		}

		return result;
	}

	@ApiOperation(notes = "分页查询续报学员", value = "分页查询续报学员", response = ResqResubmitVO.class)
	@PostMapping("/getResubmitMemberByPage")
	@ApiImplicitParam(name = "pageVO", value = "分页查询续报学员请求实体类", dataType = "ReqResubmitPageVO")
	public JsonMessage getResubmitMemberByPage(@RequestBody ReqResubmitPageVO pageVO) {
		return WebTools.createSuccessMessage(resubmitService.getResubmitMemberByPage(pageVO));
	}

	@ApiOperation(notes = "批量分配续报学员", value = "批量分配续报学员",response = Integer.class)
	@PostMapping("/allocationMember")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "token", dataType = "string"),
			@ApiImplicitParam(name = "reqDistributionVO", value = "批量分配续报学员请求实体类", dataType = "ReqDistributionVO") })
	public JsonMessage allocationMember(@RequestHeader("token") String token, @RequestBody ReqDistributionVO reqDistributionVO) {
		return WebTools.createSuccessMessage(resubmitService.allocationMember(this.getCurrentUser(token), reqDistributionVO));
	}

	@ApiOperation(notes = "查看续报学员操作日志", value = "查看续报学员操作日志", response = RespDistributionLog.class)
	@PostMapping("/getResubmitLogById")
	public Object getResubmitLogById(@Valid @RequestBody ReqResubmitUidVO memberUidVO) {

		return resubmitService.getResubmitLogById(memberUidVO);
	}

	@ApiOperation(notes = "根据用户信息分页查询已分配的学员", value = "根据用户信息分页查询已分配的学员", response = RespMemberEvaluateVO.class)
	@PostMapping("/queryResubmitMember")
	public Object queryResubmitMember(@RequestHeader("token") String token, @RequestBody ReqResubmitPageVO pageVO) {
		Map<String, Object> userInfo = this.getCurrentUser(token);
		pageVO.setUserId(userInfo.get("userId").toString());
		return resubmitService.getMemberEvaluateByPage(pageVO);
	}

	@ApiOperation(notes = "转续保学员评价", value = "转续保学员评价")
	@PostMapping("/evaluateMember")
	public Object evaluateMember(@RequestHeader("token") String token, @RequestBody ReqEvaluateVO reqEvaluateVO) {
		Map<String, Object> userInfo = this.getCurrentUser(token);

		int result = resubmitService.evaluateMember(userInfo, reqEvaluateVO);

		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，操作失败");
		}

		return result;
	}

	@ApiOperation(notes = "查询学员历史评价记录", value = "查询学员历史评价记录", response = RespEvaluateVO.class)
	@PostMapping("/getEvaluateHistoryInfo")
	@ApiImplicitParam(name = "reqEvaluateVO", value = "查询学员历史评价记录请求实体类", dataType = "ReqEvaluateVO")
	public Object getEvaluateHistoryInfo(@RequestBody ReqEvaluateVO reqEvaluateVO) {
		return resubmitService.getEvaluateHistoryInfo(reqEvaluateVO);
	}

	@ApiOperation(notes = "提交回访记录", value = "提交回访记录")
	@PostMapping("/saveCallInfo")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "token", dataType = "string"),
			@ApiImplicitParam(name = "callBackVO", value = "提交回访记录请求实体类", dataType = "ReqCallBackVO") })
	public Object saveCallInfo(@RequestHeader("token") String token, @Valid @RequestBody ReqCallBackVO callBackVO) {
		return resubmitService.saveCallInfo(this.getCurrentUser(token), callBackVO);
	}

	@ApiOperation(notes = "根据Uid查询回访记录", value = "根据Uid查询回访记录", response = MmsCallBack.class)
	@PostMapping("/qryCallBackInfo")
	public JsonMessage qryCallBackInfo(@RequestBody ReqResubmitUidVO uidVO) {
		return WebTools.createSuccessMessage(resubmitService.qryCallBackInfo(uidVO));
	}

	@ApiOperation(notes = "导出续报学员", value = "导出续报学员")
	@GetMapping("/notcheck/importExcelResubmitMember")
	public void importExcelResubmitMember(HttpServletResponse response, String dataParm) throws Exception {
		dataParm = dataParm.replaceAll(" ", "+");
		dataParm = dataParm.replaceAll("\n", "");
		dataParm = new String(Base64.decodeBase64(dataParm.getBytes("utf-8")), "utf-8");
		ReqResubmitPageVO req = JSONObject.parseObject(dataParm, ReqResubmitPageVO.class);
		List<RespExcelResubmitVO> result = resubmitService.queryResubmitMember(req);
		response.setCharacterEncoding("UTF-8");
		easyPoiUtils.exportExcel(result, "续报学员表", "续报学员表", RespExcelResubmitVO.class, "续报学员表.xls", response);
	}

	@PostMapping("/improtMemberOrderItemSnExecl")
	@ApiOperation(notes = "根据子订单号导入续报学员", value = "根据子订单号导入续报学员")
	public Object improtMemberOrderItemSnExecl(@RequestHeader("token") String token,
			@RequestParam("excelFile") MultipartFile excelFile, HttpServletRequest request) throws Exception {
		Map<String, Object> userInfo = this.getCurrentUser(token);
		if (ValidatorUtil.isEmpty(excelFile)) {
			return WebTools.createErrorMessage(500, "模板不能为空");
		}
		String path = request.getSession().getServletContext().getRealPath("excelTemplate");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = excelFile.getOriginalFilename();
		InputStream iso = excelFile.getInputStream();
		Map<String, String> map = new HashMap<>(1);
		map.put("子订单编号", "orderItemSn");
		List<Map<String, Object>> data = ImportExcelUtil.parseExcel(iso, fileName, map);
		if (ValidatorUtil.isEmpty(data)) {
			return WebTools.createErrorMessage(500, "模板不能为空");
		}
		resubmitService.improtMemberByOrderItemSn(userInfo, data);
		return WebTools.createSuccessMessage("导入成功！");
	}
}
