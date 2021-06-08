package com.sxmaps.my.utils;

import java.util.UUID;

/**
 * UUID工具类
 * 
 * @author 刘泽
 * 
 */
public class UUIDUtil {

	/**
	 * 获得去掉“-”符号的UUID 
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString(); 
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}
	  
	 
	/**
	 * 去掉“字母”和“-”的UUID
	 * 
	 * @param count
	 *       
	 */
	public static String getUUID(int count) {
		String s = UUID.randomUUID().toString();
		return s.replaceAll("[a-z|-]", "").substring(0, count);
	}
	
	
	public static void main(String[] args) {
		System.out.println(getUUID(10));
	}
	 
}
