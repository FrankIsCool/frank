package com.sxmaps.mms.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.afterturn.easypoi.excel.annotation.Excel;

@SuppressWarnings("serial")
public class ExportStationVO implements Serializable{
	@Excel(name = "排名",orderNum = "0")
	private Integer rank;
	@Excel(name = "分校名称",orderNum = "1")
	private String campusName;
	@Excel(name = "总成交额",orderNum = "2")
	private BigDecimal sumAmount;
	@Excel(name = "成交单数量",orderNum = "3")
	private Integer commonCount;
	@Excel(name = "定金单数量",orderNum = "4")
	private Integer hanselCount;
	@Excel(name = "咨询单数量",orderNum = "5")
	private Integer counselCount;
	@Excel(name = "自营单数量",orderNum = "6")
	private Integer ownCount;
	@Excel(name = "成交率",orderNum = "7")
	private String commonRate;
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public Integer getCommonCount() {
		return commonCount;
	}
	public void setCommonCount(Integer commonCount) {
		this.commonCount = commonCount;
	}
	public Integer getHanselCount() {
		return hanselCount;
	}
	public void setHanselCount(Integer hanselCount) {
		this.hanselCount = hanselCount;
	}
	public Integer getCounselCount() {
		return counselCount;
	}
	public void setCounselCount(Integer counselCount) {
		this.counselCount = counselCount;
	}
	public Integer getOwnCount() {
		return ownCount;
	}
	public void setOwnCount(Integer ownCount) {
		this.ownCount = ownCount;
	}
	public String getCommonRate() {
		return commonRate;
	}
	public void setCommonRate(String commonRate) {
		this.commonRate = commonRate;
	}
	@Override
	public String toString() {
		return "ExportStationVO [rank=" + rank + ", campusName=" + campusName + ", sumAmount=" + sumAmount
				+ ", commonCount=" + commonCount + ", hanselCount=" + hanselCount + ", counselCount=" + counselCount
				+ ", ownCount=" + ownCount + ", commonRate=" + commonRate + "]";
	}
	
}
