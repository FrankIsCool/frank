package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "星级点评信息管理VO")
public class RespScoreOpinionListVO implements Serializable {
	/**
	 * 分值
	 */
	@ApiModelProperty(name = "uid", value = "分值uid", example = "1")
	private Long uid;

	/**
	 * 分值
	 */
	@ApiModelProperty(name = "scoreKey", value = "分值Key", example = "1")
	private Double scoreKey;

	/**
	 * 分值名称
	 */
	@ApiModelProperty(name = "scoreName", value = "分值Value", example = "一星")
	private String scoreName;
	/**
	 * 评价信息
	 */
	@ApiModelProperty(name = "OpinionList", value = "评价信息")
	private List<RespOpinionListVO> OpinionList;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Double getScoreKey() {
		return scoreKey;
	}

	public void setScoreKey(Double scoreKey) {
		this.scoreKey = scoreKey;
	}

	public String getScoreName() {
		return scoreName;
	}

	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}

	public List<RespOpinionListVO> getOpinionList() {
		return OpinionList;
	}

	public void setOpinionList(List<RespOpinionListVO> opinionList) {
		OpinionList = opinionList;
	}

	@Override
	public String toString() {
		return "RespScoreOpinionListVO [uid=" + uid + ", scoreKey=" + scoreKey + ", scoreName=" + scoreName
				+ ", OpinionList=" + OpinionList + "]";
	}

}