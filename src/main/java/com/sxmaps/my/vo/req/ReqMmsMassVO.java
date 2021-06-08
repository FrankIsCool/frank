package com.sxmaps.mms.vo.req;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "Long 单个参数VO")
public class ReqMmsMassVO implements Serializable {

	@NotNull(message = "参数不能为空")
	@ApiModelProperty(name = "uid", value = "uid(必填)", allowEmptyValue = false)
	private Long[] uid;

	public Long[] getUid() {
		return uid;
	}

	public void setUid(Long[] uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "ReqMmsMassVO [uid=" + Arrays.toString(uid) + "]";
	}

}