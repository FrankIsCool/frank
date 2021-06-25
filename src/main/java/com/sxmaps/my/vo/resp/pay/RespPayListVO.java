package com.sxmaps.my.vo.resp.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "请求支付列表实体类")
public class RespPayListVO implements Serializable {

	@ApiModelProperty(name = "payName", value = "支付名称", example = "玉米")
	private String payName;

	@ApiModelProperty(name = "payTypeUid", value = "支付名称uid", example = "1")
	private Long payTypeUid;

	@ApiModelProperty(name = "payAmount", value = "支付金额", example = "1100.30")
	private BigDecimal payAmount;

	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	private Date createTime;

}