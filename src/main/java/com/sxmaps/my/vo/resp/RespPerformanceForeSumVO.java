package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("RespPerformanceForeSumVO")
public class RespPerformanceForeSumVO {
	@ApiModelProperty(name = "timeQuantum",value = "时间段(WEEKLY,MONTHLY)")
	private String timeQuantum;
	@ApiModelProperty(name = "count",value = "报名人数")
	private Integer count;
	@ApiModelProperty(name = "sumAmount",value = "总业绩")
	private BigDecimal sumAmount;
	@ApiModelProperty(name = "perList",value = "每日业绩")
	private List<RespPerformancePerMonthVO> perList;
	public String getTimeQuantum() {
		return timeQuantum;
	}
	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public List<RespPerformancePerMonthVO> getPerList() {
		return perList;
	}
	public void setPerList(List<RespPerformancePerMonthVO> perList) {
		this.perList = perList;
	}
	@Override
	public String toString() {
		return "RespPerformanceForeSumVO [timeQuantum=" + timeQuantum + ", count=" + count + ", sumAmount=" + sumAmount
				+ ", perList=" + perList + "]";
	}
	
	
}
