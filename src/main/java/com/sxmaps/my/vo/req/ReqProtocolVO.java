package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "协议详情查看请求实体")
@SuppressWarnings("serial")
public class ReqProtocolVO implements Serializable {

	@NotBlank(message = "子订单号不可为空")
	@ApiModelProperty(value = "子订单号", example = "222")
	private String orderItemSn;
	
	@ApiModelProperty(value = "查看手机号")
	private Boolean isWatchable;

	public String getOrderItemSn() {
		return orderItemSn;
	}

	public void setOrderItemSn(String orderItemSn) {
		this.orderItemSn = orderItemSn;
	}

	public Boolean getIsWatchable() {
		return isWatchable;
	}

	public void setIsWatchable(Boolean isWatchable) {
		this.isWatchable = isWatchable;
	}

	@Override
	public String toString() {
		return "ReqProtocolVO [orderItemSn=" + orderItemSn + "]";
	}

}
