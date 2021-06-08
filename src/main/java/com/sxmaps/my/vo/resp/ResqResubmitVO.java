package com.sxmaps.mms.vo.resp;

import java.util.Date;
import java.util.List;

import com.sxmaps.mms.utils.DateUtil2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "续报学员VO")
public class ResqResubmitVO {

	@ApiModelProperty("uid")
	private String uid;

	@ApiModelProperty("学员Id")
	private String memberUid;

	@ApiModelProperty("学员姓名")
	private String trueName;

	@ApiModelProperty("手机号")
	private String cellPhone;

	@ApiModelProperty("报名时间")
	private String orderTime;

	@ApiModelProperty("报名城市")
	private String areaName;

	@ApiModelProperty("专业Id")
	private Integer departmentUid;

	@ApiModelProperty("学校名称")
	private String collegeName;

	@ApiModelProperty("专业名称")
	private String departmentName;

	@ApiModelProperty("级别名称")
	private String levelTypeName;

	@ApiModelProperty("导入时间")
	private Date createTime;

	@ApiModelProperty("学员分配状态")
	private Integer distributionState;

	@ApiModelProperty("分配时间")
	private Date updateTime;

	@ApiModelProperty("当前咨询师")
	private String consultName;

	@ApiModelProperty("班主任")
	private String teacherName;

	@ApiModelProperty("省份")
	private String provinceName;

	@ApiModelProperty("学员地址城市")
	private String cityName;

	@ApiModelProperty("区域")
	private String countyName;

	private String memberType;

	@ApiModelProperty("学员类型集合")
	private List<String> memberTypes;

	@ApiModelProperty("微信类型：0：未知，1：已添加 2：未添加")
	private Integer wxChart;

	@ApiModelProperty("机会类型：0：未知 1：续报:2：老带新 ")
	private Integer changeType;

	public void setOrderTime(String orderTime) {
		this.orderTime = DateUtil2.toString(orderTime, DateUtil2.FORMAT_DATE_TIME, DateUtil2.FORMAT_DATE);
	}
}
