package com.sxmaps.my.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/*******************************************************************************
 * 日志工具类
 * 
 * @author : 刘泽
 * @chaDate: 2015-06-09
 ******************************************************************************/
public class LogUtil {

	/**
	 * 日志字符串拼接
	 * 
	 * @param date
	 * @return 字符串
	 */
	public static String logStr(String methodName, String param,
			String flagCode,long startTime,Object... objects) { 
		long endTime = System.currentTimeMillis(); 
	    float millisecond = endTime - startTime;
		StringBuffer buff = new StringBuffer();
		String str = "";
		if (param != null && objects.length > 0) {
			for (int i = 0; i <= objects.length - 1; i++) {
				if (i == objects.length - 1) {
					buff.append(objects[i]);
				}else{
					buff.append(objects[i] + "|"); 
				}
			}
			str = methodName + "|" + param + "|" + flagCode + "|" + "time cost:"+millisecond+" ms" + "|" + buff.toString();
		} else {
			str = methodName + "|" + param + "|" + flagCode + "|" + "time cost:"+millisecond+" ms";
		}
		return str;

	}
	
	/**
	 * 获取异常错误详细信息
	 * 
	 * @param date
	 * @return 字符串
	 */
	public static String getExMessage(Exception e) {
        StringWriter stringWriter= new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
	  
}
