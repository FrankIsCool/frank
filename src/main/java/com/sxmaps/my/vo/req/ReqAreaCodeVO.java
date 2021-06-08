package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "查询城市VO")
@Data
public class ReqAreaCodeVO {
	
	private String areaCode;

}
