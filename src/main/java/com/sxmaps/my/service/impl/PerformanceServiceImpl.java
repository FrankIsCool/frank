package com.sxmaps.mms.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.client.AuthenticationClient;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsCampusMapper;
import com.sxmaps.mms.mapper.PerformanceMapper;
import com.sxmaps.mms.model.JsonMessage;
import com.sxmaps.mms.service.IPerformanceService;
import com.sxmaps.mms.utils.DateUtil;
import com.sxmaps.mms.utils.EasyPoiUtils;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.vo.ExportStationVO;
import com.sxmaps.mms.vo.ExportTeacherVO;
import com.sxmaps.mms.vo.req.DeptIdVO;
import com.sxmaps.mms.vo.req.ReqPerformanceByCampusVO;
import com.sxmaps.mms.vo.req.ReqPerformanceChartVO;
import com.sxmaps.mms.vo.req.ReqPerformanceCountByMonthVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeBySiteVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeDayVO;
import com.sxmaps.mms.vo.req.ReqPerformanceForeRankVO;
import com.sxmaps.mms.vo.req.ReqPerformanceRankingVO;
import com.sxmaps.mms.vo.resp.RespCampusVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeBySiteVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeDayVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeRankVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeRanksVO;
import com.sxmaps.mms.vo.resp.RespPerformanceForeSumVO;
import com.sxmaps.mms.vo.resp.RespPerformancePerMonthVO;
import com.sxmaps.mms.vo.resp.RespPerformanceRankingVO;
import com.sxmaps.mms.vo.resp.RespPerformanceTrendVO;
import com.sxmaps.mms.vo.resp.RespReserveCountByDeptVO;

/**
 * 分校业绩统计service
 * 
 * @author liwenxin
 *
 */
@Service
public class PerformanceServiceImpl implements IPerformanceService {
	@Autowired
	PerformanceMapper performanceMapper;
	@Autowired
	MmsCampusMapper campusMapper;
	@Autowired
	EasyPoiUtils easyPoiUtils;
	@Autowired
	AuthenticationClient orgStructureClient;

	@Override
	public RespPerformanceTrendVO performanceChartPerMonth(ReqPerformanceChartVO req) throws ParseException {
		req.setBeginTime(req.getDate().concat("-01"));
		req.setEndTime(req.getDate().concat("-31"));
		List<RespPerformancePerMonthVO> resultList = performanceMapper.performanceChartPerMonth(req);
		BigDecimal sumAmount = new BigDecimal(0.00);
		for (RespPerformancePerMonthVO vo : resultList) {
			sumAmount = sumAmount.add(vo.getData());
			vo.setData(vo.getData().divide(new BigDecimal(10000.00)));
		}
		RespPerformanceTrendVO resp = new RespPerformanceTrendVO();
		resp.setList(resultList);
		resp.setSumAmount(sumAmount);
		return resp;
	}

	@Override
	public List<RespPerformancePerMonthVO> churnRatePerMonth(ReqPerformanceChartVO req) throws ParseException {
		req.setBeginTime(req.getDate().concat("-01"));
		req.setEndTime(req.getDate().concat("-31"));
		List<RespPerformancePerMonthVO> resp = performanceMapper.churnRatePerMonth(req);
		return resp;
	}

	@Override
	public List<RespPerformancePerMonthVO> performanceCountByPayway(ReqPerformanceByCampusVO req)
			throws MmsBizException {
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("DAILY") || req.getTimeQuantum().equals("WEEKLY")
				|| req.getTimeQuantum().equals("MONTHLY") || req.getTimeQuantum().equals("QUARTERLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		if (req.getCampusCode().equals("0")) {
			req.setCampusCode(null);
		} else if (ValidatorUtil.isEmpty(req.getCampusCode())) {
			return new ArrayList<RespPerformancePerMonthVO>();
		}
		List<RespPerformancePerMonthVO> resp = performanceMapper.performanceCountByPayway(req);
		/*
		 * BigDecimal pos = BigDecimal.valueOf(0.00); RespPerformancePerMonthVO removeVO
		 * = null; for(RespPerformancePerMonthVO vo:resp) {
		 * if(vo.getDate().equals("POS")) { pos = pos.add(vo.getData()); removeVO = vo;
		 * } } if(removeVO != null) { resp.remove(removeVO); } boolean isCardExist =
		 * false; for(RespPerformancePerMonthVO vo:resp) {
		 * if(vo.getDate().equals("CARD")) { vo.getData().add(pos); isCardExist = true;
		 * } } if(!isCardExist) { RespPerformancePerMonthVO vo = new
		 * RespPerformancePerMonthVO(); vo.setDate("CARD"); vo.setData(pos);
		 * resp.add(vo); }
		 */
		convertPayway(resp);
		return resp;
	}

