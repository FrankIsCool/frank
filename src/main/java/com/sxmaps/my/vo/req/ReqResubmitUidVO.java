package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "学员分配信息表")
@Data
public class ReqResubmitUidVO {

	@ApiModelProperty("uid")
	private Long uid;
	
	@ApiModelProperty("学员Id")
	private String memberId;
	
}
