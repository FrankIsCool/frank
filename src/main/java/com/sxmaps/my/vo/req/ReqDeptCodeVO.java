package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "分校部门编号管理VO")
public class ReqDeptCodeVO implements Serializable {
	/**
	 * uid
	 */
	private Long uid;

	/**
	 * 部门编号
	 */
	@NotBlank(message = "分校名称不可为空")
	@ApiModelProperty(name = "deptCode", value = "部门编号(必填)", allowEmptyValue = false)
	private String deptCode;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@Override
	public String toString() {
		return "ReqDeptCodeVO [uid=" + uid + ", deptCode=" + deptCode + "]";
	}

}
