package com.sxmaps.mms.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.exception.MmsBizException;
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
import com.sxmaps.mms.vo.resp.RespReserveCountByDeptVO;

/**
 * 分校业绩统计
 * @author liwenxin
 *
 */
public interface IPerformanceService {
	RespPerformanceTrendVO performanceChartPerMonth(ReqPerformanceChartVO req) throws ParseException;
	
	List<RespPerformancePerMonthVO> churnRatePerMonth(ReqPerformanceChartVO req) throws ParseException;
	
	List<RespPerformancePerMonthVO> performanceCountByPayway(ReqPerformanceByCampusVO req);
	
	RespPerformanceForeRanksVO performanceForeRank(ReqPerformanceForeRankVO req) throws Exception;
	
	RespPerformanceForeRanksVO performanceForeDoubleRank(ReqPerformanceForeRankVO req) throws MmsBizException;
	
	List<RespPerformanceForeSumVO> performanceForeSum(String userId);
	
	List<RespPerformanceForeDayVO> performanceForeByDay(ReqPerformanceForeDayVO req);
	
	List<RespPerformancePerMonthVO> performanceCountByMonth(ReqPerformanceCountByMonthVO req);
	
	PageInfo<RespPerformanceRankingVO> performanceRankingByStation(ReqPerformanceRankingVO req);
	
	PageInfo<RespPerformanceRankingVO> performanceRankingByTeacher(ReqPerformanceRankingVO req);
	
	void exportPerformanceStationRanking(ReqPerformanceRankingVO req, HttpServletResponse response) throws Exception;
	
	void exportPerformanceTeacherRanking(ReqPerformanceRankingVO req, HttpServletResponse response) throws Exception;
	
	List<RespPerformanceForeBySiteVO> performanceForeBySite(ReqPerformanceForeBySiteVO req);
	
	List<RespPerformanceForeBySiteVO> performanceForeByGroupId(ReqPerformanceForeBySiteVO req);
	
	List<RespReserveCountByDeptVO> qryReserveCountByDept(ReqPerformanceForeDayVO req);
	
}
