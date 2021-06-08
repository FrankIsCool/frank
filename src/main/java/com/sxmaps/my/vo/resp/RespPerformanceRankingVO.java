package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 业绩排名返回对象
 * @author liwenxin
 *
 */
@ApiModel("RespPerformanceRankingVO")
public class RespPerformanceRankingVO {
	@ApiModelProperty(name = "rank",value = "排名")
	private Integer rank;
	@ApiModelProperty(name = "campusName",value = "分校名称")
	private String campusName;
	@ApiModelProperty(name = "sumAmount",value = "成交金额")
	private BigDecimal sumAmount;
	@ApiModelProperty(name = "commonCount",value = "成交单数")
	private Integer commonCount;
	@ApiModelProperty(name = "hanselCount",value = "定金单数")
	private Integer hanselCount;
	@ApiModelProperty(name = "counselCount",value = "咨询单数")
	private Integer counselCount;
	@ApiModelProperty(name = "ownCount",value = "自营单数")
	private Integer ownCount;
	@ApiModelProperty(name = "commonRate",value = "成交率")
	private BigDecimal commonRate;
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
	public BigDecimal getCommonRate() {
		return commonRate;
	}
	public void setCommonRate(BigDecimal commonRate) {
		this.commonRate = commonRate;
	}
	
}
