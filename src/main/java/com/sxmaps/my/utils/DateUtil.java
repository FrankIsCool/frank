package com.sxmaps.my.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 时间工具类
 *
 * @author frank
 * @module
 * @date 2021/9/4 14:50
 */
public class DateUtil {
    private static final Log logger = LogFactory.getLog(DateUtil.class);

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
    public static final String FORMAT_CST = "EEE MMM dd HH:mm:ss z yyyy";
    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_DATE_YYMMDD = "yyMMdd";
    public static final String FORMAT_TIME = "HH:mm:ss";

//    ----------------------------------获取当前时间------------------------------------

    /**
     * 获取当前系统时间(原始格式)
     */
    public static Date getDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 获取当前系统时间(原始格式)-格式化
     *
     * @param format
     * @return
     */
    public static String getDateStr(String format) {
        return new SimpleDateFormat(format).format(getDate());
    }

    /**
     * 获取当前系统时间(原始格式)-格式化
     *
     * @return
     */
    public static long getDateLong() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前系统时间(原始格式)-Instant
     *
     * @return
     */
    public static Instant getInstant() {
        return Instant.now();
    }
//    ----------------------------------Date转换------------------------------------

    /**
     * Date转long
     *
     * @param date 时间
     * @return
     */
    public static long dateToLong(Date date) {
        return null == date ? null : date.getTime();
    }

    /**
     * Date转成Instant
     *
     * @param date 时间
     * @return
     */
    public static Instant dateToInstant(Date date) {
        return null == date ? null : date.toInstant();
    }
    /**
     * Date转Timestamp
     *
     * @param date 时间
     * @return
     */
    public static Timestamp dateToTimestamp(Date date) {
        return null == date ? null : new Timestamp(date.getTime());
    }
    /**
     * Date转成String
     *
     * @param date 时间
     * @return
     */
    public static String dateToStr(Date date) {
        return null == date ? null : dateToStr(date, ALL_DATES1);
    }

    /**
     * Date转成String
     *
     * @param date 时间
     * @return
     */
    public static String dateToStr(Date date, String format) {
        return null == date ? null : new SimpleDateFormat(format).format(date);
    }
//    ----------------------------------long转换------------------------------------

    /**
     * long转Date
     *
     * @param date 时间戳
     * @return
     */
    public static Date longToDate(long date) {
        return new Date(date);
    }

    /**
     * long转成Instant
     *
     * @param date 时间
     * @return
     */
    public static Instant longToInstant(long date) {
        return longToDate(date).toInstant();
    }
    /**
     * long转成Timestamp
     *
     * @param date 时间
     * @return
     */
    public static Timestamp longToTimestamp(long date) {
        return new Timestamp(date);
    }
    /**
     * long转成String
     *
     * @param date 时间
     * @return
     */
    public static String longToStr(long date) {
        return longToStr(date, ALL_DATES1);
    }

    /**
     * long转成String
     *
     * @param date   时间
     * @param format 时间格式
     * @return
     */
    public static String longToStr(long date, String format) {
        return new SimpleDateFormat(format).format(longToDate(date));
    }


//    ----------------------------------String转换------------------------------------

    /**
     * String转Date
     *
     * @param data   日期字符串
     * @param format 时间格式
     * @return
     */
    public static Date strToDate(String data, String format) {
        try {
            return new SimpleDateFormat(format).parse(data);
        } catch (ParseException e) {
            throw new RuntimeException("date string to date fail");
        }
    }

    /**
     * String转Date
     *
     * @param data 日期字符串
     * @return
     */
    public static Date strToDate(String data) {
        return strToDate(data, ALL_DATES1);
    }
    /**
     * string转成Instant
     *
     * @param date 时间
     * @param format 时间格式
     * @return
     */
    public static Instant strToInstant(String date, String format) {
        return strToDate(date,format).toInstant();
    }
    /**
     * string转成Instant
     *
     * @param date 时间
     * @return
     */
    public static Instant strToInstant(String date) {
        return strToDate(date).toInstant();
    }
    /**
     * string转成Long
     *
     * @param date 时间
     * @param format 时间格式
     * @return
     */
    public static long strToLong(String date, String format) {
        return strToDate(date,format).getTime();
    }
    /**
     * string转成Long
     *
     * @param date 时间
     * @return
     */
    public static long strToLong(String date) {
        return strToDate(date).getTime();
    }
    /**
     * string转成Timestamp
     *
     * @param date 时间
     * @param format 时间格式
     * @return
     */
    public static Timestamp longToTimestamp(String date, String format) {
        return new Timestamp(strToDate(date,format).getTime());
    }
    /**
     * string转成Timestamp
     *
     * @param date 时间
     * @return
     */
    public static Timestamp longToTimestamp(String date) {
        return new Timestamp(strToDate(date).getTime());
    }
//    ----------------------------------Instant转换------------------------------------

    /**
     * Instant转成Date
     *
     * @param date 时间戳
     * @return
     */
    public static Date instantToDate(Instant date) {
        return null == date ? null : Date.from(date);
    }


    /**
     * Instant转成Long
     *
     * @param date 时间
     * @return
     */
    public static long instantToLong(Instant date) {
        return null == date ? null : instantToDate(date).getTime();
    }
    /**
     * Instant转成Timestamp
     *
     * @param date 时间
     * @return
     */
    public static Timestamp InstantToTimestamp(Instant date) {
        return null == date ? null : new Timestamp(instantToDate(date).getTime());
    }
    /**
     * Instant转成String
     *
     * @param date 时间
     * @return
     */
    public static String instantToStr(Instant date) {
        return null == date ? null : instantToStr(date, ALL_DATES1);
    }

    /**
     * Instant转成String
     *
     * @param date   时间
     * @param format 时间格式
     * @return
     */
    public static String instantToStr(Instant date, String format) {
        return null == date ? null : new SimpleDateFormat(format).format(instantToDate(date));
    }



    //    ----------------------------------Timestamp转换------------------------------------

