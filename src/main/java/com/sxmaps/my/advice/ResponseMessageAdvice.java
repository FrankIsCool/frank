package com.sxmaps.my.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxmaps.my.common.JsonMessage;
import com.sxmaps.my.common.WebTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice(basePackages = { "com.sxmaps.my.controller" })
public class ResponseMessageAdvice implements ResponseBodyAdvice<Object> {
	final Logger logger = LoggerFactory.getLogger(ResponseMessageAdvice.class);
	List<MediaType> mediaTypes = Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8);

	/**
	 * 格式化输出为统一JSON格式
	 * 
	 * @param object
	 * @param methodParameter
	 * @param mediaType
	 * @param converter
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType,
			Class<? extends HttpMessageConverter<?>> converter, ServerHttpRequest request,
			ServerHttpResponse response) {
		// 如果请求的ContentType不是application/json，则原样返回
		if (!mediaTypes.contains(mediaType)) {
			return object;
		}

		// 当范围实体非ResponseMsg实，则格式化为ResponseMsg
		if (object == null || !(object instanceof JsonMessage)) {
			object = WebTools.createSuccessMessage(object);
		}

		// 记录日志
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			logger.info("HTTP_RSP: {}", objectMapper.writeValueAsString(object));
		} catch (Exception e) {
			logger.error("parse return object error: {}", e.getMessage());
		}

		return object;
	}

	@Override
	public boolean supports(MethodParameter methodParameter,
			Class<? extends HttpMessageConverter<?>> httpMessageConverter) {
		return true;
	}

}