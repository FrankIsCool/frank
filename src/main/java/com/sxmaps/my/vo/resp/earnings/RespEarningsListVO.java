package com.sxmaps.my.vo.resp.earnings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "请求收益列表实体类")
public class RespEarningsListVO implements Serializable {

	@ApiModelProperty(name = "earningsName", value = "收益名称", example = "玉米")
	private String earningsName;

	@ApiModelProperty(name = "earningsTypeUid", value = "收益名称uid", example = "1")
	private Long earningsTypeUid;

	@ApiModelProperty(name = "earningsAmount", value = "收益金额", example = "1100.30")
	private BigDecimal earningsAmount;

	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	private Date createTime;

}