package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "星级点评信息管理VO")
public class RespOpinionListVO implements Serializable {

	/**
	 * uid
	 */
	@ApiModelProperty(name = "opinionUid", value = "点评uid", example = "1")
	private Long opinionUid;

	/**
	 * uid
	 */
	@ApiModelProperty(name = "scoreUid", value = "分值uid", example = "1")
	private Long scoreUid;
	/**
	 * 点评项
	 */
	@NotBlank(message = "点评项不可为空")
	@ApiModelProperty(name = "views", value = "点评项", example = "升学好棒")
	private String views;

	public Long getOpinionUid() {
		return opinionUid;
	}

	public void setOpinionUid(Long opinionUid) {
		this.opinionUid = opinionUid;
	}

	public Long getScoreUid() {
		return scoreUid;
	}

	public void setScoreUid(Long scoreUid) {
		this.scoreUid = scoreUid;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "RespOpinionListVO [opinionUid=" + opinionUid + ", scoreUid=" + scoreUid + ", views=" + views + "]";
	}

}