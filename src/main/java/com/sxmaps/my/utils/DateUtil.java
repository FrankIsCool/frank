package com.sxmaps.mms.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/*******************************************************************************
 * 时间工具类
 * 
 * @author : 刘泽
 * @chaDate: 2013-06-03
 ******************************************************************************/
public class DateUtil
{

	public static final String MONTH_YEAR = "yyyy-MM";

	public static final String DAY_MONTH_YEAR = "yyyy-MM-dd";

	public static final String DAY_MONTH_YEAR1 = "MM/dd/yyyy";

	public static final String ALL_DATES1 = "yyyy-MM-dd HH:mm:ss";

	public static final String ALL_DATES2 = "yyyyMMddHHmmss";

	public static final String ALL_DATES3 = "yyyyMMddHHmmssSS";

	public static final String ALL_DATES4 = "yyMMddHHmmssSS";

	public static final String ALL_DATES5 = "yyyyMMdd";

	public static final String ALL_DATES6 = "yyyy/MM/dd";

	public static final String ALL_DATES7 = "yyyy/MM/dd HH:mm:ss";

	public static final String ALL_DATES8 = "yyyy-MM-dd HH:mm:ss";

	public static final String SIMPLE_DATE_FORMAT_VIRGULE_STR = "yyyy/MM/dd";

	public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";

	public static final String HOUR_MINUTE = "HH:mm";

	public static final String ALL_DATESHH = "yyyy-MM-dd hh:mm:ss";

