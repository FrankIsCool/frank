package com.sxmaps.mms.vo.resp;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "操作日志VO")
@Data
public class RespDistributionLog {

	@ApiModelProperty("操作人")
	private String updateBy;
	
	@ApiModelProperty("操作时间")
	private Date updateTime;
	

	private Integer operationState;
	
	@ApiModelProperty("操作类型")
	private String operation;
	
	@ApiModelProperty("操作内容")
	private String operationContent;
	
	private String consultName;
}
