package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "转续报学员VO")
public class ReqMemberResubmitVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("学员Id")
	private String memberUid;
	
	@ApiModelProperty("学员姓名")
	private String trueName;
	
	@ApiModelProperty("学员电话")
	private String cellphone;
	
	@ApiModelProperty("报名时间")
	private String orderTime;
	
	@ApiModelProperty("报名城市")
	private String areaName;
	
	@ApiModelProperty("学校Id")
	private Long collegeUid;
	
	@ApiModelProperty("学校名称")
	private String collegeName;
	
	@ApiModelProperty("专业Id")
	private Long departmentUid;
	
	@ApiModelProperty("专业名称")
	private String departmentName;
	
	@ApiModelProperty("级别Id")
	private Long levelTypeUid;
	
	@ApiModelProperty("级别名称")
	private String levelTypeName;
	
	@ApiModelProperty("班主任Id")
	private String teacherUid;
	
	@ApiModelProperty("班主任名称")
	private String teacherName;
	
	
	
	
	
}
