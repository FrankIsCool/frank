package com.sxmaps.mms.vo.req;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "星级点评信息管理VO")
public class ReqScoreOpinionMapVO implements Serializable {
	/**
	 * 分值uid
	 */
	@NotNull(message = "分值uid不可为空")
	@ApiModelProperty(name = "scoreUid", value = "分值uid(必填)", example = "1", allowEmptyValue = false)
	private Long scoreUid;

	/**
	 * 点评uid
	 */
	@ApiModelProperty(name = "opinionList", value = "点评uid")
	private List<Long> opinionList;

	public Long getScoreUid() {
		return scoreUid;
	}

	public void setScoreUid(Long scoreUid) {
		this.scoreUid = scoreUid;
	}

	public List<Long> getOpinionList() {
		return opinionList;
	}

	public void setOpinionList(List<Long> opinionList) {
		this.opinionList = opinionList;
	}

	@Override
	public String toString() {
		return "ReqScoreOpinionMapVO [scoreUid=" + scoreUid + ", opinionList=" + opinionList + "]";
	}

}