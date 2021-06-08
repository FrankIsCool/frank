package com.sxmaps.mms.vo.req;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReqPerformanceForeRankVO")
public class ReqPerformanceForeRankVO {
	@ApiModelProperty(name = "userName",value = "用户名称",example = "张淼")
	private String userName;
	@ApiModelProperty(name = "sxDeptId",value = "所属咨询组",example = "+P8AAAAAFkjM567U")
	private String sxDeptId;
	@ApiModelProperty(name = "userId",value = "用户ID",hidden = true)
	private String userId;
	@NotBlank
	@ApiModelProperty(name = "timeQuantum",value = "时间段(WEEKLY,MONTHLY)",example = "WEEKLY")
	private String timeQuantum;
	@ApiModelProperty(name = "startTime",value = "开始时间",example = "2018-07-01",hidden = true)
	private String startTime;
	@ApiModelProperty(name = "endTime",value = "结束时间",example = "2018-07-30",hidden = true)
	private String endTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSxDeptId() {
		return sxDeptId;
	}
	public void setSxDeptId(String sxDeptId) {
		this.sxDeptId = sxDeptId;
	}
	public String getTimeQuantum() {
		return timeQuantum;
	}
	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
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
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ReqPerformanceForeRankVO [userName=" + userName + ", sxDeptId=" + sxDeptId + ", timeQuantum="
				+ timeQuantum + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
