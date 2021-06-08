package com.sxmaps.mms.vo.resp;


import java.util.Date;

import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.utils.StringUtil;
import com.sxmaps.mms.utils.ValidatorUtil;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class RespExcelResubmitVO {
	
	@Excel(name = "序号",width = 25)
	private String uid;
	
	@Excel(name = "姓名",width = 25)
	private String trueName;
	
	@Excel(name = "联系方式",width = 25)
	private String cellPhone;
	
	@Excel(name = "省份",width = 25)
	private String provinceName;
	
	@Excel(name = "学员地址城市",width = 25)
	private String cityName;

	@Excel(name = "区域",width = 25)
	private String countyName;
	
	@Excel(name = "报名时间",width = 25)
	private String orderTime;
	
	@Excel(name = "报名城市",width = 25)
	private String areaName;
	
	@Excel(name = "学校",width = 25)
	private String collegeName;
	
	@Excel(name = "专业",width = 25)
	private String departmentName;
	
	@Excel(name = "级别",width = 25)
	private String levelTypeName;
	
	@Excel(name = "创建时间",width = 25)
	private String createTime;
	
	@Excel(name = "学员分配状态",width = 25)
	private String distributionState;
	
	@Excel(name = "分配时间",width = 25)
	private String updateTime;
	
	@Excel(name = "当前咨询师",width = 25)
	private String consultName;
	
	@Excel(name = "班主任",width = 25)
	private String teacherName;

	@Excel(name = "机会类型",width = 25)
	private String changeType;

	@Excel(name = "微信类型",width = 25)
	private String wxChart;

	public String getDistributionState() {
		return distributionState;
	}

	public void setDistributionState(Integer distributionState) {
		if(distributionState == OperationConstant.ONE) {
			this.distributionState = "未分配";
		} else if (distributionState == OperationConstant.TWO) {
			this.distributionState = "已分配";
		} else {
			this.distributionState = "未知状态";
		}
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = DateUtil2.toString(orderTime, DateUtil2.FORMAT_DATE);
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = DateUtil2.toString(createTime, DateUtil2.FORMAT_DATE_TIME);
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = DateUtil2.toString(updateTime, DateUtil2.FORMAT_DATE_TIME);
	}
}