	@SuppressWarnings("serial")
	public void convertPayway(List<RespPerformancePerMonthVO> vo) {
		Map<String, Integer> paywayState = new HashMap<String, Integer>() {
			{
				put("ALIPAY", 0);
				put("WXPAY", 0);
				put("BAIDU", 0);
				put("CARD", 0);
				put("POS", 0);
				put("HAIMI", 0);
				put("KU", 0);
				put("HUI", 0);
				put("R360", 0);
				put("MS", 0);
				put("COFFEE", 0);
				put("ABCBANK", 0);
				put("CCBBANK", 0);
				put("CMBBANK", 0);
				put("ZYXF", 0);
				put("LB", 0);
				
			}
		};
		for (RespPerformancePerMonthVO opr : vo) {
			switch (opr.getDate()) {
			case "ALIPAY":
				opr.setDate("支付宝支付");
				paywayState.put("ALIPAY", 1);
				break;
			case "WXPAY":
				opr.setDate("微信支付");
				paywayState.put("WXPAY", 1);
				break;
			case "BAIDU":
				opr.setDate("百度分期");
				paywayState.put("BAIDU", 1);
				break;
			case "CARD":
				opr.setDate("刷卡支付");
				paywayState.put("CARD", 1);
				break;
			case "POS":
				opr.setDate("刷卡(小票号)支付");
				paywayState.put("POS", 1);
				break;
			case "HAIMI":
				opr.setDate("海米分期");
				paywayState.put("HAIMI", 1);
				break;
			case "KU":
				opr.setDate("库分期");
				paywayState.put("KU", 1);
				break;
			case "HUI":
				opr.setDate("惠学习");
				paywayState.put("HUI", 1);
				break;
			case "R360":
				opr.setDate("融360");
				paywayState.put("R360", 1);
				break;
			case "MS":
				opr.setDate("马上分期");
				paywayState.put("MS", 1);
				break;
			case "COFFEE":
				opr.setDate("咖啡易融");
				paywayState.put("COFFEE", 1);
				break;
			case "ABCBANK":
				opr.setDate("农行对公");
				paywayState.put("ABCBANK", 1);
				break;
			case "CCBBANK":
				opr.setDate("建行对公");
				paywayState.put("CCBBANK", 1);
				break;
			case "CMBBANK":
				opr.setDate("招行对公");
				paywayState.put("CMBBANK", 1);
				break;
			case "ZYXF":
				opr.setDate("中银消费");
				paywayState.put("ZYXF", 1);
				break;
			case "LB":
				opr.setDate("乐百分");
				paywayState.put("LB", 1);
				break;
			default:
				opr.setDate("其他支付方式");
				break;
			}
		}
		for (String key : paywayState.keySet()) {
			if (paywayState.get(key) == 0) {
				RespPerformancePerMonthVO newvo = new RespPerformancePerMonthVO();
				// newvo.setDate(key);
				switch (key) {
				case "ALIPAY":
					newvo.setDate("支付宝支付");
					break;
				case "WXPAY":
					newvo.setDate("微信支付");
					break;
				case "BAIDU":
					newvo.setDate("百度分期");
					break;
				case "CARD":
					newvo.setDate("刷卡支付");
					break;
				case "POS":
					newvo.setDate("刷卡(小票号)支付");
					break;
				case "HAIMI":
					newvo.setDate("海米分期");
					break;
				case "KU":
					newvo.setDate("库分期");
					break;
				case "HUI":
					newvo.setDate("惠学习");
					break;
				case "R360":
					newvo.setDate("融360");
					break;
				case "COFFEE":
					newvo.setDate("咖啡易融");
					break;
				case "ABCBANK":
					newvo.setDate("农行对公");
					break;
				case "CCBBANK":
					newvo.setDate("建行对公");
					break;
				case "CMBBANK":
					newvo.setDate("招行对公");
					break;
				case "MS":
					newvo.setDate("马上分期");
					break;
				case "ZYXF":
					newvo.setDate("中银消费");
					break;
				case "LB":
					newvo.setDate("乐百分");
					break;
				default:
					newvo.setDate("其他支付方式");
					break;
				}
				newvo.setData(BigDecimal.valueOf(0.00));
				vo.add(newvo);
			}
		}
		BigDecimal pos = BigDecimal.valueOf(0.00);
		RespPerformancePerMonthVO removeVO = null;
		for(RespPerformancePerMonthVO resp:vo) {
			if(resp.getDate().equals("刷卡(小票号)支付")) {
				pos = pos.add(resp.getData());
				removeVO = resp;
			}
		}
		if(removeVO != null) {
			vo.remove(removeVO);
		}
		for(RespPerformancePerMonthVO resp:vo) {
			if(resp.getDate().equals("刷卡支付")) {
				resp.setData(resp.getData().add(pos));
			}
		}
		
	}

