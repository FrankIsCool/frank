package com.sxmaps.mms.vo.req;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "分配学员VO")
@Data
public class ReqDistributionVO {
	
	@ApiModelProperty("咨询师Id")
	private String userId;
	
	@ApiModelProperty("咨询师名")
	private String userName;
	
	@ApiModelProperty("分配学员信息集合")
	private List<ReqResubmitUidVO> memberList;
	
	

}
