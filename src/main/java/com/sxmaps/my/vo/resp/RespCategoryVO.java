package com.sxmaps.my.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "类型管理VO")
public class RespCategoryVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "categoryUid", value = "类型主键ID", example = "1")
	private Long categoryUid;

	/**
	 * 类别编码
	 */
	@ApiModelProperty(name = "cateCode", value = "类别编码", example = "123456")
	private String cateCode;

	/**
	 * 类别名称
	 */
	@ApiModelProperty(name = "cateName", value = "类别名称", example = "售后")
	private String cateName;
}