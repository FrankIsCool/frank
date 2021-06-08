package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class RespPerformanceForeDayVO {
	@ApiModelProperty(value = "课程咨询师ID")
	private String sellerID;
	@ApiModelProperty(value = "课程咨询师名称")
	private String sellerName;
	@ApiModelProperty(value = "到访数")
	private Integer visitsNum;
	@ApiModelProperty(value = "成交数")
	private Integer applyNum;
	@ApiModelProperty(value = "客单价")
	private BigDecimal customerPrice;
	@ApiModelProperty(value = "流水")
	private BigDecimal turnover;
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Integer getVisitsNum() {
		return visitsNum;
	}
	public void setVisitsNum(Integer visitsNum) {
		this.visitsNum = visitsNum;
	}
	public Integer getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}
	public BigDecimal getCustomerPrice() {
		return customerPrice;
	}
	public void setCustomerPrice(BigDecimal customerPrice) {
		this.customerPrice = customerPrice;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	@Override
	public String toString() {
		return "RespPerformanceForeDayVO [sellerID=" + sellerID + ", sellerName=" + sellerName + ", visitsNum="
				+ visitsNum + ", applyNum=" + applyNum + ", customerPrice=" + customerPrice + ", turnover=" + turnover
				+ "]";
	}
	
}
