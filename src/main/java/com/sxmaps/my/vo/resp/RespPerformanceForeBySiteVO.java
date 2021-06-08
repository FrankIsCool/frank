package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("RespPerformanceForeBySiteVO")
public class RespPerformanceForeBySiteVO {
	@ApiModelProperty(value = "站点号")
	private String siteSn;
	
	@ApiModelProperty(value = "报名单数")
	private Integer commonCount;
	
	@ApiModelProperty(value = "报名金额")
	private BigDecimal commonSum;
	
	@ApiModelProperty(value = "成交咨询师人数")
	private Integer consultantNum;
	
	@ApiModelProperty(value = "定金单数")
	private Integer hanselCount;
	
	@ApiModelProperty(value = "定金金额")
	private BigDecimal hanselSum;
	
	@ApiModelProperty(value = "咨询单数")
	private Integer counselCount;
	
	@ApiModelProperty(value = "人均产值")
	private Double avgPerConsultant;

	public Integer getCommonCount() {
		return commonCount;
	}

	public void setCommonCount(Integer commonCount) {
		this.commonCount = commonCount;
	}

	public BigDecimal getCommonSum() {
		return commonSum;
	}

	public void setCommonSum(BigDecimal commonSum) {
		this.commonSum = commonSum;
	}

	public Integer getHanselCount() {
		return hanselCount;
	}

	public void setHanselCount(Integer hanselCount) {
		this.hanselCount = hanselCount;
	}

	public BigDecimal getHanselSum() {
		return hanselSum;
	}

	public void setHanselSum(BigDecimal hanselSum) {
		this.hanselSum = hanselSum;
	}

	public Integer getCounselCount() {
		return counselCount;
	}

	public void setCounselCount(Integer counselCount) {
		this.counselCount = counselCount;
	}

	public Double getAvgPerConsultant() {
		return avgPerConsultant;
	}

	public void setAvgPerConsultant(Double avgPerConsultant) {
		this.avgPerConsultant = avgPerConsultant;
	}

	public String getSiteSn() {
		return siteSn;
	}

	public void setSiteSn(String siteSn) {
		this.siteSn = siteSn;
	}
	
	public Integer getConsultantNum() {
		return consultantNum;
	}

	public void setConsultantNum(Integer consultantNum) {
		this.consultantNum = consultantNum;
	}

	@Override
	public String toString() {
		return "RespPerformanceForeBySiteVO [siteSn=" + siteSn + ", commonCount=" + commonCount + ", commonSum="
				+ commonSum + ", consultantNum=" + consultantNum + ", hanselCount=" + hanselCount + ", hanselSum="
				+ hanselSum + ", counselCount=" + counselCount + ", avgPerConsultant=" + avgPerConsultant + "]";
	}

}
