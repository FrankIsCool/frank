package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "类型管理VO")
public class RespGoryVO implements Serializable {

	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键ID", example = "1")
	private Long uid;

	/**
	 * 类别编码
	 */
	@ApiModelProperty(name = "cateCode", value = "类别编码", example = "112233")
	private String cateCode;

	/**
	 * 类别名称
	 */
	@ApiModelProperty(name = "cateName", value = "类别名称", example = "售后")
	private String cateName;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "RespGoryVO [uid=" + uid + ", cateCode=" + cateCode + ", cateName=" + cateName + "]";
	}

}