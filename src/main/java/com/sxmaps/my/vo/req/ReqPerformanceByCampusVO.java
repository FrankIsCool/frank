package com.sxmaps.mms.vo.req;

import org.hibernate.validator.constraints.NotBlank;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 通过分校统计请求对象
 * @author liwenxin
 *
 */
@ApiModel("ReqPerformanceByCampusVO")
public class ReqPerformanceByCampusVO{
	@ApiModelProperty(name = "campusCode",value = "分校ID (0,查全部)",example = "863742")
	private String campusCode;
	@ApiModelProperty(name = "startTime",value = "开始时间",example = "2018-07-01")
	private String startTime;
	@ApiModelProperty(name = "endTime",value = "结束时间",example = "2018-07-30")
	private String endTime;
	@NotBlank
	@ApiModelProperty(name = "timeQuantum",value = "时间段(DAILY,WEEKLY,MONTHLY,QUARTERLY,CUSTOM)",example = "DAILY")
	private String timeQuantum;
	@ApiModelProperty(name = "orderBy",value = "排序方式(SUMAMOUNT 总成交额,COMMONCOUNT 成交单数,HANSELCOUNT 定金单数,COUNSELCOUNT 咨询单数,OWNCOUNT 自营单数)",example = "SUMAMOUNT")
	private String orderBy;
	public String getCampusCode() {
		return campusCode;
	}
	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
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
	public String getTimeQuantum() {
		return timeQuantum;
	}
	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	@Override
	public String toString() {
		return "ReqPerformanceByCampusVO [campusCode=" + campusCode + ", startTime=" + startTime + ", endTime="
				+ endTime + ", timeQuantum=" + timeQuantum + ", orderBy=" + orderBy + "]";
	}
	
	
}
