package com.sxmaps.mms.vo.req;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReqPerformanceForeBySiteVO")
public class ReqPerformanceForeBySiteVO {
	@NotNull
	@ApiModelProperty(value = "站点号列表")
	private List<String> sites;
	
	@ApiModelProperty(value = "数据来源 0:在线;1:留言")
	private String source;
	
	@ApiModelProperty(value = "日期", hidden = true)
	private String date;

	public List<String> getSites() {
		return sites;
	}

	public void setSites(List<String> sites) {
		this.sites = sites;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "ReqPerformanceForeBySiteVO [sites=" + sites + ", source=" + source + ", date=" + date + "]";
	}
}
