package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReqQryAreaIdByAreaNameVO")
public class ReqQryAreaIdByAreaNameVO {
	@ApiModelProperty(value = "城市名称")
	private String areaName;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "ReqQryAreaIdByAreaNameVO [areaName=" + areaName + "]";
	}
	
	
}
