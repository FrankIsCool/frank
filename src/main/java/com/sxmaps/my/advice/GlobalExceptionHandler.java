package com.sxmaps.my.advice;

import com.sxmaps.my.common.JsonMessage;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 类：异常处理
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 参数错误异常处理
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public JsonMessage argumentErrorHandler(MethodArgumentNotValidException exception) {
		JsonMessage errorMessage = JsonMessage.createErrorMessage(ApiExceptionEnum.PARAM);
		Map<String, String> mapErrFields = new HashMap<>();
		for (FieldError err : exception.getBindingResult().getFieldErrors()) {
			mapErrFields.put(err.getField(), err.getDefaultMessage());
		}
		errorMessage.setData(mapErrFields);
		return errorMessage;
	}

	/**
	 * 默认异常处理
	 * 
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public JsonMessage defaultErrorHandler(HttpServletRequest request, Exception exception) {
		logger.error("线程id: {},  异常信息: {}",Thread.currentThread().getId(), exception.getMessage());
		if (exception instanceof ApiException) {
			return JsonMessage.createErrorMessage(((ApiException) exception).getErrorCode(),exception.getMessage());
		}
		if (exception instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			return JsonMessage.createErrorMessage(ApiExceptionEnum.NOTFOUND);
		}
		if (exception instanceof SQLException) {
			return JsonMessage.createErrorMessage(ApiExceptionEnum.DB);
		}
		if (exception instanceof DataAccessException || exception instanceof BadSqlGrammarException) {
			return JsonMessage.createErrorMessage(ApiExceptionEnum.DB);
		}
		return JsonMessage.createErrorMessage(ApiExceptionEnum.EXCEPTION);
	}
}