package com.sxmaps.mms.vo.resp;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "咨询师历史评价VO")
public class RespEvaluateRantVO {
	
	@ApiModelProperty("评价时间")
	private Date createTime;
	
	@ApiModelProperty("星级")
	private Integer evaluateRank;
	
	@ApiModelProperty("平均星级")
	private Double avgRank;

	@ApiModelProperty("评价人姓名")
	private String userName;
	
	@ApiModelProperty("评价人数")
	private Integer evaluateCount;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getEvaluateRank() {
		return evaluateRank;
	}

	public void setEvaluateRank(Integer evaluateRank) {
		this.evaluateRank = evaluateRank == null ? 0 : evaluateRank;
	}

	public Double getAvgRank() {
		return avgRank = avgRank == null ? 0 : avgRank;
	}

	public void setAvgRank(Double avgRank) {
		this.avgRank = avgRank;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getEvaluateCount() {
		return evaluateCount;
	}

	public void setEvaluateCount(Integer evaluateCount) {
		this.evaluateCount = evaluateCount;
	}
	
	
}
