package com.sxmaps.my.advice;

import com.sxmaps.my.common.JsonMessage;
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

@ControllerAdvice
public class GlobalExceptionHandler {
	final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 参数错误异常处理
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public JsonMessage argumentErrorHandler(MethodArgumentNotValidException exception) {
		JsonMessage responseMsg = new JsonMessage();
		responseMsg.setCode("0");
		responseMsg.setText("请求的参数有误");
		Map<String, String> mapErrFields = new HashMap<String, String>();
		for (FieldError err : exception.getBindingResult().getFieldErrors()) {
			mapErrFields.put(err.getField(), err.getDefaultMessage());
		}
		responseMsg.setData(mapErrFields);
		return responseMsg;
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
		JsonMessage responseMsg = new JsonMessage();
		if (exception instanceof ApiException) {
			responseMsg.setCode(((ApiException) exception).getErrorCode());
			responseMsg.setText(exception.getMessage());
		} else if (exception instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			responseMsg.setCode("404");
			responseMsg.setText("HTTP 404 NOT FOUND");
		} else if (exception instanceof SQLException) {
			responseMsg.setCode("1046");
			responseMsg.setText("数据库处理异常");
		} else if (exception instanceof DataAccessException || exception instanceof BadSqlGrammarException) {
			responseMsg.setCode("1036");
			responseMsg.setText("数据库异常");
		} else {
			responseMsg.setCode("500");
			responseMsg.setText(exception.getMessage());
		}
		logger.error("API_ERR: {}", exception.getMessage());
		return responseMsg;
	}
}