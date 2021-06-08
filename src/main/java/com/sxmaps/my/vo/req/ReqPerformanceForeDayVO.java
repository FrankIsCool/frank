package com.sxmaps.mms.vo.req;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("ReqPerformanceForeDayVO")
public class ReqPerformanceForeDayVO {
	@ApiModelProperty(value = "咨询师ID列表")
	private List<String> sellerList;
	@ApiModelProperty(value = "日期")
	private String date;

	public List<String> getSellerList() {
		return sellerList;
	}

	public void setSellerList(List<String> sellerList) {
		this.sellerList = sellerList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReqPerformanceForeDayVO [sellerList=" + sellerList + ", date=" + date + "]";
	}
	
}
