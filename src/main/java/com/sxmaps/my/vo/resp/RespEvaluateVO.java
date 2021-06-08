package com.sxmaps.mms.vo.resp;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "历史评价VO")
@Data
public class RespEvaluateVO {
	
	@ApiModelProperty("星级平均评价")
	public RespEvaluateRantVO evaluateRantVO;
	
	@ApiModelProperty("历史评价记录")
	public List<RespEvaluateRantVO> evaluateRantList;
}
