package com.sxmaps.mms.vo.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.sxmaps.mms.vo.QueryInfoVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel("ReqPerformanceRankingVO")
public class ReqPerformanceRankingVO extends QueryInfoVO{
	@ApiModelProperty(name = "startTime",value = "开始时间",example = "2018-07-01")
	private String startTime;
	@ApiModelProperty(name = "endTime",value = "结束时间",example = "2018-07-30")
	private String endTime;
	@NotBlank
	@ApiModelProperty(name = "timeQuantum",value = "时间段(DAILY,WEEKLY,MONTHLY,QUARTERLY,CUSTOM)",example = "DAILY")
	private String timeQuantum;
	@ApiModelProperty(name = "orderBy",value = "排序方式(SUMAMOUNT 总成交额,COMMONCOUNT 成交单数,HANSELCOUNT 定金单数,COUNSELCOUNT 咨询单数,OWNCOUNT 自营单数)",example = "SUMAMOUNT")
	private String orderBy;
	@ApiModelProperty(name = "deptList",value = "部门列表",hidden = true)
	private List<String> deptList;
	@ApiModelProperty(name = "campusCode",value = "部门ID,(0:查全部)")
	private String campusCode;
	@ApiModelProperty(name = "sort",value = "排序顺序(ASC 正序,DESC 倒序)",example = "DESC")
	private String sort;
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
	public List<String> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<String> deptList) {
		this.deptList = deptList;
	}
	public String getCampusCode() {
		return campusCode;
	}
	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "ReqPerformanceRankingVO [startTime=" + startTime + ", endTime=" + endTime + ", timeQuantum="
				+ timeQuantum + ", orderBy=" + orderBy + ", deptList=" + deptList + ", campusCode=" + campusCode
				+ ", sort=" + sort + "]";
	}
}
