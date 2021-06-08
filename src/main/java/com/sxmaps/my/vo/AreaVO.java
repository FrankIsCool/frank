package com.sxmaps.mms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class AreaVO implements Serializable {

	private String codeId;

	private String areaName;

	private String parentId;

	private List<AreaVO> childs = new ArrayList<>();

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

	public List<AreaVO> getChilds() {
		return childs;
	}

	public void setChilds(List<AreaVO> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "AreaVO [codeId=" + codeId + ", areaName=" + areaName + ", parentId=" + parentId + ", childs=" + childs
				+ "]";
	}

}
