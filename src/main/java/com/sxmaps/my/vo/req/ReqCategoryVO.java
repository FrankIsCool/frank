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
@ApiModel(description = "类型管理VO")
public class ReqCategoryVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键id,添加可不传", example = "1")
	private Long uid;

	/**
	 * 类别名称
	 */
	@NotBlank(message = "类别名称不可为空")
	@ApiModelProperty(name = "cateName", value = "类别名称(必填)", example = "售后", allowEmptyValue = false)
	private String cateName;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "ReqCategoryVO [uid=" + uid + ", cateName=" + cateName + "]";
	}

}
