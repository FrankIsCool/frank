package com.sxmaps.my.exception;

import com.sxmaps.my.enums.ApiExceptionEnum;

@SuppressWarnings("serial")
public class ApiException extends RuntimeException {
	/**
	 * 错误编码
	 **/
	private String errorCode;


	public ApiException(ApiExceptionEnum exceptionEnum) {
		super(exceptionEnum.getExceptionDesc());
		this.errorCode = exceptionEnum.getExceptionCode();
	}
	public ApiException(String desc) {
		super(desc);
		this.errorCode = "500";
	}
	public String getErrorCode() {
		return errorCode;
	}
}