    /**
     * Timestamp转成Date
     *
     * @param date 时间戳
     * @return
     */
    public static Date timestampToDate(Timestamp date) {
        return null == date ? null : longToDate(date.getTime());
    }


    /**
     * Timestamp转成Long
     *
     * @param date 时间
     * @return
     */
    public static long timestampToLong(Timestamp date) {
        return null == date ? null : date.getTime();
    }
    /**
     * Timestamp转成Timestamp
     *
     * @param date 时间
     * @return
     */
    public static Instant timestampToInstant(Timestamp date) {
        return null == date ? null : date.toInstant();
    }
    /**
     * Timestamp转成String
     *
     * @param date 时间
     * @return
     */
    public static String timestampToStr(Timestamp date) {
        return null == date ? null : dateToStr(date);
    }

    /**
     * Timestamp转成String
     *
     * @param date   时间
     * @param format 时间格式
     * @return
     */
    public static String timestampToStr(Timestamp date, String format) {
        return null == date ? null : new SimpleDateFormat(format).format(dateToStr(date));
    }




    /**
     * 某个日期增加时间
     *
     * @param date  日期
     * @param years 增加时间
     * @return 返回增加后的日期
     */
    private static Date addTime(Date date, int years, int months, int days, int hours, int minutes, int seconds, int milliSecond) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        cal.add(Calendar.MONTH, months);
        cal.add(Calendar.DATE, days);
        cal.add(Calendar.HOUR, hours);
        cal.add(Calendar.MINUTE, minutes);
        cal.add(Calendar.SECOND, seconds);
        cal.add(Calendar.MILLISECOND, milliSecond);
        return cal.getTime();
    }


    /**
     * 某个日期增加时间
     *
     * @param date  日期
     * @param times 增加时间
     * @return 返回增加后的日期
     */
    public static Date addTime(Date date, int... times) {
        if (null == times) {
            return date;
        }
        if (times.length > 7) {
            throw new RuntimeException("times length max 6");
        }
        return addTime(date, times[0], times[1], times[2], times[3], times[4], times[5], times[6]);
    }

    /**
     * 某个时间戳增加时间
     *
     * @param date  日期
     * @param times 增加时间
     * @return 返回增加后的日期
     */
    public static Date addTime(long date, int... times) {
        Date dates = longToDate(date);
        if (null == times) {
            return dates;
        }
        if (times.length > 6) {
            throw new RuntimeException("times length max 6");
        }
        return addTime(dates, times[0], times[1], times[2], times[3], times[4], times[5], times[6]);
    }

    /**
     * 当前时间增加时间
     *
     * @param times 增加时间
     * @return 返回增加后的日期
     */
    public static Date addTime(int... times) {
        return addTime(getDate(), times);
    }

    /**
     * 当前时间增加年
     *
     * @param years 增加年数值
     * @return 返回增加后的日期
     */
    public static Date addYear(int years) {
        return addTime(getDate(), years, 0, 0, 0, 0, 0, 0);
    }

    /**
     * 当前时间增加月
     *
     * @param months 增加月数值
     * @return 返回增加后的日期
     */
    public static Date addMonth(int months) {
        return addTime(getDate(), 0, months, 0, 0, 0, 0, 0);
    }

    /**
     * 当前时间增加日
     *
     * @param days 增加天数值
     * @return 返回增加后的日期
     */
    public static Date addDay(int days) {
        return addTime(getDate(), 0, 0, days, 0, 0, 0, 0);
    }

    /**
     * 当前时间增加小时
     *
     * @param hours 增加小时数值
     * @return 返回增加后的日期
     */
    public static Date addHour(int hours) {
        return addTime(getDate(), 0, 0, 0, hours, 0, 0, 0);
    }

    /**
     * 当前时间增加分钟
     *
     * @param minutes 增加分钟数值
     * @return 返回增加后的日期
     */
    public static Date addMinute(int minutes) {
        return addTime(getDate(), 0, 0, 0, 0, minutes, 0, 0);
    }

    /**
     * 当前时间增加秒
     *
     * @param seconds 增加秒数值
     * @return 返回增加后的日期
     */
    public static Date addSecond(int seconds) {
        return addTime(getDate(), 0, 0, 0, 0, 0, seconds, 0);
    }

    /**
     * 当前时间增加毫秒
     *
     * @param milliSecond 增加毫秒数值
     * @return 返回增加后的日期
     */
    public static Date addMilliSecond(int milliSecond) {
        return addTime(getDate(), 0, 0, 0, 0, 0, 0, milliSecond);
    }

    /**
     * 某个日期增加年
     *
     * @param date  日期
     * @param years 增加年数值
     * @return 返回增加后的日期
     */
    public static Date addYear(long date, int years) {
        return addTime(longToDate(date), years, 0, 0, 0, 0, 0, 0);
    }

    /**
     * 某个日期增加月
     *
     * @param date   日期
     * @param months 增加月数值
     * @return 返回增加后的日期
     */
    public static Date addMonth(long date, int months) {
        return addTime(longToDate(date), 0, months, 0, 0, 0, 0, 0);
    }

    /**
     * 某个日期增加日
     *
     * @param date 日期
     * @param days 增加天数值
     * @return 返回增加后的日期
     */
    public static Date addDay(long date, int days) {
        return addTime(longToDate(date), 0, 0, days, 0, 0, 0, 0);
    }

    /**
     * 某个日期增加小时
     *
     * @param date  日期
     * @param hours 增加小时数值
     * @return 返回增加后的日期
     */
    public static Date addHour(long date, int hours) {
        return addTime(longToDate(date), 0, 0, 0, hours, 0, 0, 0);
    }

    /**
     * 某个日期增加分钟
     *
     * @param date    日期
     * @param minutes 增加分钟数值
     * @return 返回增加后的日期
     */
    public static Date addMinute(long date, int minutes) {
        return addTime(longToDate(date), 0, 0, 0, 0, minutes, 0, 0);
    }

    /**
     * 某个日期增加秒
     *
     * @param date    日期
     * @param seconds 增加秒数值
     * @return 返回增加后的日期
     */
    public static Date addSecond(long date, int seconds) {
        return addTime(longToDate(date), 0, 0, 0, 0, 0, seconds, 0);
    }

    /**
     * 某个日期增加毫秒
     *
     * @param date        日期
     * @param milliSecond 增加毫秒数值
     * @return 返回增加后的日期
     */
    public static Date addMilliSecond(long date, int milliSecond) {
        return addTime(longToDate(date), 0, 0, 0, 0, 0, 0, milliSecond);
    }

    /**
     * 某个日期增加年
     *
     * @param date  日期
     * @param years 增加年数值
     * @return 返回增加后的日期
     */
    public static Date addYear(Date date, int years) {
        return addTime(date, years, 0, 0, 0, 0, 0);
    }

    /**
     * 某个日期增加月
     *
     * @param date   日期
     * @param months 增加月数值
     * @return 返回增加后的日期
     */
    public static Date addMonth(Date date, int months) {
        return addTime(date, 0, months, 0, 0, 0, 0);
    }

    /**
     * 某个日期增加日
     *
     * @param date 日期
     * @param days 增加天数值
     * @return 返回增加后的日期
     */
    public static Date addDay(Date date, int days) {
        return addTime(date, 0, 0, days, 0, 0, 0);
    }

    /**
     * 某个日期增加小时
     *
     * @param date  日期
     * @param hours 增加小时数值
     * @return 返回增加后的日期
     */
    public static Date addHour(Date date, int hours) {
        return addTime(date, 0, 0, 0, hours, 0, 0);
    }

    /**
     * 某个日期增加分钟
     *
     * @param date    日期
     * @param minutes 增加分钟数值
     * @return 返回增加后的日期
     */
    public static Date addMinute(Date date, int minutes) {
        return addTime(date, 0, 0, 0, 0, minutes, 0);
    }

    /**
     * 某个日期增加秒
     *
     * @param date    日期
     * @param seconds 增加秒数值
     * @return 返回增加后的日期
     */
    public static Date addSecond(Date date, int seconds) {
        return addTime(date, 0, 0, 0, 0, 0, seconds);
    }

    /**
     * 某个日期增加毫秒
     *
     * @param date        日期
     * @param milliSecond 增加毫秒数值
     * @return 返回增加后的日期
     */
    public static Date addMilliSecond(Date date, int milliSecond) {
        return addTime(date, 0, 0, 0, 0, 0, 0, milliSecond);
    }

    /**
     * 获取日期中的某个数值
     *
     * @param date     日期
     * @param dateType 1：年，2：月，7：周，:5：日，11：时，12：分，13：秒，14：毫秒
     * @return
     */
    private static Integer getTime(Date date, int dateType) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(dateType);
    }

    /**
     * 获取日期:年
     *
     * @param date 日期
     * @return 年份
     */
    public static Integer getYear(Date date) {
        return getTime(date, Calendar.YEAR);
    }

    /**
     * 获取日期:月
     *
     * @param date 日期
     * @return 月份
     */
    public static Integer getMonth(Date date) {
        return getTime(date, Calendar.MONTH);
    }

    /**
     * 获取日期:日
     *
     * @param date 日期
     * @return 日
     */
    public static Integer getDay(Date date) {
        return getTime(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期:星期几
     *
     * @param date
     * @return
     */
    public static Integer getWeek(Date date) {
        return getTime(date, Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取日期:时
     *
     * @param date 日期
     * @return 小时
     */
    public static Integer getHour(Date date) {
        return getTime(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取日期:分
     *
     * @param date 日期
     * @return 分钟
     */
    public static Integer getMinute(Date date) {
        return getTime(date, Calendar.MINUTE);
    }

    /**
     * 获取日期:秒
     *
     * @param date 日期
     * @return 秒
     */
    public static Integer getSecond(Date date) {
        return getTime(date, Calendar.SECOND);
    }

    /**
     * 获取日期:毫秒
     *
     * @param date 日期
     * @return 毫秒
     */
    public static Integer getMillisecond(Date date) {
        return getTime(date, Calendar.MILLISECOND);
    }

    /**
     * 当前日期:年
     *
     * @return
     */
    public static Integer getYear() {
        return getYear(getDate());
    }

    /**
     * 当前日期:月
     *
     * @return
     */
    public static Integer getMonth() {
        return getMonth(getDate());
    }

    /**
     * 当前日期:日
     *
     * @return
     */
    public static Integer getDay() {
        return getDay(getDate());
    }

    /**
     * 当前日期:星期几
     *
     * @return
     */
    public static Integer getWeek() {
        return getWeek(getDate());
    }

    /**
     * 当前日期:时
     *
     * @return
     */
    public static Integer getHour() {
        return getHour(getDate());
    }

    /**
     * 当前日期:分
     *
     * @return
     */
    public static Integer getMinute() {
        return getMinute(getDate());
    }

    /**
     * 当前日期:秒
     *
     * @return
     */
    public static Integer getSecond() {
        return getSecond(getDate());
    }

    /**
     * 当前日期:毫秒
     *
     * @return
     */
    public static Integer getMillisecond() {
        return getMillisecond(getDate());
    }

    /**
     * 获取日期:年
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getYear(String data, String format) {
        return getYear(toDate(data, format));
    }


    /**
     * 获取日期:月
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getMonth(String data, String format) {
        return getMonth(toDate(data, format));
    }


    /**
     * 获取日期:日
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getDay(String data, String format) {
        return getDay(toDate(data, format));
    }


    /**
     * 获取日期:星期几
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getWeek(String data, String format) {
        return getWeek(toDate(data, format));
    }


    /**
     * 获取日期:时
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getHour(String data, String format) {
        return getHour(toDate(data, format));
    }


    /**
     * 获取日期:分
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getMinute(String data, String format) {
        return getMinute(toDate(data, format));
    }


    /**
     * 获取日期:秒
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getSecond(String data, String format) {
        return getSecond(toDate(data, format));
    }

    /**
     * 获取日期:毫秒
     *
     * @param data   时间字符串
     * @param format 时间格式
     * @return
     */
    public static Integer getMillisecond(String data, String format) {
        return getMillisecond(toDate(data, format));
    }

    /**
     * 获取日期:年
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getYear(String data) {
        return getYear(toDate(data));
    }


    /**
     * 获取日期:月
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getMonth(String data) {
        return getMonth(toDate(data));
    }


    /**
     * 获取日期:日
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getDay(String data) {
        return getDay(toDate(data));
    }


    /**
     * 获取日期:星期几
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getWeek(String data) {
        return getWeek(toDate(data));
    }


    /**
     * 获取日期:时
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getHour(String data) {
        return getHour(toDate(data));
    }


    /**
     * 获取日期:分
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getMinute(String data) {
        return getMinute(toDate(data));
    }


    /**
     * 获取日期:秒
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getSecond(String data) {
        return getSecond(toDate(data));
    }

    /**
     * 获取日期:毫秒
     *
     * @param data 时间字符串
     * @return
     */
    public static Integer getMillisecond(String data) {
        return getMillisecond(toDate(data));
    }


    /**
     * 字符串转Timestamp
     *
     * @param time 时间字符中
     * @return 返回Timestamp
     */
    public static Timestamp strToTimestamp(String time) {
        Timestamp ts = null;
        try {
            Format f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date d = (Date) f.parseObject(time);
            ts = new Timestamp(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 判断两个日期合法性，日期1是否在日期2之后
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 返回字符串
     */
    public static String getShort(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return null;
        }
        if (date1.before(date2)) {
            return getMonthYear(date1) + "~" + getMonthYear(date2);
        }
        return getMonthYear(date2) + "~" + getMonthYear(date1);
    }


    /**
     * 根据输入的日期字符串 和 提前天数 ， 获得 指定日期提前几天的日期对象
     *
     * @param dateString 日期对象 ，格式如2011-11-11
     * @return 指定日期倒推指定天数后的日期对象
     * @throws ParseException
     */
    public static Date getDate(String dateString, int beforeDays) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate;
        try {
            inputDate = dateFormat.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(inputDate);
            int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
            cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
            return cal.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当前日期的加N天
     *
     * @param beforeDays
     * @return
     */
    public static long getDateLong(long newTime, int beforeDays) {
        Date inputDate;
        try {
            inputDate = new Date(newTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(inputDate);
            int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
            cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
            return cal.getTime().getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * @param @param  format 格式
     * @param @param  date 日期
     * @param @return
     * @return String
     * @Description: 获取指定格式的日期
     * @author angelo
     * @date 2015-11-4
     */
    public static String getFormateDate(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串时间 只精确到年月日 转换为毫秒数
     *
     * @param s
     * @return
     */
    public static long getDateTolong(String s) {
        long l = 0;
        if (s != null && !s.equals("")) {
            l = java.sql.Date.valueOf(s).getTime();
        }
        return l;
    }

    /**
     * 精确到日期字符串
     *
     * @param date 日期
     * @return 返回日期字符串
     */
    public static String formatDate3(Object date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String value = "";
        if (date != null) {
            try {
                value = sdf.format(date);
            } catch (Exception e) {
                value = sdf.format(new Date());
            }
        } else {
            value = sdf.format(new Date());
        }
        return value;
    }

    /**
     * 获取当前日期前N月的当前日期 如: 获取2012-11-11的前一个月时间是:传参数1 结果:2012-10-11
     *
     * @param month  月份
     * @param format 格式化字符串
     * @return 返回月份字符串
     */
    public static String getDateForMonth(String format, int month) {
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
     * @param date 日期
     * @return 返回格式化后的日期
     */
    public static String formatDate4(Object date) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String value = "";
        if (date != null) {
            try {
                value = sdf.format(date);
            } catch (Exception e) {
                value = sdf.format(new Date());
            }
        } else {
            value = sdf.format(new Date());
        }
        return value;
    }


    /**
     * 计算两个日期时间相差多少时间
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param format    格式化
     * @return xxx天xxx小时xxx分钟
     */
    public static String dateDiff(String startTime, String endTime, String format) {
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
        try {
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            day = diff / nd;// 计算差多少天
            hour = diff % nd / nh + day * 24;// 计算差多少小时
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
            if (day < 1) {
                // 输出结果
                if (hour < 1) {
                    return min + "分钟";
                } else {
                    return hour + "小时";// +min+"分钟";
                }
            } else {
                return day + "天";// +(hour-day*24)+"小时"+(min-day*24*60)+"分钟";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 传入格式化时间,把它转换成它对应的毫秒数
     *
     * @param time (格式化时间如:2012-06-30 12:12:32)
     * @return 返回格式化后的日期
     */
    public static long getTimeToLong(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(time);
            long time_l = date.getTime();
            return time_l;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 将字符串转换成一个日期(yyyy-MM-dd HH:mm:ss)
     *
     * @return 返回格式化后的日期
     */
    public static Date strToDate1(String date) {
        Date dt = null;
        SimpleDateFormat sdf = new SimpleDateFormat(ALL_DATES1);
        try {
            dt = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }


    /**
     * 计算两个日期之间相差的天数
     *
     * @param time1 日期一
     * @param time2 日期二
     * @return 返回相差的天数
     */
    public static long getQuot(String time1, String time2) {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }

    /**
     * 计算两个时间相差的分钟数
     *
     * @param startTime 开始时间(格式：yyyy-MM-dd HH:mm:ss)
     * @param endTime   结束时间(格式：yyyy-MM-dd HH:mm:ss)
     * @return
     * @author angelo
     */
    public static long getDiffMinute(String startTime, String endTime) {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateEndTime = ft.parse(endTime);
            Date dateStartTime = ft.parse(startTime);
            quot = dateEndTime.getTime() - dateStartTime.getTime();
            quot = quot / 1000 / 60;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }

    /**
     * 判断两个日期时间大小
     *
     * @param lastDate 开始日期
     * @param nowDate  结束日期
     * @return
     * @throws ParseException
     */
    public static boolean beforeDate(String lastDate, String nowDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);
        Date d = sdf.parse(lastDate);
        Date d2 = sdf.parse(nowDate);
        boolean flag = d.before(d2);
        return flag;
    }

    /**
     * 判断两个日期时间大小
     *
     * @param lastDate 开始日期
     * @param nowDate  结束日期
     * @return
     * @throws ParseException
     */
    public static boolean beforeYMDDate(String lastDate, String nowDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date d = sdf.parse(lastDate);
        Date d2 = sdf.parse(nowDate);
        boolean flag = d.before(d2);
        return flag;
    }

    /**
     * 获取某年某月有多少天
     *
     * @param year  年份
     * @param month 月份
     * @return 返回天数
     */
    public static int getMonthDays(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        return cal.getActualMaximum(Calendar.DATE);
    }


    /**
     * 前天天
     *
     * @param format
     * @return
     */
    public static String beforeYesterdayDate(String format) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);
        return getDateFormat(format).format(calendar.getTime());
    }

    /**
     * 昨天
     *
     * @param format
     * @return
     */
    public static String yesterday(String format) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return getDateFormat(format).format(calendar.getTime());
    }

    /**
     * 今天
     *
     * @param format
     * @return
     */
    public static String today(String format) {

        return getDateFormat(format).format(new Date());
    }

    /**
     * 明天
     *
     * @param format
     * @return
     */
    public static String tomorrow(String format) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return getDateFormat(format).format(calendar.getTime());
    }

    /**
     * 判断是否为工作日(周六和周日为非工作日)
     *
     * @param date
     * @return
     */
    public static boolean isWorkDay(Date date) {

        return !isNotWorkDay(date);
    }

    /**
     * 判断是否为工作日(周六和周日为非工作日)
     *
     * @param date
     * @return
     */
    public static boolean isNotWorkDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        return week == Calendar.SUNDAY || week == Calendar.SATURDAY;
    }

    /**
     * 判断第一个时间是否小于第二个时间
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isLess(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2);
        return milliseconds < 0;
    }

    /**
     * 判断第一个时间是否不小于第二个时间
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isNotLess(String str1, String str2) {

        return !isLess(str1, str2);
    }

    /**
     * 判断第一个时间是否小于第二个时间
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static boolean isLess(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return milliseconds < 0;
    }

    /**
     * 判断第一个时间是否不小于第二个时间
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static boolean isNotLess(String str1, String str2, String format) {

        return !isLess(str1, str2, format);
    }

    /**
     * 判断第一个时间是否大于第二个时间
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isGreater(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2);
        return milliseconds > 0;
    }

    /**
     * 判断第一个时间是否不大于第二个时间
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isNotGreater(String str1, String str2) {

        return !isGreater(str1, str2);
    }

    /**
     * 判断第一个时间是否大于第二个时间
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static boolean isGreater(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return milliseconds > 0;
    }

    /**
     * 判断第一个时间是否不大于第二个时间
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static boolean isNotGreater(String str1, String str2, String format) {

        return !isGreater(str1, str2, format);
    }

    /**
     * 判断两个时间是否相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isEquals(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2);
        return milliseconds == 0;
    }

    /**
     * 判断两个时间是否不相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isNotEquals(String str1, String str2) {

        return !isEquals(str1, str2);
    }

    /**
     * 判断两个日期是否不相等
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEquals(Date date1, Date date2) {

        if (ValidatorUtil.isNotEquals(getYear(date1), getYear(date2))
                || ValidatorUtil.isNotEquals(getMonth(date1), getMonth(date2))
                || ValidatorUtil.isNotEquals(getDay(date1), getDay(date2))) {

            return false;
        }
        return true;
    }

    /**
     * 判断两个日期是否不相等
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isNotEquals(Date date1, Date date2) {

        return !isEquals(date1, date2);
    }

    /**
     * 判断两个时间是否相等
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static boolean isEquals(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return milliseconds == 0;
    }

    /**
     * 判断两个时间是否不相等
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static boolean isNotEquals(String str1, String str2, String format) {

        return !isEquals(str1, str2, format);
    }

    /**
     * 判断是否为闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {

        return year < 1 ? false : (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    /**
     * 判断是否不为闰年
     *
     * @param year
     * @return
     */
    public static boolean isNotLeapYear(int year) {

        return !isLeapYear(year);
    }

    /**
     * 判断是否为闰年
     *
     * @param date
     * @return
     */
    public static boolean isLeapYear(Date date) {

        return isLeapYear(getYear(date));
    }

    /**
     * 判断是否不为闰年
     *
     * @param date
     * @return
     */
    public static boolean isNotLeapYear(Date date) {

        return !isLeapYear(date);
    }


    /**
     * 设置日期中的某个数值
     *
     * @param date
     * @param dateType
     * @param amount
     * @return
     */
    public static Date set(Date date, int dateType, int amount) {

        if (null == date) {

            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(dateType, amount);
        return calendar.getTime();
    }

    /**
     * 设置日期:年
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setYear(Date date, int amount) {

        return set(date, Calendar.YEAR, amount);
    }

    /**
     * 设置日期:月
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setMonth(Date date, int amount) {

        return set(date, Calendar.MONTH, amount);
    }

    /**
     * 设置日期:日
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setDay(Date date, int amount) {

        return set(date, Calendar.DATE, amount);
    }

    /**
     * 设置日期:时
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setHour(Date date, int amount) {

        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 设置日期:分
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setMinute(Date date, int amount) {

        return set(date, Calendar.MINUTE, amount);
    }

    /**
     * 设置日期:秒
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setSecond(Date date, int amount) {

        return set(date, Calendar.SECOND, amount);
    }

    /**
     * 设置日期:毫秒
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date setMillisecond(Date date, int amount) {

        return set(date, Calendar.MILLISECOND, amount);
    }

    /**
     * 获取指定日期的上一年
     *
     * @param date
     * @return
     */
    public static Date prevYear(Date date) {

        return setYear(date, -1);
    }

    /**
     * 获取指定日期的下一年
     *
     * @param date
     * @return
     */
    public static Date nextYear(Date date) {

        return setYear(date, 1);
    }

    /**
     * 获取指定日期的上一月
     *
     * @param date
     * @return
     */
    public static Date prevMonth(Date date) {

        return setMonth(date, -1);
    }

    /**
     * 获取指定日期的下一月
     *
     * @param date
     * @return
     */
    public static Date nextMonth(Date date) {

        return setMonth(date, 1);
    }

    /**
     * 获取指定日期的上一天
     *
     * @param date
     * @return
     */
    public static Date prevDay(Date date) {

        return setDay(date, -1);
    }

    /**
     * 获取指定日期的下一天
     *
     * @param date
     * @return
     */
    public static Date nextDay(Date date) {

        return setDay(date, 1);
    }

    /***
     * 获取两个日期相差月数
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     * @throws ParseException
     */
    public static Integer intervalMonth(String str1, String str2, String format) {
        try {
            if (StringUtils.isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(str1));
            c2.setTime(sdf.parse(str2));
            int year1 = c1.get(Calendar.YEAR);
            int year2 = c2.get(Calendar.YEAR);
            int month1 = c1.get(Calendar.MONTH);
            int month2 = c2.get(Calendar.MONTH);
            int day1 = c1.get(Calendar.DAY_OF_MONTH);
            int day2 = c2.get(Calendar.DAY_OF_MONTH);

            int yearInterval = year1 - year2;
            if (month1 < month2 || month1 == month2 && day1 < day2)
                yearInterval--;
            // 获取月数差值
            int monthInterval = (month1 + 12) - month2;
            if (day1 < day2)
                monthInterval--;
            monthInterval %= 12;
            return yearInterval * 12 + monthInterval;

        } catch (Exception e) {

            logger.warn(e);
        }

        return null;
    }

    /**
     * 获取两个日期相差天数
     *
     * @param str1
     * @param str2
     * @return
     */
    public static Integer intervalDays(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2, FORMAT_DATE);
        return null == milliseconds ? null : (int) (milliseconds / (24 * 60 * 60 * 1000));
    }

    /**
     * 获取两个日期相差天数
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static Integer intervalDays(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return null == milliseconds ? null : (int) (milliseconds / (24 * 60 * 60 * 1000));
    }

    /**
     * 获取两个日期相差小时数
     *
     * @param str1
     * @param str2
     * @return
     */
    public static Long intervalHours(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2, "yyyy-MM-dd HH");
        return null == milliseconds ? null : (long) (milliseconds / (60 * 60 * 1000));
    }

    /**
     * 获取两个日期相差小时数
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static Long intervalHours(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return null == milliseconds ? null : (long) (milliseconds / (60 * 60 * 1000));
    }

    /**
     * 获取两个日期相差分钟数
     *
     * @param str1
     * @param str2
     * @return
     */
    public static Long intervalMinutes(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2, "yyyy-MM-dd HH:mm");
        return null == milliseconds ? null : (long) (milliseconds / (60 * 1000));
    }

    /**
     * 获取两个日期相差分钟数
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static Long intervalMinutes(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return null == milliseconds ? null : (long) (milliseconds / (60 * 1000));
    }

    /**
     * 获取两个日期相差秒数
     *
     * @param str1
     * @param str2
     * @return
     */
    public static Long intervalSeconds(String str1, String str2) {

        Long milliseconds = intervalMilliseconds(str1, str2, FORMAT_DATE_TIME);
        return null == milliseconds ? null : (long) (milliseconds / 1000);
    }

    /**
     * 获取两个日期相差秒数
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static Long intervalSeconds(String str1, String str2, String format) {

        Long milliseconds = intervalMilliseconds(str1, str2, format);
        return null == milliseconds ? null : (long) (milliseconds / 1000);
    }

    /**
     * 获取两个日期相差毫秒数
     *
     * @param str1
     * @param str2
     * @return
     */
    public static Long intervalMilliseconds(String str1, String str2) {

        return intervalMilliseconds(str1, str2, "yyyy-MM-dd HH:mm:ss:SSS");
    }

    /**
     * 获取两个日期相差毫秒数
     *
     * @param str1
     * @param str2
     * @param format
     * @return
     */
    public static Long intervalMilliseconds(String str1, String str2, String format) {

        try {

            str1 = reformat(str1, format);
            str2 = reformat(str2, format);
            DateFormat dateFormat = getDateFormat(format);
            Date date1 = dateFormat.parse(str1);
            Date date2 = dateFormat.parse(str2);
            return toMilliseconds(date1) - toMilliseconds(date2);
        } catch (Exception e) {

            logger.warn(e);
        }
        return null;
    }

    /**
     * 获取两个日期相差毫秒数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long intervalMilliseconds(Date date1, Date date2) {

        Long milliseconds1 = toMilliseconds(date1);
        Long milliseconds2 = toMilliseconds(date2);
        return (null == milliseconds1 || null == milliseconds2) ? null : milliseconds1 - milliseconds2;
    }

    /**
     * 将指定日期转换为时间戳对象
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Timestamp toTimestamp(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 将日期对象转换为指定日期格式的日期对象
     *
     * @param date
     * @param format
     * @return
     */
    public static Date toDate(Date date, String format) {
        return toDate(toString(date, format), format);
    }

    /**
     * 将时间戳对象转换为指定日期格式的日期字符串
     *
     * @param timestamp
     * @param format
     * @return
     */
    public static String toString(Timestamp timestamp, String format) {

        if (null != timestamp && ValidatorUtil.isNotEmptyIgnoreBlank(format)) {

            try {

                return getDateFormat(format).format(timestamp);
            } catch (Exception e) {

                logger.warn(e);
            }
        }
        return null;
    }

    /**
     * 将日期对象转换为指定日期格式的日期字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String toString(Date date, String format) {

        if (null != date && ValidatorUtil.isNotEmptyIgnoreBlank(format)) {

            try {

                return getDateFormat(format).format(date);
            } catch (Exception e) {

                logger.warn(e);
            }
        }
        return null;
    }

    /**
     * 将时间戳对象转换为指定日期格式的日期字符串
     *
     * @param timeStamp
     * @param format
     * @return
     */
    public static String toString(long timeStamp, String format) {

        return toString(new Date(timeStamp), format);
    }

    /**
     * 将原日期格式的日期字符串转换为新日期格式的日期字符串
     *
     * @param str
     * @param oldFormat
     * @param newFormat
     * @return
     */
    public static String toString(String str, String oldFormat, String newFormat) {

        if (ValidatorUtil.isEmptyIgnoreBlank(str, oldFormat, newFormat)) {

            return null;
        }
        return toString(toDate(str, oldFormat), newFormat);
    }

    /**
     * 将Unix时间戳字符串转换为指定日期格式的日期字符串
     *
     * @param unixTimestamp
     * @param format
     * @return
     */
    public static String unixTimestampToString(String unixTimestamp, String format) {

        if (ValidatorUtil.isInteger(unixTimestamp) && ValidatorUtil.isNotEmptyIgnoreBlank(format)) {

            try {

                Long timestamp = Long.parseLong(unixTimestamp) * 1000;
                return toString(timestamp, format);
            } catch (Exception e) {

                logger.warn(e);
            }
        }
        return null;
    }

    /**
     * 转换为毫秒数
     *
     * @param date
     * @return
     */
    public static Long toMilliseconds(Date date) {

        return null == date ? null : date.getTime();
    }

    /**
     * 转换为毫秒数
     *
     * @param str
     * @param format
     * @return
     */
    public static Long toMilliseconds(String str, String format) {

        return toMilliseconds(toDate(str, format));
    }

    /**
     * 转换为秒数
     *
     * @param str
     * @param format
     * @return
     */
    public static Long toSeconds(String str, String format) {

        Long milliseconds = toMilliseconds(str, format);
        return null == milliseconds ? null : (long) (milliseconds / 1000);
    }

    /**
     * 转换为分钟
     *
     * @param str
     * @param format
     * @return
     */
    public static Long toMinutes(String str, String format) {

        Long milliseconds = toMilliseconds(str, format);
        return null == milliseconds ? null : (long) (milliseconds / (60 * 1000));
    }

    /**
     * 转换为小时
     *
     * @param str
     * @param format
     * @return
     */
    public static Long toHours(String str, String format) {

        Long milliseconds = toMilliseconds(str, format);
        return null == milliseconds ? null : (long) (milliseconds / (60 * 60 * 1000));
    }

    /**
     * 将CST格式的日期字符串转换为日期对象
     *
     * @param str
     * @return
     */
    public static Date cstToDate(String str) {

        if (ValidatorUtil.isNotEmptyIgnoreBlank(str)) {

            try {

                SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_CST, java.util.Locale.US);
                return sdf.parse(str);
            } catch (Exception e) {

                logger.warn(e);
            }
        }
        return null;
    }

    /**
     * 将CST格式的日期字符串转换为指定格式的日期字符串
     *
     * @param str
     * @param format
     * @return
     */
    public static String cstToString(String str, String format) {

        return toString(cstToDate(str), format);
    }

    /**
     * 重新格式化
     *
     * <p>
     * 当日期字符串的格式不为指定日期格式时，在不改变原日期大小的情况下，生成新的日期字符串，简单适配指定日期格式
     * </p>
     *
     * @param str
     * @param format
     * @return
     */
    public static String reformat(String str, String format) {

        return str.length() < format.length()
                ? str.concat(format.substring(str.length()).replaceAll("[YyMmDdHhSs]", "0"))
                : str;
    }

    /**
     * 获取本年剩余天数
     *
     * @return
     */
    public static int remainDaysByYear() {

        Calendar calendar = Calendar.getInstance();
        int currentDays = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.roll(Calendar.DAY_OF_YEAR, false);
        int totalDays = calendar.get(Calendar.DAY_OF_YEAR);
        return totalDays - currentDays;
    }

    /**
     * 获取日期对象对应当年的剩余天数
     *
     * @param date
     * @return
     */
    public static Integer remainDaysByYear(Date date) {

        if (null == date) {

            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentDays = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.roll(Calendar.DAY_OF_YEAR, false);
        int totalDays = calendar.get(Calendar.DAY_OF_YEAR);
        return totalDays - currentDays;
    }

    /**
     * 获取日期字符串对应当年的剩余天数
     *
     * @param str
     * @param format
     * @return
     */
    public static Integer remainDaysByYear(String str, String format) {

        return remainDaysByYear(toDate(str, format));
    }

    /**
     * 获取本月剩余天数
     *
     * @return
     */
    public static int remainDaysByMonth() {

        Calendar calendar = Calendar.getInstance();
        int currentDays = calendar.get(Calendar.DAY_OF_MONTH);
        int totalDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return totalDays - currentDays;
    }

    /**
     * 获取日期对象对应当月的剩余天数
     *
     * @param date
     * @return
     */
    public static Integer remainDaysByMonth(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentDays = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DAY_OF_MONTH, false);
        int totalDays = calendar.get(Calendar.DAY_OF_MONTH);
        return totalDays - currentDays;
    }

    /**
     * 获取日期字符串对应当月的剩余天数
     *
     * @param str
     * @param format
     * @return
     */
    public static Integer remainDaysByMonth(String str, String format) {

        return remainDaysByMonth(toDate(str, format));
    }

    /**
     * 获取本月最后一天的日期对象
     *
     * @return
     */
    public static Date lastDayByMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取本月最后一天的日期字符串
     *
     * @param format
     * @return
     */
    public static String lastDayByMonth(String format) {

        return toString(lastDayByMonth(), format);
    }

    /**
     * 获取日期对象对应的当月最后一天的日期字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String lastDayByMonth(Date date, String format) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return toString(calendar.getTime(), format);
    }

    /**
     * 获取日期对象对应的当月最后一天的日期字符串
     *
     * @param str
     * @param format
     * @return
     */
    public static String lastDayByMonth(String str, String format) {

        return lastDayByMonth(toDate(str, format), format);
    }

    /**
     * 获取日期对象对应的当月最后一天的日期字符串
     *
     * @param str
     * @param oldFormat
     * @param newFormat
     * @return
     */
    public static String lastDayByMonth(String str, String oldFormat, String newFormat) {

        return lastDayByMonth(toDate(str, oldFormat), newFormat);
    }

    /**
     * 比较两个日期大小（不包含时分秒）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareTo(Date date1, Date date2) {

        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);

        int y1 = c1.get(Calendar.YEAR);
        int m1 = c1.get(Calendar.MONTH);
        int d1 = c1.get(Calendar.DAY_OF_MONTH);

        c1.setTime(date2);

        int y2 = c1.get(Calendar.YEAR);
        int m2 = c1.get(Calendar.MONTH);
        int d2 = c1.get(Calendar.DAY_OF_MONTH);

        if (y1 == y2 && m1 == m2 && d1 == d2) {
            return 0;
        }

        if (y1 > y2) {
            return 1;
        }

        if (y1 < y2) {
            return -1;
        }

        if (m1 > m2) {
            return 1;
        }

        if (m1 < m2) {
            return -1;
        }

        return d1 > d2 ? 1 : -1;
    }

    /**
     * 返回昨天的0时0分0秒与今天的0时0分0秒
     *
     * @return item[0] yesterday <br>
     * item[1] today
     */
    public static Timestamp[] getMidnightTimes() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        // Date end = cal.getTime();
        Timestamp end = new Timestamp(cal.getTimeInMillis());

        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        // Date start = cal.getTime();
        Timestamp start = new Timestamp(cal.getTimeInMillis());

        Timestamp[] t = {start, end};
        return t;
    }

    /**
     * 判断时间是否大于开始时间，并且小于结束时间
     *
     * @param str
     * @param startStr
     * @param endStr
     * @param format
     * @return
     */
    public static boolean isBetween(String str, String startStr, String endStr, String format) {

        try {

            str = reformat(str, format);
            startStr = reformat(startStr, format);
            endStr = reformat(endStr, format);
            DateFormat dateFormat = getDateFormat(format);
            Date date = dateFormat.parse(str);
            Date startDate = dateFormat.parse(startStr);
            Date endDate = dateFormat.parse(endStr);
            Long milliseconds = toMilliseconds(date);
            Long result = milliseconds - toMilliseconds(startDate);
            if (result > 0) {

                result = milliseconds - toMilliseconds(endDate);
                if (result < 0) {

                    return true;
                }
            }
        } catch (Exception e) {

            logger.warn(e);
        }
        return false;
    }

    /**
     * 判断时间是否不大于开始时间，或者不小于结束时间
     *
     * @param str
     * @param startStr
     * @param endStr
     * @param format
     * @return
     */
    public static boolean isNotBetween(String str, String startStr, String endStr, String format) {

        return !isBetween(str, startStr, endStr, format);
    }

    /**
     * 判断时间是否大于开始时间，并且小于结束时间
     *
     * @param date
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isBetween(Date date, Date startDate, Date endDate) {

        try {

            Long milliseconds = toMilliseconds(date);
            Long result = milliseconds - toMilliseconds(startDate);
            if (result > 0) {

                result = milliseconds - toMilliseconds(endDate);
                if (result < 0) {

                    return true;
                }
            }
        } catch (Exception e) {

            logger.warn(e);
        }
        return false;
    }

    /**
     * 判断时间是否不大于开始时间，或者不小于结束时间
     *
     * @param date
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isNotBetween(Date date, Date startDate, Date endDate) {

        return !isBetween(date, startDate, endDate);
    }

    /**
     * 判断时间是否不小于开始时间，并且不大于结束时间
     *
     * @param str
     * @param startStr
     * @param endStr
     * @param format
     * @return
     */
    public static boolean isBetweenEquals(String str, String startStr, String endStr, String format) {

        try {

            str = reformat(str, format);
            startStr = reformat(startStr, format);
            endStr = reformat(endStr, format);
            DateFormat dateFormat = getDateFormat(format);
            Date date = dateFormat.parse(str);
            Date startDate = dateFormat.parse(startStr);
            Date endDate = dateFormat.parse(endStr);
            Long milliseconds = toMilliseconds(date);
            Long result = milliseconds - toMilliseconds(startDate);
            if (result >= 0) {

                result = milliseconds - toMilliseconds(endDate);
                if (result <= 0) {

                    return true;
                }
            }
        } catch (Exception e) {

            logger.warn(e);
        }
        return false;
    }

    /**
     * 判断时间是否小于开始时间，或者大于结束时间
     *
     * @param str
     * @param startStr
     * @param endStr
     * @param format
     * @return
     */
    public static boolean isNotBetweenEquals(String str, String startStr, String endStr, String format) {

        return !isBetweenEquals(str, startStr, endStr, format);
    }

    /**
     * 判断时间是否不小于开始时间，并且不大于结束时间
     *
     * @param date
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isBetweenEquals(Date date, Date startDate, Date endDate) {

        try {

            Long milliseconds = toMilliseconds(date);
            Long result = milliseconds - toMilliseconds(startDate);
            if (result >= 0) {

                result = milliseconds - toMilliseconds(endDate);
                if (result <= 0) {

                    return true;
                }
            }
        } catch (Exception e) {

            logger.warn(e);
        }
        return false;
    }

    /**
     * 判断时间是否小于开始时间，或者大于结束时间
     *
     * @param date
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isNotBetweenEquals(Date date, Date startDate, Date endDate) {

        return !isBetweenEquals(date, startDate, endDate);
    }

    //
    private static SimpleDateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }
}
