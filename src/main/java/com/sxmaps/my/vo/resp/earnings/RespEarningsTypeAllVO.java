package com.sxmaps.my.vo.resp.earnings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "返回所有支付类型实体类")
public class RespEarningsTypeAllVO implements Serializable {

	@ApiModelProperty(name = "earningsTypeUid", value = "uid", example = "1")
	private Long earningsTypeUid;

	@ApiModelProperty(name = "earningsName", value = "名称", example = "玉米杆")
	private String earningsName;
}