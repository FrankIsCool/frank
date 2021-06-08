package com.sxmaps.mms.vo.resp;

import java.util.Date;

import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.utils.DateUtil2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "续报学员评价VO")
@Data
public class RespMemberEvaluateVO {
	
	@ApiModelProperty("主键")
	private Long uid;
	
	@ApiModelProperty("学员Id")
	private String memberUid;
	
	@ApiModelProperty("学员姓名")
	private String trueName;
	
	@ApiModelProperty("模糊手机号")
	private String hidePhone;
	
	private Date firstUpdateTime;

	@ApiModelProperty("学员电话")
	private String cellPhone;
	
	@ApiModelProperty("报名时间")
	private Date orderTime;
	
	@ApiModelProperty("报名城市")
	private String areaName;
	
	@ApiModelProperty("分配时间")
	private Date updateTime;
	
	@ApiModelProperty("学校名称")
	private String collegeName;
	
	@ApiModelProperty("专业名称")
	private String departmentName;
	
	@ApiModelProperty("级别名称")
	private String levelTypeName;
	
	@ApiModelProperty("班主任")
	private String teacherName;
	
	@ApiModelProperty("评价等级")
	private Double evaluateRank;
	
	@ApiModelProperty("是否超过7天")
	private Integer isTimeOut;

	@ApiModelProperty("微信类型：0：未知，1：已添加 2：未添加")
	private Integer wxChart;

	@ApiModelProperty("机会类型：0：未知 1：续报:2：老带新 ")
	private Integer changeType;

	public String getHidePhone() {
		
		String phone = cellPhone != null && cellPhone.length() > 8 ? cellPhone.substring(0, 3)+ "****"+cellPhone.substring(7) : cellPhone;
		return hidePhone = phone;
	}

	public String getCellPhone() {
		String phone = "";
		Integer date = DateUtil2.intervalDays(DateUtil2.toString(new Date(), DateUtil2.FORMAT_DATE), DateUtil2.toString(firstUpdateTime, DateUtil2.FORMAT_DATE));

		if (date >= OperationConstant.THIRTY) {
			phone = cellPhone != null && cellPhone.length() > 8 ? cellPhone.substring(0, 3)+ "****"+cellPhone.substring(7) : cellPhone;
		} else {
			phone = cellPhone;
		}
		
		return cellPhone = phone;
	}

	public void setCellPhone(String cellPhone) {
		
		this.cellPhone = cellPhone;
	}

	

	public Integer getIsTimeOut() {
		Integer timeOut = 1;
		Integer date = DateUtil2.intervalDays(DateUtil2.toString(new Date(), DateUtil2.FORMAT_DATE), DateUtil2.toString(firstUpdateTime, DateUtil2.FORMAT_DATE));
		
		if (date >= OperationConstant.SEVEN) {
			timeOut = 2;
		}
		
		return isTimeOut = timeOut;
	}

	public void setIsTimeOut(Integer isTimeOut) {
		this.isTimeOut = isTimeOut;
	}

	public String getOrderTime() {
        
    	return DateUtil2.toString(orderTime, DateUtil2.FORMAT_DATE);
    }
}
