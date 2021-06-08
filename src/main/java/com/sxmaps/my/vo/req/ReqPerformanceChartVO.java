package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 业绩趋势图请求对象
 * @author liwenxin
 *
 */
@ApiModel("ReqPerformanceChartVO")
public class ReqPerformanceChartVO {
	@ApiModelProperty(name = "date",value = "查询时间(yyyy-MM)",example = "2018-07")
	private String date;
	@ApiModelProperty(name = "beginTime",value = "开始时间",hidden = true)
	private String beginTime;
	@ApiModelProperty(name = "endTime",value = "结束时间",hidden = true)
	private String endTime;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ReqPerformanceChartVO [date=" + date + ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}
	
	
}
