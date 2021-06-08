package com.sxmaps.mms.vo.req;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ReqQryOrdersByDeptIdVO {
	 @ApiModelProperty(value = "部门ID", example = "1a71913fecec4a33843849b43d51dd67")
	 @NotNull(message = "部门ID不能为空")
	 private String deptId;

	 @ApiModelProperty(value = "开始时间", example = "2018-11-11 00:00:00")
	 @NotNull(message = "开始时间不能为空")
	 private String startTime;

	 @ApiModelProperty(value = "结束时间", example = "2018-11-11 00:00:00")
	 @NotNull(message = "结束时间不能为空")
	 private String endTime;
	 
	 @ApiModelProperty(value = "部门列表", hidden=true)
	 private String deptList;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDeptList() {
		return deptList;
	}

	public void setDeptList(String deptList) {
		this.deptList = deptList;
	}

	@Override
	public String toString() {
		return "ReqQryOrdersByDeptIdVO [deptId=" + deptId + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	
}
