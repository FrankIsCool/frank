package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReqPerformanceCountByMonthVO")
public class ReqPerformanceCountByMonthVO {
	@ApiModelProperty(name = "campusCode",value = "分校编号 (0,查全部)")
	private String campusCode;

	public String getCampusCode() {
		return campusCode;
	}

	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}

	@Override
	public String toString() {
		return "ReqPerformanceCountByMonthVO [campusCode=" + campusCode + "]";
	}
	
}
