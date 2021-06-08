package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
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

	private List<RespSettingVO> settingList;

	public Long getCategoryUid() {
		return categoryUid;
	}

	public void setCategoryUid(Long categoryUid) {
		this.categoryUid = categoryUid;
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

	public List<RespSettingVO> getSettingList() {
		return settingList;
	}

	public void setSettingList(List<RespSettingVO> settingList) {
		this.settingList = settingList;
	}

	@Override
	public String toString() {
		return "RespCategoryVO [categoryUid=" + categoryUid + ", cateCode=" + cateCode + ", cateName=" + cateName
				+ ", settingList=" + settingList + "]";
	}

}