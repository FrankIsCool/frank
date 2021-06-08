package com.sxmaps.mms.model;

public class JsonMessage {

	public static String SUCCESS = "SUCCESS";
	public static String FAIL = "FAIL";

	Integer code;
	String text;
	Object data;

	public JsonMessage() {
		super();
	}

	public JsonMessage(Integer code, String text, Object data) {
		super();
		this.code = code;
		this.text = text;
		this.data = data;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonMessage [code=" + code + ", text=" + text + ", data=" + data + "]";
	}

}
