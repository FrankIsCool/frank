package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(value = "市返回VO信息")
public class RespCityListVO implements Serializable {

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

	@ApiModelProperty(name = "countyList", value = "区信息")
	private List<RespCountyListVO> countyList;

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

	public List<RespCountyListVO> getCountyList() {
		return countyList;
	}

	public void setCountyList(List<RespCountyListVO> countyList) {
		this.countyList = countyList;
	}

	@Override
	public String toString() {
		return "RespCityListVO [uid=" + uid + ", codeId=" + codeId + ", areaName=" + areaName + ", parentId=" + parentId
				+ ", countyList=" + countyList + "]";
	}

}