	@Override
	public List<RespPerformancePerMonthVO> performanceCountByMonth(ReqPerformanceCountByMonthVO req) {
		// List<RespPerformancePerMonthVO> list =
		// performanceMapper.performanceCountByMonth(req);
		if (req.getCampusCode().equals("0")) {
			req.setCampusCode(null);
		} else if (ValidatorUtil.isEmpty(req.getCampusCode())) {
			return new ArrayList<RespPerformancePerMonthVO>();
		}
		return performanceMapper.performanceCountByMonth(req);
	}

	@Override
	public RespPerformanceForeRanksVO performanceForeRank(ReqPerformanceForeRankVO req) throws Exception {
		RespPerformanceForeRanksVO resp = new RespPerformanceForeRanksVO();
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("WEEKLY") || req.getTimeQuantum().equals("MONTHLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		if(req.getSxDeptId() != null && req.getSxDeptId() != "") {
			DeptIdVO dept = new DeptIdVO();
			dept.setDeptId(req.getSxDeptId());
			JsonMessage deptList = orgStructureClient.getDeptBydeptId(dept);
			if(deptList == null || deptList.getCode() != 200) {
				throw new MmsBizException(500, "查询部门列表异常,请稍后再试");
			}
			req.setSxDeptId(deptList.getData().toString());
		}
		List<RespPerformanceForeRankVO> list = performanceMapper.performanceForeRank(req);
		for (RespPerformanceForeRankVO rank : list) {
			if (rank.getUserId().equals(req.getUserId())) {
				resp.setSellerRank(rank);
				break;
			}
		}
		if (list.size() > 10) {
			list = list.subList(0, 9);
		}
		resp.setRankList(list);
		return resp;
	}

