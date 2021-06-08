package com.sxmaps.my.utils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ValidateUtil
 */
public class ValidateUtil {

	public static boolean isValid(String str) {
		if (null == str) {
			return false;
		}
		if ("null".equalsIgnoreCase(str)) {
			return false;
		}
		String resStr = str.replaceAll("\"\"", "");
		if ("".equals(resStr.trim())) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static boolean isValid(Collection col) {
		if (col == null || col.isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean isValid(Object[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return true;
	}

	public static boolean isValid(Object o) {
		if (o == null) {
			return false;
		}
		return true;
	}



	// 判断邮箱
	public static boolean isEmail(String email) {
		String str = RegUtil.isEamil;
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	//判断手机
	public static boolean isMobile(String mobile)
	{
		Pattern p = Pattern.compile(RegUtil.isPhoneNumber);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	  
	//判断设备号
	public static boolean isImei(String imei)
	{
		Pattern p = Pattern.compile(RegUtil.isImei);
		Matcher m = p.matcher(imei);
		return m.matches();
	}
	
	//判断生日(yyyy-mm-dd)
	public static boolean isBirthday(String birthday)
	{
		Pattern p = Pattern.compile(RegUtil.isBirthday);
		Matcher m = p.matcher(birthday);
		return m.matches();
	}
	 
	//判断网址
	public static boolean isHttpUrl(String httpUrl)
	{
		Pattern p = Pattern.compile(RegUtil.isHttpUrl);
		Matcher m = p.matcher(httpUrl);
		return m.matches();
	}
	
	//判断非0的正整数
	public static boolean isPositiveInteger(String positiveInteger)
	{
		Pattern p = Pattern.compile(RegUtil.isPositiveInteger);
		Matcher m = p.matcher(positiveInteger);
		return m.matches();
	}
	
	
	//判断是否为汉字
	public static boolean isChinese(String chinese)
	{
		Pattern p = Pattern.compile(RegUtil.isChinese);
		Matcher m = p.matcher(chinese);
		return m.matches();
	}
	
	
	//判断身份证
	public static boolean isIDCard(String idCard)
	{
		Pattern p = Pattern.compile(RegUtil.isIDCard);
		Matcher m = p.matcher(idCard);
		return m.matches();
	}	
	 
	
	//判断是否是ip地址
	public static boolean isIP(String ip){
		Pattern p = Pattern.compile(RegUtil.isIP);
		Matcher m = p.matcher(ip);
		return m.matches();
	}
	
	/**
	 * 
	 * @Title: main
	
	 * @Description: TODO(正则表达式测试类)
	
	 * @param args void
	 */
	public static void main(String[] args) {
		System.out.println(isIP("192.168.40.198"));
	}
	
	
	
}