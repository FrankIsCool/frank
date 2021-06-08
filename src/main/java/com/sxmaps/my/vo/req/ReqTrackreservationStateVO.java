package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
public class ReqTrackreservationStateVO implements Serializable {

	@ApiModelProperty(name = "uid", value = "预约单uid", example = "2")
	private Long uid;

	@ApiModelProperty(name = "state", value = "状态 0未分配 1已分配", example = "2")
	private Integer state;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ReqTrackreservationStateVO [uid=" + uid + ", state=" + state + "]";
	}

}
