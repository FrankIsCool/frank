package com.sxmaps.my.advice;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.JsonMessage;
import com.sxmaps.my.common.PageInfoTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
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
		// 记录日志
		logger.info("线程id: {},  返回结果集: {}",Thread.currentThread().getId(), object);
		if (!mediaTypes.contains(mediaType)) {
			return object;
		}
		// 返回结果非统一对象，则封装为同一对象
		if (object == null) {
			object = JsonMessage.createSuccessMessage();
		}
		if (object  instanceof PageInfo) {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request2 = attributes.getRequest();
			PageInfo pageInfo = (PageInfo)object;
			PageInfoTable table = new PageInfoTable();
			table.setPage(pageInfo,request2);
			object = JsonMessage.createSuccessMessage(table);
		}
		if (!(object instanceof JsonMessage)) {
			object = JsonMessage.createSuccessMessage(object);
		}
		return object;
	}

	@Override
	public boolean supports(MethodParameter methodParameter,
			Class<? extends HttpMessageConverter<?>> httpMessageConverter) {
		return true;
	}

}