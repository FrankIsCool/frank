package com.sxmaps.my.utils;
 

public class RegUtil { 
	public static final String isPhoneNumber = "(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}"; // 手机号码正则    
	
	public static final String isHttpUrl = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?"; // 验证网址Url  
	
	public static final String isEamil = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"; //验证邮箱

	public static final String isImei = "^[0-9A-Za-z]{14,70}$"; // 验证设备号
	
	public static final String isPassword = "^[0-9a-zA-Z]{6,12}$"; // 验证密码必须是6-12位字符(数字和字母)

	public static final String isNikeName = "^[a-zA-Z0-9_\u4e00-\u9fa5]+${6,12}$"; // 用户呢称6-12位正则(只含有汉字、数字、字母、下划线，下划线位置不限)
	
	public static final String isBirthday = "\\d{4}-\\d{2}-\\d{2}"; // 验证用户的生日(yyyy-mm-dd)格式
	
	public static final String isPositiveInteger = "^\\+?[1-9][0-9]*$"; // 只能输入非零的正整数
	
	public static final String isChinese = "^[\u4e00-\u9fa5]+$"; //判断是否为汉字
	
	public static final String isIDCard ="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$"; //判断身份证
	
	public static final String isIP="(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)"; //判断是否ip地址

	 
}
