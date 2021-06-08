package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 业绩趋势图每日业绩返回对象
 * @author liwenxin
 *
 */
@ApiModel("RespPerformancePerMonthVO")
public class RespPerformancePerMonthVO {
	@ApiModelProperty(name = "date",value = "日期")
	private String date;
	@ApiModelProperty(name = "data",value = "数据")
	private BigDecimal data;
	@ApiModelProperty(name = "count",value = "个数")
	private Integer count;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getData() {
		return data;
	}
	public void setData(BigDecimal data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "RespPerformancePerMonthVO [date=" + date + ", data=" + data + ", count=" + count + "]";
	}
	
	
}
