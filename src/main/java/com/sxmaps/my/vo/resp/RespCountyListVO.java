package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(value = "区返回VO信息")
public class RespCountyListVO implements Serializable {

	@ApiModelProperty(name = "uid", value = "主键ID", example = "510000")
	private String uid;

	@ApiModelProperty(name = "codeId", value = "区域ID", example = "510000")
	private String codeId;

	/**
	 * 区域名称
	 */
	@ApiModelProperty(name = "areaName", value = "区域名称", example = "四川省")
	private String areaName;

	/**
	 * 父编号
	 */
	@ApiModelProperty(name = "parentId", value = "父编号", example = "0")
	private String parentId;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "RespCountyListVO [uid=" + uid + ", codeId=" + codeId + ", areaName=" + areaName + ", parentId="
				+ parentId + "]";
	}

}
