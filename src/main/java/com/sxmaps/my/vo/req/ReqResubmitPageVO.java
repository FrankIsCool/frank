package com.sxmaps.mms.vo.req;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "分页查询续报学员")
@Data
public class ReqResubmitPageVO{
	
	/**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码", name = "pageNum", example = "1", required = true)
    @NotNull(message = "页码不能为空")
    private Integer pageNum;
    /**
     * 每页记录条数
     */
    @ApiModelProperty(value = "每页记录条数", name = "pageSize", example = "10", required = true)
    @NotNull(message = "每页记录条数不能为空")
    private Integer pageSize;
    
    private String userId;
    
    @ApiModelProperty(value = "学员姓名")
    private String trueName;
    
    @ApiModelProperty(value = "手机号")
    private String cellPhone;

	@ApiModelProperty("学校Id")
	private Integer collegeUid;
	
	@ApiModelProperty("专业Id")
	private String departmentName;
	
	@ApiModelProperty("级别Id")
	private Integer levelTypeUid;
	
	@ApiModelProperty("报名城市")
	private String areaName;
	
	@ApiModelProperty("报名开始时间")
	private String startOrderTime;
	
	@ApiModelProperty("报名结束时间")
	private String endOrderTime;

    @ApiModelProperty("导入开始时间")
    private String startCreateTime;
    
    @ApiModelProperty("导入开始时间")
    private String endCreateTime;
    
	@ApiModelProperty("分配时间")
	private String startAssignTime;
	
	@ApiModelProperty("分配时间")
	private String endAssignTime;
    
    @ApiModelProperty("咨询师")
    private String consultId;
    
    @ApiModelProperty("分配状态")
    private Integer distributionState;
    
    @ApiModelProperty("省份")
    private String provinceCode;
    
    @ApiModelProperty("城市")
    private String cityCode;
    
    @ApiModelProperty("地区")
    private String countyCode;

    private Integer type;

    @ApiModelProperty("微信类型：-1：全部，0：未知，1：已添加 2：未添加")
    private Integer wxChart;

    @ApiModelProperty("机会类型：-1：全部 0：未知 1：续报:2：老带新 ")
    private Integer changeType;
}
