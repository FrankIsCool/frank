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
@ApiModel(description = "类别管理VO")
public class ReqSettingNameVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键id", example = "1")
	private Long uid;

	/**
	 * 选项名称
	 */
	@NotBlank(message = "选项名称不可为空")
	@ApiModelProperty(name = "opName", value = "选项名称(必填)", example = "退费", allowEmptyValue = false)
	private String opName;

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

	@Override
	public String toString() {
		return "ReqSettingNameVO [uid=" + uid + ", opName=" + opName + "]";
	}

}
