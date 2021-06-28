package com.sxmaps.my.vo.resp.earnings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "收益统计实体类")
public class RespEarningsCollectInfoVO implements Serializable {

	@ApiModelProperty(name = "earningsName", value = "收益名称", example = "玉米")
	private String earningsName;

	@ApiModelProperty(name = "earningsUid", value = "收益名称uid", example = "1")
	private Long earningsUid;

	@ApiModelProperty(name = "earningsAmount", value = "收益金额", example = "1100.30")
	private BigDecimal earningsAmount;
}