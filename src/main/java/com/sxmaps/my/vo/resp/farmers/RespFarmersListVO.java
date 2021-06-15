package com.sxmaps.my.vo.resp.farmers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "牧场详情")
public class RespFarmersListVO {

	@ApiModelProperty(value = "牧场uid")
	private Long farmersUid;

	@ApiModelProperty(value = "牧场名字")
	private String farmersName;

	@ApiModelProperty(value = "牧场地址")
	private String farmersAddress;
}
