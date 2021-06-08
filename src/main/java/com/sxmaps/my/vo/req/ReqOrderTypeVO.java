package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "订单uid参数VO")
public class ReqOrderTypeVO implements Serializable {
	/**
	 * 订单uid
	 */
	@NotNull(message = "uid不能为空")
	@ApiModelProperty(name = "uid", value = "uid(必填)", example = "1", allowEmptyValue = false)
	private Long uid;

	/**
	 * 订单类别
	 */
	@NotBlank(message = "订单类别不能为空")
	@ApiModelProperty(name = "orderType", value = "订单类别(必填)", example = "HANSEL", allowEmptyValue = false)
	private String orderType;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "ReqOrderTypeVO [uid=" + uid + ", orderType=" + orderType + "]";
	}

}