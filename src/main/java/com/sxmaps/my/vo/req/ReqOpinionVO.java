/**
 * 
 */
package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author gongqingzhuan
 * @data 2018年3月14日
 *
 */
@SuppressWarnings("serial")
@ApiModel(description = "评价管理VO")
public class ReqOpinionVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键id,添加可不传", example = "1")
	private Long uid;

	/**
	 * 点评项
	 */
	@NotBlank(message = "点评项不可为空")
	@ApiModelProperty(name = "views", value = "点评项(必填)", example = "升学好棒", allowEmptyValue = false)
	private String views;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "ReqOpinionVO [uid=" + uid + ", views=" + views + "]";
	}
}
