/**
 * 
 */
package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author gongqingzhuan
 * @data 2018年3月14日
 *
 */
@SuppressWarnings("serial")
@ApiModel(description = "星级管理VO")
public class ReqScoreVO implements Serializable {
	/**
	 * 分值key
	 */
	@NotNull(message = "参数不可为空")
	@ApiModelProperty(name = "scoreKey", value = "星级key值(必填)", example = "1", allowEmptyValue = false)
	private Double scoreKey;

	public Double getScoreKey() {
		return scoreKey;
	}

	public void setScoreKey(Double scoreKey) {
		this.scoreKey = scoreKey;
	}

	@Override
	public String toString() {
		return "ReqScoreVO [scoreKey=" + scoreKey + "]";
	}

}
