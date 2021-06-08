package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "String 单个参数VO")
public class ReqMmsQryNameVO implements Serializable {

	@NotBlank(message = "参数不可为空")
	@ApiModelProperty(name = "qryName(必填)", value = "参数名称", allowEmptyValue = false)
	private String qryName;

	public String getQryName() {
		return qryName;
	}

	public void setQryName(String qryName) {
		this.qryName = qryName;
	}

	@Override
	public String toString() {
		return "ReqMmsQryNameVO [qryName=" + qryName + "]";
	}

}