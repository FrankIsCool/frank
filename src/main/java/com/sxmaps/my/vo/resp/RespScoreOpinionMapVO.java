package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "星级点评信息管理VO")
public class RespScoreOpinionMapVO implements Serializable {

	/**
	 * 分值uid
	 */
	@ApiModelProperty(name = "scoreUid", value = "分值uid", example = "1")
	private Long scoreUid;

	/**
	 * 点评uid
	 */
	@ApiModelProperty(name = "opinionList", value = "点评uid", example = "28")
	private Long opinionUid;

	/**
	 * 评论项
	 */
	@ApiModelProperty(name = "views", value = "评论项", example = "升学好棒")
	private String views;

	/**
	 * 分值
	 */
	@ApiModelProperty(name = "scoreKey", value = "分值Key", example = "1")
	private Double scoreKey;

	/**
	 * 分值值
	 */
	@ApiModelProperty(name = "scoreName", value = "分值Name", example = "一星")
	private String scoreName;

	public Long getScoreUid() {
		return scoreUid;
	}

	public void setScoreUid(Long scoreUid) {
		this.scoreUid = scoreUid;
	}

	public Long getOpinionUid() {
		return opinionUid;
	}

	public void setOpinionUid(Long opinionUid) {
		this.opinionUid = opinionUid;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
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

	@Override
	public String toString() {
		return "RespScoreOpinionMapVO [scoreUid=" + scoreUid + ", opinionUid=" + opinionUid + ", views=" + views
				+ ", scoreKey=" + scoreKey + ", scoreName=" + scoreName + "]";
	}

}