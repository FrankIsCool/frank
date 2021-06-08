package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "判断分校管理VO")
public class ReqCampusCodeVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键id", example = "1000", allowEmptyValue = false)
	private Long uid;

	/**
	 * 分校名称
	 */
	@NotBlank(message = "分校名称不可为空")
	@ApiModelProperty(name = "campusName", value = "分校名称(必填)", example = "车公庙分校", allowEmptyValue = false)
	private String campusName;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	@Override
	public String toString() {
		return "ReqCampusCodeVO [uid=" + uid + ", campusName=" + campusName + "]";
	}

}
