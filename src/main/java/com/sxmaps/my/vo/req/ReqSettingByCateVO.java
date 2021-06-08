package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "类别参数VO")
public class ReqSettingByCateVO implements Serializable {
	/**
	 * 类别uid
	 */
	@NotBlank(message = "类别uid不能为空")
	@ApiModelProperty(name = "settingUid", value = "类别uid(必填)", example = "123", allowEmptyValue = false)
	private String settingUid;

	public String getSettingUid() {
		return settingUid;
	}

	public void setSettingUid(String settingUid) {
		this.settingUid = settingUid;
	}

	@Override
	public String toString() {
		return "ReqSettingByCateVO [settingUid=" + settingUid + "]";
	}
}