	@Override
	public RespPerformanceForeRanksVO performanceForeDoubleRank(ReqPerformanceForeRankVO req) throws MmsBizException {
		RespPerformanceForeRanksVO resp = new RespPerformanceForeRanksVO();
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("WEEKLY") || req.getTimeQuantum().equals("MONTHLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		List<RespPerformanceForeRankVO> list = performanceMapper.performanceForeDoubleRank(req);
		for (RespPerformanceForeRankVO rank : list) {
			if (rank.getUserName().equals(req.getUserName())) {
				resp.setSellerRank(rank);
				break;
			}
		}
		if (list.size() > 10) {
			list = list.subList(0, 9);
		}
		resp.setRankList(list);
		return resp;
	}

	@Override
	public List<RespPerformanceForeSumVO> performanceForeSum(String userId) {
		List<RespPerformanceForeSumVO> resp = new ArrayList<RespPerformanceForeSumVO>();
		RespPerformanceForeSumVO weekSum = new RespPerformanceForeSumVO();
		Map<String, String> time = getStartEndTime("WEEKLY");
		List<RespPerformancePerMonthVO> weekPerList = performanceMapper.performanceForeSum(time.get("startTime"),
				time.get("endTime"), userId);
		int weekCount = 0;
		BigDecimal weekSumAmount = new BigDecimal(0.00);
		for (RespPerformancePerMonthVO vo : weekPerList) {
			weekCount += vo.getCount();
			weekSumAmount = weekSumAmount.add(vo.getData());
		}
		weekSum.setCount(weekCount);
		weekSum.setSumAmount(weekSumAmount);
		weekSum.setPerList(weekPerList);
		weekSum.setTimeQuantum("WEEKLY");
		resp.add(weekSum);
		RespPerformanceForeSumVO monthSum = new RespPerformanceForeSumVO();
		time = getStartEndTime("MONTHLY");
		List<RespPerformancePerMonthVO> monthPerList = performanceMapper.performanceForeSum(time.get("startTime"),
				time.get("endTime"), userId);
		int monthCount = 0;
		BigDecimal monthSumAmount = new BigDecimal(0.00);
		for (RespPerformancePerMonthVO vo : monthPerList) {
			monthCount += vo.getCount();
			monthSumAmount = monthSumAmount.add(vo.getData());
		}
		monthSum.setCount(monthCount);
		monthSum.setSumAmount(monthSumAmount);
		monthSum.setPerList(monthPerList);
		monthSum.setTimeQuantum("MONTHLY");
		resp.add(monthSum);
		return resp;
	}

	@Override
	public List<RespPerformanceForeDayVO> performanceForeByDay(ReqPerformanceForeDayVO req) {
		if (ValidatorUtil.isEmpty(req.getDate())) {
			req.setDate(DateUtil.getDayMonthYear(new Date()));
		}
		// req.setDate("2018-07-30");
		return performanceMapper.performanceForeByDay(req);
	}

	@Override
	public PageInfo<RespPerformanceRankingVO> performanceRankingByStation(ReqPerformanceRankingVO req) {
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("DAILY") || req.getTimeQuantum().equals("WEEKLY")
				|| req.getTimeQuantum().equals("MONTHLY") || req.getTimeQuantum().equals("QUARTERLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		List<RespPerformanceRankingVO> list = performanceMapper.performanceRankingByStation(req);
		PageInfo<RespPerformanceRankingVO> resp = new PageInfo<RespPerformanceRankingVO>(list);
		int count = (int) resp.getTotal();
		for (RespPerformanceRankingVO vo : resp.getList()) {
			if ("ASC".equals(req.getSort())) {
				// 从小到大排序时,按倒序重新设置排名
				vo.setRank(count - (vo.getRank() + ((req.getPageNum() - 1) * req.getPageSize())) + 1);
			} else if ("DESC".equals(req.getSort())) {
				vo.setRank(vo.getRank() + ((req.getPageNum() - 1) * req.getPageSize()));
			}
			double divideNum = vo.getCommonCount() + vo.getHanselCount() + vo.getCounselCount();
			divideNum = divideNum == 0 ? 1 : divideNum;
			vo.setCommonRate(new BigDecimal(vo.getCommonCount() / divideNum));
		}
		return resp;
	}

	@Override
	public PageInfo<RespPerformanceRankingVO> performanceRankingByTeacher(ReqPerformanceRankingVO req) {
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("DAILY") || req.getTimeQuantum().equals("WEEKLY")
				|| req.getTimeQuantum().equals("MONTHLY") || req.getTimeQuantum().equals("QUARTERLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		if (req.getCampusCode().equals("0")) {
			List<RespCampusVO> campusVos = campusMapper.queryCampus();
			List<String> deptList = new ArrayList<String>();
			for (RespCampusVO campus : campusVos) {
				deptList.add(campus.getDeptCode());
			}
			req.setDeptList(deptList);
		} else if (ValidatorUtil.isEmpty(req.getCampusCode())) {
			PageInfo<RespPerformanceRankingVO> resp = new PageInfo<RespPerformanceRankingVO>();
			resp.setPageNum(1);
			resp.setPageSize(10);
			return resp;
		} else {
			List<String> deptList = new ArrayList<String>();
			deptList.add(req.getCampusCode());
			req.setDeptList(deptList);
		}
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespPerformanceRankingVO> list = performanceMapper.performanceRankingByTeacher(req);
		PageInfo<RespPerformanceRankingVO> resp = new PageInfo<RespPerformanceRankingVO>(list);
		int count = (int) resp.getTotal();
		for (RespPerformanceRankingVO vo : resp.getList()) {
			if ("ASC".equals(req.getSort())) {
				// 从小到大排序时,按倒序重新设置排名
				vo.setRank(count - (vo.getRank() + ((req.getPageNum() - 1) * req.getPageSize())) + 1);
			} else if ("DESC".equals(req.getSort())) {
				vo.setRank(vo.getRank() + ((req.getPageNum() - 1) * req.getPageSize()));
			}
			double divideNum = vo.getCommonCount() + vo.getHanselCount() + vo.getCounselCount();
			divideNum = divideNum == 0 ? 1 : divideNum;
			vo.setCommonRate(new BigDecimal(vo.getCommonCount() / divideNum));
		}
		return resp;
	}

	@Override
	public void exportPerformanceStationRanking(ReqPerformanceRankingVO req, HttpServletResponse response)
			throws Exception {
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("DAILY") || req.getTimeQuantum().equals("WEEKLY")
				|| req.getTimeQuantum().equals("MONTHLY") || req.getTimeQuantum().equals("QUARTERLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		req.setOrderBy(req.getOrderBy() + " " + req.getSort());
		req.setSort(null);
		List<RespPerformanceRankingVO> list = performanceMapper.performanceRankingByStation(req);
		List<ExportStationVO> exportList = new ArrayList<>();
		for (RespPerformanceRankingVO vo : list) {
			ExportStationVO export = new ExportStationVO();
			BeanUtils.copyProperties(vo, export);
			export.setCommonRate(vo.getCommonRate().multiply(new BigDecimal(100)).toString() + "%");
			exportList.add(export);
		}
		easyPoiUtils.exportExcel(exportList, req.getStartTime() + "至" + req.getEndTime() + "分校业绩排名",
				req.getStartTime() + "至" + req.getEndTime(), ExportStationVO.class,
				req.getStartTime() + "至" + req.getEndTime() + "分校业绩排名.xls", response);
	}

	@Override
	public void exportPerformanceTeacherRanking(ReqPerformanceRankingVO req, HttpServletResponse response)
			throws Exception {
		Map<String, String> time = getStartEndTime(req.getTimeQuantum());
		if (req.getTimeQuantum().equals("DAILY") || req.getTimeQuantum().equals("WEEKLY")
				|| req.getTimeQuantum().equals("MONTHLY") || req.getTimeQuantum().equals("QUARTERLY")) {
			req.setStartTime(time.get("startTime"));
			req.setEndTime(time.get("endTime"));
		}
		if (req.getCampusCode().equals("0")) {
			List<RespCampusVO> campusVos = campusMapper.queryCampus();
			List<String> deptList = new ArrayList<String>();
			for (RespCampusVO campus : campusVos) {
				deptList.add(campus.getDeptCode());
			}
			req.setDeptList(deptList);
		} else {
			List<String> deptList = new ArrayList<String>();
			deptList.add(req.getCampusCode());
			req.setDeptList(deptList);
		}
		req.setOrderBy(req.getOrderBy() + " " + req.getSort());
		req.setSort(null);
		List<RespPerformanceRankingVO> list = performanceMapper.performanceRankingByTeacher(req);
		List<ExportTeacherVO> exportList = new ArrayList<>();
		for (RespPerformanceRankingVO vo : list) {
			ExportTeacherVO export = new ExportTeacherVO();
			BeanUtils.copyProperties(vo, export);
			export.setCommonRate(vo.getCommonRate().multiply(new BigDecimal(100)).toString() + "%");
			exportList.add(export);
		}
		easyPoiUtils.exportExcel(exportList, req.getStartTime() + "至" + req.getEndTime() + "现场咨询师业绩排名",
				req.getStartTime() + "至" + req.getEndTime(), ExportTeacherVO.class,
				req.getStartTime() + "至" + req.getEndTime() + "现场咨询师业绩排名.xls", response);
	}

	public Map<String, String> getStartEndTime(String timeQuantum) {
		Map<String, String> result = new HashMap<String, String>();
		String nowDate = DateUtil.getDayMonthYear(new Date());
		switch (timeQuantum) {
		case "DAILY":
			result.put("startTime", nowDate);
			result.put("endTime", nowDate);
			break;
		case "WEEKLY":
			int mondayPlus = getMondayPlus();
			Date firstDay = DateUtil.addDay(new Date(), mondayPlus);
			Date lastDay = DateUtil.addDay(firstDay, 6);
			result.put("startTime", DateUtil.getDayMonthYear(firstDay));
			result.put("endTime", DateUtil.getDayMonthYear(lastDay));
			break;
		case "MONTHLY":
			result.put("startTime", DateUtil.getDayMonthYear(getStartMonth(Calendar.getInstance()).getTime()));
			result.put("endTime", DateUtil.getDayMonthYear(getEndMonth(Calendar.getInstance()).getTime()));
			break;
		case "QUARTERLY":
			result.put("startTime", DateUtil.getDayMonthYear(getStartQuarter(Calendar.getInstance()).getTime()));
			result.put("endTime", DateUtil.getDayMonthYear(getEndQuarter(Calendar.getInstance()).getTime()));
			break;
		case "CUSTOM":
			break;
		default:
			throw new MmsBizException(500, "时间段错误,请检查参数");
		}
		return result;
	}

	/**
	 * 获取当前日期与周一相差的天数
	 * 
	 * @return
	 */
	public static int getMondayPlus() {
		Calendar day = Calendar.getInstance();
		int dayOfWeek = day.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) { // 一周中第一天（周日）
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	/**
	 * 获得当天的起始时间
	 * 
	 * @return
	 */
	public static Calendar getStartDate(Calendar today) {
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		return today;
	}

	/**
	 * 获取当天截止时间
	 * 
	 * @return
	 */
	public static Calendar getEndDate(Calendar endToday) {
		endToday.set(Calendar.HOUR_OF_DAY, 23);
		endToday.set(Calendar.MINUTE, 59);
		endToday.set(Calendar.SECOND, 59);
		endToday.set(Calendar.MILLISECOND, 59);
		return endToday;
	}

	/**
	 * 获得当月起始时间
	 * 
	 * @return
	 */
	public static Calendar getStartMonth(Calendar today) {
		Calendar calendar = getStartDate(today);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar;
	}

	/**
	 * 获得当月结束时间
	 * 
	 * @return
	 */
	public static Calendar getEndMonth(Calendar endToday) {
		Calendar endMounth = getEndDate(endToday);
		endMounth.set(Calendar.DAY_OF_MONTH, endMounth.getActualMaximum(Calendar.DAY_OF_MONTH));
		return endMounth;
	}

	/**
	 * 获取当前季度 起始时间
	 * 
	 * @return
	 */
	public static Calendar getStartQuarter(Calendar today) {
		int currentMonth = today.get(Calendar.MONTH) + 1;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				today.set(Calendar.MONTH, 0);
				today.set(Calendar.DATE, 1);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				today.set(Calendar.MONTH, 3);
				today.set(Calendar.DATE, 1);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				today.set(Calendar.MONTH, 6);
				today.set(Calendar.DATE, 1);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				today.set(Calendar.MONTH, 9);
				today.set(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return today;
	}

	/**
	 * 获取当季的结束时间
	 */
	public static Calendar getEndQuarter(Calendar today) {
		int currentMonth = today.get(Calendar.MONTH) + 1;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				today.set(Calendar.MONTH, 2);
				today.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				today.set(Calendar.MONTH, 5);
				today.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				today.set(Calendar.MONTH, 8);
				today.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				today.set(Calendar.MONTH, 11);
				today.set(Calendar.DATE, 31);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return today;
	}

	@Override
	public List<RespPerformanceForeBySiteVO> performanceForeBySite(ReqPerformanceForeBySiteVO req) {
		req.setDate(DateUtil.getDayMonthYear(new Date()));
		return performanceMapper.performanceForeBySite(req);
	}

	@Override
	public List<RespPerformanceForeBySiteVO> performanceForeByGroupId(ReqPerformanceForeBySiteVO req) {
		// req.setDate(DateUtil.getDayMonthYear(new Date()));
		return performanceMapper.performanceForeByGroupId(req);
	}

	@Override
	public List<RespReserveCountByDeptVO> qryReserveCountByDept(ReqPerformanceForeDayVO req) {
		return performanceMapper.qryReserveCountByDept(req);
	}

}
