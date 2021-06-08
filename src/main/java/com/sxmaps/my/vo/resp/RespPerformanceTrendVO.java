package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 业绩趋势图返回对象
 * @author liwenxin
 *
 */
@ApiModel("RespPerformanceTrendVO")
public class RespPerformanceTrendVO {
	@ApiModelProperty(name = "sumAmount",value = "合计金额")
	private BigDecimal sumAmount;
	@ApiModelProperty(name = "list",value = "每日业绩")
	private List<RespPerformancePerMonthVO> list;
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public List<RespPerformancePerMonthVO> getList() {
		return list;
	}
	public void setList(List<RespPerformancePerMonthVO> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "RespPerformanceTrendVO [sumAmount=" + sumAmount + ", list=" + list + "]";
	}
	
}
