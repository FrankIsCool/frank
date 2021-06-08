package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "类型管理返回VO")
public class RespSettingByCateVO implements Serializable {

	@ApiModelProperty(name = "cateUid", value = "类型UID", example = "1")
	private String cateUid;

	@ApiModelProperty(name = "cateCode", value = "类型编号", example = "075968")
	private String cateCode;

	@ApiModelProperty(name = "cateName", value = "类型名称", example = "工单")
	private String cateName;

	@ApiModelProperty(name = "settUid", value = "类别UID", example = "2")
	private String settUid;

	@ApiModelProperty(name = "opCode", value = "类别编号", example = "230145")
	private String opCode;

	@ApiModelProperty(name = "opName", value = "类别名称", example = "工单投诉")
	private String opName;

	public String getCateUid() {
		return cateUid;
	}

	public void setCateUid(String cateUid) {
		this.cateUid = cateUid;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getSettUid() {
		return settUid;
	}

	public void setSettUid(String settUid) {
		this.settUid = settUid;
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
		return "RespSettingByCateVO [cateUid=" + cateUid + ", cateCode=" + cateCode + ", cateName=" + cateName
				+ ", settUid=" + settUid + ", opCode=" + opCode + ", opName=" + opName + "]";
	}

}