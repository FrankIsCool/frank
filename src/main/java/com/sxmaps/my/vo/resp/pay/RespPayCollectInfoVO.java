package com.sxmaps.my.vo.resp.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "支出统计实体类")
public class RespPayCollectInfoVO implements Serializable {

	@ApiModelProperty(name = "payName", value = "支付名称", example = "玉米")
	private String payName;

	@ApiModelProperty(name = "payUid", value = "支付名称uid", example = "1")
	private Long payUid;

	@ApiModelProperty(name = "payAmount", value = "支付金额", example = "1100.30")
	private BigDecimal payAmount;
}