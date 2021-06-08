package com.sxmaps.mms.exception;

@SuppressWarnings("serial")
public class ApiException extends Exception {
	Integer errorCode;

	public ApiException(String errorMsg) {
		super(errorMsg);
		this.errorCode = 0;
	}

	public ApiException(Integer errorCode) {
		super("");
		this.errorCode = errorCode;
	}

	public ApiException(Integer errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}
}
