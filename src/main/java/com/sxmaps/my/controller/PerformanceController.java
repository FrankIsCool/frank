package com.sxmaps.mms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.service.impl.PerformanceServiceImpl;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.req.ReqPerformanceByCampusVO;
import com.sxmaps.mms.vo.req.ReqPerformanceChartVO;
import com.sxmaps.mms.vo.req.ReqPerformanceCountByMonthVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeBySiteVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeDayVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeRankVO;
import com.sxmaps.mms.vo.req.ReqPerformanceRankingVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeBySiteVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeDayVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeRanksVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeSumVO;
import com.sxmaps.mms.vo.resp.RespPerformancePerMonthVO;
import com.sxmaps.mms.vo.resp.RespPerformanceRankingVO;
import com.sxmaps.mms.vo.resp.RespPerformanceTrendVO;
import com.sxmaps.mms.vo.resp.RespProtocolLevelVO;
import com.sxmaps.mms.vo.resp.RespReserveCountByDeptVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 分校业绩统计controller
 * @author liwenxin
 *
 */
@RestController
@RequestMapping("/performance")
@Api(value = "分校业绩统计", tags = "分校业绩统计")
public class PerformanceController extends BaseController{
	@Autowired
	PerformanceServiceImpl psi;
	
	/**
	 * 每月业绩统计
	 * @return
	 */
	@PostMapping("/performanceChartPerMonth")
	@ApiOperation(value = "每月业绩统计", notes = "每月业绩统计", response = RespPerformanceTrendVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceChartVO 实体", dataType = "ReqPerformanceChartVO")
	public Object performanceChartPerMonth(@RequestBody @Validated ReqPerformanceChartVO req) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			sdf.setLenient(false);
			sdf.parse(req.getDate());
			return psi.performanceChartPerMonth(req);
		}catch (ParseException e) {
			return WebTools.createErrorMessage(500, "日期格式不正确,请检查参数");
		}
		
	}
	
	/**
	 * 每月流失率统计
	 * @return
	 */
	@PostMapping("/churnRatePerMonth")
	@ApiOperation(value = "每月流失率统计", notes = "每月流失率统计", response = RespPerformancePerMonthVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceChartVO 实体", dataType = "ReqPerformanceChartVO")
	public Object churnRatePerMonth(@RequestBody @Validated ReqPerformanceChartVO req) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			sdf.setLenient(false);
			sdf.parse(req.getDate());
			return psi.churnRatePerMonth(req);
		}catch (ParseException e) {
			return WebTools.createErrorMessage(500, "日期格式不正确,请检查参数");
		}
	}
	
	/**
	 * 按支付方式统计成交金额
	 * @return
	 */
	@PostMapping("/performanceCountByPayway")
	@ApiOperation(value = "按支付方式统计成交金额", notes = "按支付方式统计成交金额", response = RespPerformancePerMonthVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceByCampusVO 实体", dataType = "ReqPerformanceByCampusVO")
	public Object performanceCountByPayway(@RequestBody @Validated ReqPerformanceByCampusVO req) {
		if(req.getTimeQuantum().equals("DAILY") || req.getTimeQuantum().equals("WEEKLY") || req.getTimeQuantum().equals("MONTHLY") || 
				req.getTimeQuantum().equals("QUARTERLY") || req.getTimeQuantum().equals("CUSTOM")) {
			return psi.performanceCountByPayway(req);
		}else {
			return WebTools.createErrorMessage(500, "查询时间段错误,请检查参数");
		}
	}
	
	/**
	 * 全年收入趋势统计
	 * @return
	 */
	@PostMapping("/performanceCountByMonth")
	@ApiOperation(value = "全年收入趋势统计", notes = "全年收入趋势统计", response = RespProtocolLevelVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceCountByMonthVO 实体", dataType = "ReqPerformanceCountByMonthVO")
	public Object performanceCountByMonth(@RequestBody @Validated ReqPerformanceCountByMonthVO req) {
		return psi.performanceCountByMonth(req);
	}

	/**
	 * 分校业绩统计排名
	 * @return
	 */
	@PostMapping("/performanceRankingByStation")
	@ApiOperation(value = "分校业绩统计排名", notes = "分校业绩统计排名", response = RespPerformanceRankingVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceRankingVO 实体", dataType = "ReqPerformanceRankingVO")
	public Object performanceRankingByStation(@RequestBody @Validated ReqPerformanceRankingVO req) {
		if(!(req.getOrderBy().equals("SUMAMOUNT") || req.getOrderBy().equals("COMMONCOUNT") || req.getOrderBy().equals("HANSELCOUNT") || req.getOrderBy().equals("COUNSELCOUNT") || 
				req.getOrderBy().equals("OWNCOUNT"))) {
			return WebTools.createErrorMessage(500, "参数错误,排序方式只能为:SUMAMOUNT 总成交额,COMMONCOUNT 成交单数,HANSELCOUNT 定金单数,COUNSELCOUNT 咨询单数,OWNCOUNT 自营单数");
		}
		if(!(req.getSort().equals("ASC") || req.getSort().equals("DESC"))) {
			return WebTools.createErrorMessage(500, "参数错误,排序顺序只能为:ASC 正序,DESC 倒序");
		}
		return psi.performanceRankingByStation(req);
	}
	
	/**
	 * 线下咨询师业绩统计排名
	 * @return
	 */
	@PostMapping("/performanceRankingByTeacher")
	@ApiOperation(value = "线下咨询师业绩统计排名", notes = "分校业绩统计排名", response = RespPerformanceRankingVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceRankingVO 实体", dataType = "ReqPerformanceRankingVO")
	public Object performanceRankingByTeacher(@RequestBody @Validated ReqPerformanceRankingVO req) {
		if(!(req.getOrderBy().equals("SUMAMOUNT") || req.getOrderBy().equals("COMMONCOUNT") || req.getOrderBy().equals("HANSELCOUNT") || req.getOrderBy().equals("COUNSELCOUNT") || 
				req.getOrderBy().equals("OWNCOUNT"))) {
			return WebTools.createErrorMessage(500, "参数错误,排序方式只能为:SUMAMOUNT 总成交额,COMMONCOUNT 成交单数,HANSELCOUNT 定金单数,COUNSELCOUNT 咨询单数,OWNCOUNT 自营单数");
		}
		if(!(req.getSort().equals("ASC") || req.getSort().equals("DESC"))) {
			return WebTools.createErrorMessage(500, "参数错误,排序顺序只能为:ASC 正序,DESC 倒序");
		}
		return psi.performanceRankingByTeacher(req);
	}
	/**
	 * 前端咨询组排名
	 * @param token
	 * @return
	 */
	@PostMapping("/performanceForeRank")
	@ApiOperation(value = "前端咨询组排名", notes = "前端咨询组排名", response = RespPerformanceForeRanksVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceForeRankVO 实体", dataType = "ReqPerformanceForeRankVO")
	public Object performanceForeRank(@RequestHeader("token") String token,@RequestBody @Validated ReqPerformanceForeRankVO req) {
		Map<String,Object> user = getCurrentUser(token);
		String userId = (String)user.get("userId");
		req.setUserId(userId);
		RespPerformanceForeRanksVO resp;
		if(req.getTimeQuantum().equals("WEEKLY") || req.getTimeQuantum().equals("MONTHLY")) {
			try {
				resp = psi.performanceForeRank(req);
			} catch (Exception e) {
				return WebTools.createErrorMessage(500, "服务器错误,请稍后再试");
			}
			return resp;
		}else {
			return WebTools.createErrorMessage(500, "时间段错误,请检查参数");
		}
	}
	
	/**
	 * 前端专本套排名
	 * @param token
	 * @return
	 */
	@PostMapping("/performanceForeDoubleRank")
	@ApiOperation(value = "前端咨询组排名", notes = "前端咨询组排名", response = RespPerformanceForeRanksVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceForeRankVO 实体", dataType = "ReqPerformanceForeRankVO")
	public Object performanceForeDoubleRank(@RequestHeader("token") String token,@RequestBody @Validated ReqPerformanceForeRankVO req) {
		getCurrentUser(token);
		if(req.getTimeQuantum().equals("WEEKLY") || req.getTimeQuantum().equals("MONTHLY")) {
			return psi.performanceForeDoubleRank(req);
		}else {
			return WebTools.createErrorMessage(500, "时间段错误,请检查参数");
		}
	}
	
	/**
	 * 前端总业绩统计
	 * @return
	 */
	@PostMapping("/performanceForeSum")
	@ApiOperation(value = "前端总业绩统计", notes = "前端总业绩统计", response = RespPerformanceForeSumVO.class)
	public Object performanceForeSum(@RequestHeader("token") String token) {
		Map<String,Object> user = getCurrentUser(token);
		String userId = (String)user.get("userId");
		return psi.performanceForeSum(userId);
	}
	
	/**
	 * 前端每日业绩统计
	 * @return
	 */
	@PostMapping("/performanceForeByDay")
	@ApiOperation(value = "前端每日业绩统计", notes = "前端每日业绩统计", response = RespPerformanceForeDayVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceForeDayVO 实体", dataType = "ReqPerformanceForeDayVO")
	public Object performanceForeByDay(@RequestBody @Validated ReqPerformanceForeDayVO req) {
		return psi.performanceForeByDay(req);
	}
	
	@GetMapping("/notcheck/exportPerformanceStationRanking")
	@ApiOperation(value = "分校业绩统计排名导出", notes = "分校业绩统计排名导出")
	public void exportPerformanceStationRanking(HttpServletResponse response,String dataParm) {
		dataParm = new String(org.apache.commons.codec.binary.Base64.decodeBase64(dataParm));
		ReqPerformanceRankingVO req = JSONObject.parseObject(dataParm, ReqPerformanceRankingVO.class);
		try {
			psi.exportPerformanceStationRanking(req, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/notcheck/exportPerformanceTeacherRanking")
	@ApiOperation(value = "分校业绩统计排名导出", notes = "分校业绩统计排名导出")
	public void exportPerformanceTeacherRanking(HttpServletResponse response,String dataParm) {
		dataParm = new String(org.apache.commons.codec.binary.Base64.decodeBase64(dataParm));
		ReqPerformanceRankingVO req = JSONObject.parseObject(dataParm, ReqPerformanceRankingVO.class);
		try {
			psi.exportPerformanceTeacherRanking(req, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/performanceForeBySite")
	@ApiOperation(value = "前端根据站点号统计", notes = "前端根据站点号统计", response = RespPerformanceForeBySiteVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceForeBySiteVO 实体", dataType = "ReqPerformanceForeBySiteVO")
	public Object performanceForeBySite(@RequestBody @Validated ReqPerformanceForeBySiteVO req) {
		return psi.performanceForeBySite(req);
	}
	
	@PostMapping("/performanceForeByGroupId")
	@ApiOperation(value = "前端根据部门ID统计", notes = "前端根据部门ID统计", response = RespPerformanceForeBySiteVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceForeBySiteVO 实体", dataType = "ReqPerformanceForeBySiteVO")
	public Object performanceForeByGroupId(@RequestBody @Validated ReqPerformanceForeBySiteVO req) {
		return psi.performanceForeByGroupId(req);
	}
	
	@PostMapping("/qryReserveCountByDept")
	@ApiOperation(value = "中端分校当日预约单数统计", notes = "中端分校当日预约单数统计", response = RespReserveCountByDeptVO.class)
	@ApiImplicitParam(name = "req", value = "ReqPerformanceForeDayVO 实体", dataType = "ReqPerformanceForeDayVO")
	public Object qryReserveCountByDept(@RequestBody @Validated ReqPerformanceForeDayVO req) {
		return psi.qryReserveCountByDept(req);
	}
}
