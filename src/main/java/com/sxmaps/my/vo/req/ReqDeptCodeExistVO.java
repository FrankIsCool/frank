package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "分校管理VO")
public class ReqDeptCodeExistVO implements Serializable {
	/**
	 * 部门编号
	 */
	@ApiModelProperty(name = "deptCode", value = "部门编号")
	private String deptCode;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@Override
	public String toString() {
		return "ReqDeptCodeExistVO [deptCode=" + deptCode + "]";
	}

}
