package com.sxmaps.mms.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sxmaps.mms.model.JsonMessage;

public class WebTools {
	public static JsonMessage createSuccessMessage(Object msgData) {
		JsonMessage responseMsg = new JsonMessage();
		responseMsg.setCode(200);
		responseMsg.setText("success");
		responseMsg.setData(msgData);
		return responseMsg;
	}

	public static JsonMessage createSuccessMessage() {
		return createSuccessMessage(null);
	}

	public static JsonMessage createErrorMessage(Integer errorCode, String errorMsg) {
		return createErrorMessage(errorCode, errorMsg, null);
	}

	public static JsonMessage createErrorMessage(Integer errorCode, String errorMsg, Object msgData) {
		JsonMessage responseMsg = new JsonMessage();
		responseMsg.setCode(errorCode);
		responseMsg.setText(errorMsg);
		responseMsg.setData(msgData);
		return responseMsg;
	}

	/**
	 * 获取用户IP，如果HTTP头有x-forwarded-for则使用，无则取请求IP
	 * 
	 * @return
	 */
	public static String GetRemoteIp() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
