package com.sxmaps.my.vo.resp.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "牛统计返回对象")
public class RespCowCollectVO {

	@ApiModelProperty(value = "uid")
	private Long farmersUid;

	@ApiModelProperty(value = "uid")
	private Long kindUid;

	@ApiModelProperty(value = "耳钉号")
	private Integer num;
}
