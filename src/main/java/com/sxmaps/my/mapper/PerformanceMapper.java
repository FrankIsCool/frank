package com.sxmaps.mms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxmaps.mms.vo.req.ReqPerformanceByCampusVO;
import com.sxmaps.mms.vo.req.ReqPerformanceChartVO;
import com.sxmaps.mms.vo.req.ReqPerformanceCountByMonthVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeBySiteVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeDayVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeRankVO;
import com.sxmaps.mms.vo.req.ReqPerformanceRankingVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeBySiteVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeDayVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeRankVO;
import com.sxmaps.mms.vo.resp.RespPerformancePerMonthVO;
import com.sxmaps.mms.vo.resp.RespPerformanceRankingVO;
import com.sxmaps.mms.vo.resp.RespReserveCountByDeptVO;

/**
 * 分校业绩统计mapper
 * @author liwenxin
 *
 */
public interface PerformanceMapper {
	List<RespPerformancePerMonthVO> performanceChartPerMonth(ReqPerformanceChartVO req);
	
	List<RespPerformancePerMonthVO> churnRatePerMonth(ReqPerformanceChartVO req);
	
	List<RespPerformancePerMonthVO> performanceCountByPayway(ReqPerformanceByCampusVO req);
	
	List<RespPerformanceForeRankVO> performanceForeRank(ReqPerformanceForeRankVO req);
	
	List<RespPerformanceForeRankVO> performanceForeDoubleRank(ReqPerformanceForeRankVO req);
	
	List<RespPerformancePerMonthVO> performanceForeSum(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("sellerUid") String sellerUid);
	
	List<RespPerformanceForeDayVO> performanceForeByDay(ReqPerformanceForeDayVO req);
	
	List<RespPerformancePerMonthVO> performanceCountByMonth(ReqPerformanceCountByMonthVO req);
	
	List<RespPerformanceRankingVO> performanceRankingByStation(ReqPerformanceRankingVO req);
	
	List<RespPerformanceRankingVO> performanceRankingByTeacher(ReqPerformanceRankingVO req);
	
	List<RespPerformanceForeBySiteVO> performanceForeBySite(ReqPerformanceForeBySiteVO req);
	
	List<RespPerformanceForeBySiteVO> performanceForeByGroupId(ReqPerformanceForeBySiteVO req);
	
	List<RespReserveCountByDeptVO> qryReserveCountByDept(ReqPerformanceForeDayVO req);
}
