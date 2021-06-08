package com.sxmaps.mms.vo.resp;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("RespPerformanceForeRanksVO")
public class RespPerformanceForeRanksVO {
	@ApiModelProperty(name = "rankList",value = "咨询师排名")
	List<RespPerformanceForeRankVO> rankList = new ArrayList<RespPerformanceForeRankVO>();
	@ApiModelProperty(name = "sellerRank",value = "当前咨询师数据")
	RespPerformanceForeRankVO sellerRank;
	public List<RespPerformanceForeRankVO> getRankList() {
		return rankList;
	}
	public void setRankList(List<RespPerformanceForeRankVO> rankList) {
		this.rankList = rankList;
	}
	public RespPerformanceForeRankVO getSellerRank() {
		return sellerRank;
	}
	public void setSellerRank(RespPerformanceForeRankVO sellerRank) {
		this.sellerRank = sellerRank;
	}
	@Override
	public String toString() {
		return "RespPerformanceForeRanksVO [rankList=" + rankList + ", sellerRank=" + sellerRank + "]";
	}
	
}
