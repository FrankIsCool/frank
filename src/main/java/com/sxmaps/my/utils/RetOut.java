package com.sxmaps.my.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RetOut implements Serializable {

	public static String AREA = "AREA:";

	public static String CITY = "CITY:";

	/**
	 * 支付宝支付成功码
	 */
	public static String ALIPAY_SUCCESS_CODE = "10000";
	/**
	 * 支付宝支付成功码
	 */
	public static String WXPAY_SUCCESS_CODE = "SUCCESS";

	public static String SUCCESS_CODE = "200";

	/**
	 * 提示信息
	 */
	public static String MSG = "msg";

	/**
	 * 二维码
	 */
	public static String QRCODE = "qrCode";

	/**
	 * 字符串常量
	 */
	public static String ZERO_STR = "0";

	public static String ONE_STR = "1";

	public static String TWO_STR = "2";

	public static String THREE_STR = "3";

	public static String FOUR_STR = "4";

	public static String FIVE_STR = "5";

	/**
	 * 数字常量
	 */
	public static Integer ZERO = 0;

	public static Integer ONE = 1;

	public static Integer TWO = 2;

	/**
	 * 操作成功
	 */
	public static String SUCCESS = "操作成功";

	/**
	 * 操作失败
	 */
	public static String FAIL = "操作失败";

	public RetOut() {
		super();
	}

	public RetOut(String msg) {
		super();
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "RetOut [msg=" + msg + "]";
	}

}
