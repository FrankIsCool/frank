package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "用户id VO")
public class UserIdVO implements Serializable {

	@ApiModelProperty(name = "userId", notes = "用户ID", required = true)
	@NotNull(message = "用户ID不能为空")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
