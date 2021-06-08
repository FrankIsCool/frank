package com.sxmaps.mms.utils;

import java.io.Serializable;

/**
 * 订单支付回
 * 
 * @author chendehua
 *
 */
@SuppressWarnings("serial")
public class Result implements Serializable {

	private int code;

	private String msg;

	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
