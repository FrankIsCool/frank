package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "类别管理VO")
public class RespSettingVO implements Serializable {

	/**
	 * uid
	 */
	@ApiModelProperty(name = "settingUid", value = "类别主键ID", example = "1")
	private Long settingUid;

	/**
	 * 选项编码
	 */
	@ApiModelProperty(name = "opCode", value = "选项编码", example = "123456")
	private String opCode;

	/**
	 * 选项名称
	 */
	@ApiModelProperty(name = "opName", value = "选项名称", example = "售后")
	private String opName;

	public Long getSettingUid() {
		return settingUid;
	}

	public void setSettingUid(Long settingUid) {
		this.settingUid = settingUid;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	@Override
	public String toString() {
		return "RespSettingVO [settingUid=" + settingUid + ", opCode=" + opCode + ", opName=" + opName + "]";
	}

}