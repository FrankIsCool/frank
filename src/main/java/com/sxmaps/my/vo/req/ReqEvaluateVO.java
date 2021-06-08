package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "评价续报学员VO")
public class ReqEvaluateVO {
	
	@ApiModelProperty("resubmitUid")
	private Long resubmitUid;
	
	@ApiModelProperty("学员Id")
	private String memberUid;
	
	@ApiModelProperty("评价等级")
	private Integer evaluateRank;
	
	
}
