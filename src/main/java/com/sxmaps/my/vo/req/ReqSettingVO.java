/**
 * 
 */
package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author gongqingzhuan
 * @data 2018年3月14日
 *
 */
@SuppressWarnings("serial")
@ApiModel(description = "类别管理VO")
public class ReqSettingVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键id,添加可不传", example = "1")
	private Long uid;

	/**
	 * 选项名称
	 */
	@NotBlank(message = "选项名称不可为空")
	@ApiModelProperty(name = "opName", value = "选项名称(必填)", example = "退费", allowEmptyValue = false)
	private String opName;

	/**
	 * 类别id
	 */
	@NotNull(message = "类别id不可为空")
	@ApiModelProperty(name = "cateId", value = "类别id(必填)", example = "2", allowEmptyValue = false)
	private Long cateId;

	/**
	 * 类别编码
	 */
	@NotBlank(message = "类别编码不可为空")
	@ApiModelProperty(name = "cateCode", value = "类别编码(必填)")
	private String cateCode;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	@Override
	public String toString() {
		return "ReqSettingVO [uid=" + uid + ", opName=" + opName + ", cateId=" + cateId + ", cateCode=" + cateCode
				+ "]";
	}

}
