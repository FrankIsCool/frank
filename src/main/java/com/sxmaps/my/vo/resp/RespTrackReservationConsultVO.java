package com.sxmaps.mms.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "业务数据集")
public class RespTrackReservationConsultVO {
	/**
	 * 预约ID
	 */
	@ApiModelProperty(value = "预约ID")
	private String uid;
	/**
	 * 咨询师ID
	 */
	@ApiModelProperty(value = "咨询师ID")
	private String consultantUid;

	/**
	 * 咨询师名称
	 */
	@ApiModelProperty(value = "咨询师名称")
	private String consultantName;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String mobile;

	/**
	 * 岗位名称
	 */
	@ApiModelProperty(value = "岗位名称")
	private String postName;

	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "部门名称")
	private String deptName;
	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "父级部门名称")
	private String parentDetpName;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getConsultantUid() {
		return consultantUid;
	}

	public void setConsultantUid(String consultantUid) {
		this.consultantUid = consultantUid;
	}

	public String getConsultantName() {
		return consultantName;
	}

	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getParentDetpName() {
		return parentDetpName;
	}

	public void setParentDetpName(String parentDetpName) {
		this.parentDetpName = parentDetpName;
	}

	@Override
	public String toString() {
		return "RespTrackReservationConsultVO{" + "uid='" + uid + '\'' + ", consultantUid='" + consultantUid + '\''
				+ ", consultantName='" + consultantName + '\'' + ", mobile='" + mobile + '\'' + ", postName='"
				+ postName + '\'' + ", deptName='" + deptName + '\'' + ", parentDetpName='" + parentDetpName + '\''
				+ '}';
	}
}
