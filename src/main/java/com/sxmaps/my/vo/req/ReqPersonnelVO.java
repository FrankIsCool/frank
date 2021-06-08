package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "子订单uid参数VO")
public class ReqPersonnelVO implements Serializable {
	/**
	 * 子订单uid
	 */
	@NotNull(message = "子订单uid不能为空")
	@ApiModelProperty(name = "orderItemId", value = "子订单uid(必填)", example = "1", allowEmptyValue = false)
	private Long orderItemId;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Override
	public String toString() {
		return "ReqPersonnelVO [orderItemId=" + orderItemId + "]";
	}

}