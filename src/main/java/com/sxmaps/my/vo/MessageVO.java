package com.sxmaps.mms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回结果")
public class MessageVO {
	@ApiModelProperty(value = "返回编码")
	private int code;
	@ApiModelProperty(value = "业务数据集")
	private Object data;
	@ApiModelProperty(value = "返回描述")
	private String text;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
