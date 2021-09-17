package com.sxmaps.my.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基础数据校验
 *
 * @author frank
 * @module
 * @date 2021/9/4 13:51
 */
public class EmptyUtil {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        isEmpty(list);
    }
    public static boolean isEmpty(Object o) {
        return null == o;
    }

    public static boolean isEmpty(String str) {
        if (null == str) {
            return true;
        }
        str = str.trim();
        if ("null".equalsIgnoreCase(str)) {
            return true;
        }
        if ("".equals(str.trim())) {
            return true;
        }
        return StringUtils.isBlank(str);
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }


    // 判断邮箱
    public static boolean isEmail(String email) {
        String str = RegUtil.isEamil;
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    //判断手机
    public static boolean isMobile(String mobile) {
        Pattern p = Pattern.compile(RegUtil.isPhoneNumber);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    //判断设备号
    public static boolean isImei(String imei) {
        Pattern p = Pattern.compile(RegUtil.isImei);
        Matcher m = p.matcher(imei);
        return m.matches();
    }

    //判断生日(yyyy-mm-dd)
    public static boolean isBirthday(String birthday) {
        Pattern p = Pattern.compile(RegUtil.isBirthday);
        Matcher m = p.matcher(birthday);
        return m.matches();
    }

    //判断网址
    public static boolean isHttpUrl(String httpUrl) {
        Pattern p = Pattern.compile(RegUtil.isHttpUrl);
        Matcher m = p.matcher(httpUrl);
        return m.matches();
    }

    //判断非0的正整数
    public static boolean isPositiveInteger(String positiveInteger) {
        Pattern p = Pattern.compile(RegUtil.isPositiveInteger);
        Matcher m = p.matcher(positiveInteger);
        return m.matches();
    }


    //判断是否为汉字
    public static boolean isChinese(String chinese) {
        Pattern p = Pattern.compile(RegUtil.isChinese);
        Matcher m = p.matcher(chinese);
        return m.matches();
    }


    //判断身份证
    public static boolean isIDCard(String idCard) {
        Pattern p = Pattern.compile(RegUtil.isIDCard);
        Matcher m = p.matcher(idCard);
        return m.matches();
    }


    //判断是否是ip地址
    public static boolean isIP(String ip) {
        Pattern p = Pattern.compile(RegUtil.isIP);
        Matcher m = p.matcher(ip);
        return m.matches();
    }
}