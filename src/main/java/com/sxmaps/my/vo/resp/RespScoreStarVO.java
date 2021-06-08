package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "类别管理VO")
public class RespScoreStarVO implements Serializable {

	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键ID", example = "1")
	private Long uid;

	/**
	 * 分值
	 */
	@ApiModelProperty(name = "scoreKey", value = "分值Key", example = "1")
	private Double scoreKey;

	/**
	 * 分值名称
	 */
	/**
	 * 分值
	 */
	@ApiModelProperty(name = "scoreName", value = "分值Value", example = "一星")
	private String scoreName;

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

	@Override
	public String toString() {
		return "RespScoreStarVO [uid=" + uid + ", scoreKey=" + scoreKey + ", scoreName=" + scoreName + "]";
	}

}