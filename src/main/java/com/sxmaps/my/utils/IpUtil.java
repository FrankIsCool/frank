package com.sxmaps.my.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取客户端IP地址
 * 
 * @author Administrator
 * 
 */
public class IpUtil {

	/**
	 * 获取IP
	 * 
	 * @param request 对象
	 * @return 返回地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		int l = ip.indexOf(",");
		if (l != -1) {
			ip = ip.substring(0, l);
		}
		return ip;
	}

}
