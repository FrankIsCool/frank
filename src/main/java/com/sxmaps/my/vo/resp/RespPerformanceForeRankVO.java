package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 前端咨询师业绩排名返回对象
 * @author liwenxin
 *
 */
@ApiModel("RespPerformanceForeRank")
public class RespPerformanceForeRankVO {
	@ApiModelProperty(name = "rank",value = "排名")
	private Integer rank;
	@ApiModelProperty(name = "count",value = "报名人数")
	private Integer count;
	@ApiModelProperty(name = "sumAmount",value = "业绩")
	private BigDecimal sumAmount;
	@ApiModelProperty(name = "deptName",value = "组别")
	private String deptName;
	@ApiModelProperty(name = "userName",value = "咨询师")
	private String userName;
	@ApiModelProperty(name = "userId",value = "咨询师ID")
	private String userId;
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RespPerformanceForeGroup [rank=" + rank + ", count=" + count + ", sumAmount=" + sumAmount
				+ ", deptName=" + deptName + ", userName=" + userName + "]";
	}
	
}