	/**
	 * 日期格式字符串转换为日期对象
	 * 
	 * @param strDate
	 *            日期格式字符串
	 * @param pattern
	 *            日期对象
	 * @return
	 */
	public static Date parseDate(String strDate, String pattern)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			Date nowDate = format.parse(strDate);
			return nowDate;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取年份
	 * 
	 * @param date
	 *            日期
	 * @return 返回年份字符串
	 */
	public static String getYear(Date date)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return "" + cal.get(Calendar.YEAR);
	}

	/**
	 * 获取月份
	 * 
	 * @param date
	 *            日期
	 * @return 返回月份字符串
	 */
	public static String getMonth(Date date)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return "" + (cal.get(Calendar.MONTH) + 1);
	}

	/**
	 * 字符串转Timestamp
	 * 
	 * @param time
	 *            时间字符中
	 * @return 返回Timestamp
	 */
	public static Timestamp strToTimestamp(String time)
	{
		Timestamp ts = null;
		try
		{
			Format f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date d = (Date) f.parseObject(time);
			ts = new Timestamp(d.getTime());
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return ts;
	}

	/**
	 * 获取当前时间的多少日部分
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串
	 */
	public static String getDay(Date date)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return "" + cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 在日期上增加年份
	 * 
	 * @param date
	 *            日期
	 * @param years
	 *            增加年数值
	 * @return 返回增加后的日期
	 */
	public static Date addYear(Date date, int years)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}

	public static Date addMinute(Date date, int minutes)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	/**
	 * 增加月份
	 * 
	 * @param date
	 *            日期
	 * @param months
	 *            增加月份数
	 * @return 返回增加后日期
	 */
	public static Date addMonth(Date date, int months)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * 增加天数
	 * 
	 * @param date
	 *            日期
	 * @param days
	 *            增加天数
	 * @return 返回增加后日期
	 */
	public static Date addDay(Date date, int days)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, days);
		return cal.getTime();
	}

	/**
	 * 判断两个日期合法性，日期1是否在日期2之后
	 * 
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return 返回字符串
	 */
	public static String getShort(Date date1, Date date2)
	{
		if (date1 == null || date2 == null)
		{
			return null;
		}
		if (date1.before(date2))
		{
			return getMonthYear(date1) + "~" + getMonthYear(date2);
		}
		return getMonthYear(date2) + "~" + getMonthYear(date1);
	}

	/**
	 * 格式化日期并返回字符串(yyyy-MM)
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串
	 */
	public static String getMonthYear(Date date)
	{
		SimpleDateFormat formate = new SimpleDateFormat(MONTH_YEAR);
		return formate.format(date);
	}

	/**
	 * 格式化日期并返回字符串(yyyy-MM-dd)
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串
	 */
	public static String getDayMonthYear(Date date)
	{
		SimpleDateFormat formate = new SimpleDateFormat(DAY_MONTH_YEAR);
		return formate.format(date);
	}

	/**
	 * 格式化日期并返回字符串(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串
	 */
	public static String getDayMonthYearYYYYmmdd1(Date date)
	{
		SimpleDateFormat formate = new SimpleDateFormat(ALL_DATES1);
		return formate.format(date);
	}

	/**
	 * 格式化日期并返回字符串(yyyy/MM/dd HH:mm:ss)
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串
	 */
	public static String getDayMonthYearYYYYmmdd2(Date date)
	{
		SimpleDateFormat formate = new SimpleDateFormat(ALL_DATES7);
		return formate.format(date);
	}

	/**
	 * 格式化日期并返回HH:mm:ss格式字符串
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串
	 */
	public static String getHourMinuteSecondHHmmss(Date date)
	{
		SimpleDateFormat formate = new SimpleDateFormat(HOUR_MINUTE_SECOND);
		return formate.format(date);
	}

	/**
	 * 根据输入的日期字符串 和 提前天数 ， 获得 指定日期提前几天的日期对象
	 * 
	 * @param dateString
	 *            日期对象 ，格式如2011-11-11
	 * @param lazyDays
	 *            倒推的天数
	 * @return 指定日期倒推指定天数后的日期对象
	 * @throws ParseException
	 */
	public static Date getDate(String dateString, int beforeDays)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate;
		try
		{
			inputDate = dateFormat.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
			cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
			return cal.getTime();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 当前日期的加N天
	 * 
	 * @param dateString
	 * @param beforeDays
	 * @return
	 */
	public static long getDateLong(long newTime, int beforeDays)
	{
		Date inputDate;
		try
		{
			inputDate = new Date(newTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
			cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
			return cal.getTime().getTime();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取格式化后的字符日期
	 * 
	 * @param format
	 * @return
	 */
	public static Date getCurrDate()
	{
		return DateUtil.parseDate(getCurrDate("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取格式化后的字符日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrDate(String format)
	{
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * 
	 * @Description: 获取指定格式的日期
	 * @param @param format 格式
	 * @param @param date 日期
	 * @param @return
	 * @return String
	 * @author angelo
	 * @date 2015-11-4
	 */
	public static String getFormateDate(String format, Date date)
	{
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 字符串时间 只精确到年月日 转换为毫秒数
	 * 
	 * @param s
	 * @return
	 */
	public static long getDateTolong(String s)
	{
		long l = 0;
		if (s != null && !s.equals(""))
		{
			l = java.sql.Date.valueOf(s).getTime();
		}
		return l;
	}

	/**
	 * 精确到日期字符串
	 * 
	 * @param date
	 *            日期
	 * @return 返回日期字符串
	 */
	public static String formatDate3(Object date)
	{
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String value = "";
		if (date != null)
		{
			try
			{
				value = sdf.format(date);
			}
			catch (Exception e)
			{
				value = sdf.format(new Date());
			}
		}
		else
		{
			value = sdf.format(new Date());
		}
		return value;
	}

	/**
	 * 获取当前日期前N月的当前日期 如: 获取2012-11-11的前一个月时间是:传参数1 结果:2012-10-11
	 * 
	 * @param month
	 *            月份
	 * @param format
	 *            格式化字符串
	 * @return 返回月份字符串
	 */
	public static String getDateForMonth(String format, int month)
	{
		Date date = new Date();// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat(format);// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.MONTH, -month);// 月份减一
		String time = sdf.format(calendar.getTime());// 输出格式化的日期
		return time;
	}

	/**
	 * 精确到日期,如20111212
	 * 
	 * @param date
	 *            日期
	 * @return 返回格式化后的日期
	 */
	public static String formatDate4(Object date)
	{
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String value = "";
		if (date != null)
		{
			try
			{
				value = sdf.format(date);
			}
			catch (Exception e)
			{
				value = sdf.format(new Date());
			}
		}
		else
		{
			value = sdf.format(new Date());
		}
		return value;
	}

	/**
	 * 将字符串转换成一个日期(yyyyMMdd)
	 * 
	 * @param 时间日期
	 * @return 返回格式化后的日期
	 */
	public static String strToDate5(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES5);
		return sdf.format(date);
	}

	/**
	 * 将字符串转换成一个日期(yyyy/MM/dd)
	 * 
	 * @param 时间日期
	 * @return 返回格式化后的日期
	 */
	public static String strToDate6(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES6);
		return sdf.format(date);
	}

	/**
	 * 精确到日期,如20111212
	 * 
	 * @param date
	 *            日期
	 * @return 返回格式化后的日期
	 */
	public static String formatDate5(Object date)
	{
		DateFormat sdf = new SimpleDateFormat("HHmmss");
		String value = "";
		if (date != null)
		{
			try
			{
				value = sdf.format(date);
			}
			catch (Exception e)
			{
				value = sdf.format(new Date());
			}
		}
		else
		{
			value = sdf.format(new Date());
		}
		return value;
	}

	/**
	 * 计算两个日期时间相差多少时间
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param format
	 *            格式化
	 * @return xxx天xxx小时xxx分钟
	 */
	public static String dateDiff(String startTime, String endTime, String format)
	{
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long diff;
		long day = 0;
		long hour = 0;
		long min = 0;
		// 获得两个时间的毫秒时间差异
		try
		{
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			day = diff / nd;// 计算差多少天
			hour = diff % nd / nh + day * 24;// 计算差多少小时
			min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
			if (day < 1)
			{
				// 输出结果
				if (hour < 1)
				{
					return min + "分钟";
				}
				else
				{
					return hour + "小时";// +min+"分钟";
				}
			}
			else
			{
				return day + "天";// +(hour-day*24)+"小时"+(min-day*24*60)+"分钟";
			}
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
 

	/**
	 * 传入格式化时间,把它转换成它对应的毫秒数
	 * 
	 * @param time
	 *            (格式化时间如:2012-06-30 12:12:32)
	 * @return 返回格式化后的日期
	 */
	public static long getTimeToLong(String time)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try
		{
			date = sdf.parse(time);
			long time_l = date.getTime();
			return time_l;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取当前系统时间(原始格式)
	 */
	public static Date getCurrentDate()
	{
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * 将字符串转换成一个日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param 时间日期字符串
	 * @return 返回格式化后的日期
	 */
	public static Date strToDate1(String date)
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES1);
		try
		{
			dt = sdf.parse(date);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 将字符串转换成一个日期(yyyyMMddHHmmss)
	 * 
	 * @param 时间日期
	 * @return 返回格式化后的日期
	 */
	public static String strToDate2(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES2);
		return sdf.format(date);
	}

	/**
	 * 将字符串转换成一个日期(yyyyMMddHHmmssSS)
	 * 
	 * @param 时间日期
	 * @return 返回格式化后的日期
	 */
	public static String strToDate3(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES3);
		return sdf.format(date);
	}

	/**
	 * 将字符串转换成一个日期(yyMMddHHmmssSS)
	 * 
	 * @param 时间日期
	 * @return 返回格式化后的日期
	 */
	public static String strToDate4(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES4);
		return sdf.format(date);
	}

	/**
	 * 将字符串转换成一个日期(yyyy/MM/dd HH:mm:ss)
	 * 
	 * @param 时间日期字符串
	 * @return 返回格式化后的日期
	 */
	public static Date strToDate5(String date)
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES7);
		try
		{
			dt = sdf.parse(date);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 将字符串转换成一个日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param 时间日期字符串
	 * @return 返回格式化后的日期
	 */
	public static Date strToDate8(String date)
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES8);
		try
		{
			dt = sdf.parse(date);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 将字符串转换成一个日期(yyyy/MM/dd)
	 * 
	 * @param 时间日期字符串
	 * @return 返回格式化后的日期
	 */
	public static Date strToDate6(String date)
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT_VIRGULE_STR);
		try
		{
			dt = sdf.parse(date);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 格式化日期并返回字符串
	 * 
	 * @param date
	 *            日期 dd/MM/yyyy
	 * @return 返回字符串
	 */
	public static String getDayMonthYear1(Date date)
	{
		SimpleDateFormat formate = new SimpleDateFormat(DAY_MONTH_YEAR1);
		return formate.format(date);
	}

	/**
	 * 将字符串转换成一个日期(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param 时间日期字符串
	 * @return 返回格式化后的日期
	 */
	public static Date strToDateHH(String date)
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATESHH);
		;
		try
		{
			dt = sdf.parse(date);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 将字符串转换成一个日期(yyyy-MM-dd)
	 * 
	 * @param 时间日期字符串
	 * @return 返回格式化后的日期
	 */
	public static Date strToDate2(String date)
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_MONTH_YEAR);
		try
		{
			dt = sdf.parse(date);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 去除日期后面的HH：MM：SS
	 * 
	 * @param date
	 * @return
	 */
	public static String splitDateToString(String date)
	{
		if (date != null)
		{
			return date.trim().substring(0, 10);
		}
		return "";
	}

	public static String dateToStrLong(java.util.Date dateDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	public static String getBssDate1(String dd)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(dd.substring(5, 7)).append("/");
		sb.append(dd.substring(8, 10)).append("/");
		sb.append(dd.substring(0, 4));
		return sb.toString();
	}

	public static String getBssDate2(String dd)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(dd.substring(0, 4)).append("-");
		sb.append(dd.substring(5, 7)).append("-");
		sb.append(dd.substring(8, 10)).append(" ");
		sb.append("00:00:00");
		return sb.toString();
	}

	public static String getUssDate3(String dd)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(dd.substring(0, 4)).append("-");
		sb.append(dd.substring(5, 7)).append("-");
		sb.append(dd.substring(8, 10));
		return sb.toString();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param time1
	 *            日期一
	 * @param time2
	 *            日期二
	 * @return 返回相差的天数
	 */
	public static long getQuot(String time1, String time2)
	{
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return quot;
	}

	/**
	 * 计算两个时间相差的分钟数
	 * 
	 * @param startTime
	 *            开始时间(格式：yyyy-MM-dd HH:mm:ss)
	 * @param endTime
	 *            结束时间(格式：yyyy-MM-dd HH:mm:ss)
	 * @author angelo
	 * @return
	 */
	public static long getDiffMinute(String startTime, String endTime)
	{
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			Date dateEndTime = ft.parse(endTime);
			Date dateStartTime = ft.parse(startTime);
			quot = dateEndTime.getTime() - dateStartTime.getTime();
			quot = quot / 1000 / 60;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return quot;
	}

	/**
	 * 判断两个日期时间大小
	 * 
	 * @param lastDate
	 *            开始日期
	 * @param nowDate
	 *            结束日期
	 * @return
	 * @throws ParseException
	 */
	public static boolean beforeDate(String lastDate, String nowDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);
		Date d = sdf.parse(lastDate);
		Date d2 = sdf.parse(nowDate);
		boolean flag = d.before(d2);
		return flag;
	}

	/**
	 * 判断两个日期时间大小
	 * 
	 * @param lastDate
	 *            开始日期
	 * @param nowDate
	 *            结束日期
	 * @return
	 * @throws ParseException
	 */
	public static boolean beforeYMDDate(String lastDate, String nowDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Date d = sdf.parse(lastDate);
		Date d2 = sdf.parse(nowDate);
		boolean flag = d.before(d2);
		return flag;
	}

	/**
	 * 获取某年某月有多少天
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return 返回天数
	 */
	public static int getMonthDays(int year, int month)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 
	 * @Title: main
	 * 
	 * @Description: TODO(main方法测试类)
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args)
	{
	}
}
