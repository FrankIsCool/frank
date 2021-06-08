package com.sxmaps.mms.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("RespReserveCountByDeptVO")
public class RespReserveCountByDeptVO {
	@ApiModelProperty(value = "分校名称")
	private String schoolName;
	@ApiModelProperty(value = "分校ID")
	private String schoolCode;
	@ApiModelProperty(value = "分校部门ID")
	private String schoolDeptId;
	@ApiModelProperty(value = "分校业绩")
	private Integer count;
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getSchoolDeptId() {
		return schoolDeptId;
	}
	public void setSchoolDeptId(String schoolDeptId) {
		this.schoolDeptId = schoolDeptId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "RespReserveCountByDeptVO [schoolName=" + schoolName + ", schoolCode=" + schoolCode + ", schoolDeptId="
				+ schoolDeptId + ", count=" + count + "]";
	}
	
}
