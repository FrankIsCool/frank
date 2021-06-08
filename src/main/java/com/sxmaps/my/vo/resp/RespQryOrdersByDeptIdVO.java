package com.sxmaps.mms.vo.resp;

import com.sxmaps.mms.utils.ValidatorUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import com.sxmaps.mms.utils.ValidatorUtil;

@ApiModel("RespQryOrdersByDeptIdVO")
public class RespQryOrdersByDeptIdVO {
    @ApiModelProperty(value = "订单号")
    private String orderSn;
    @ApiModelProperty(value = "字订单号")
    private String orderItemSn;
    @ApiModelProperty(value = "学员名称")
    private String memberName;
    @ApiModelProperty(value = "学员电话")
    private String memberPhone;
    @ApiModelProperty(value = "实付金额")
    private BigDecimal paidAmount;
    @ApiModelProperty(value = "订单成交时间")
    private String orderTime;
    @ApiModelProperty(value = "班型名称")
    private String classType;
    @ApiModelProperty(value = "课程咨询师ID")
    private String userId;
    @ApiModelProperty(value = "课程咨询师名称")
    private String userName;
    @ApiModelProperty(value = "流量ID")
    private String flowId;
    @ApiModelProperty(value = "专业名称")
    private String departmentName;
    @ApiModelProperty(value = "级别名称")
    private String levelTypeName;
    @ApiModelProperty(value = "班型名称")
    private String classTypeName;
    @ApiModelProperty(value = "1.自营;2.老带新;3.其他")
    private Integer cate;
    @ApiModelProperty(value = "站点号", hidden = true)
    private String siteSn;
    @ApiModelProperty(value = "是否老带新 1否;2是", hidden = true)
    private String isTouch;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderItemSn() {
        return orderItemSn;
    }

    public void setOrderItemSn(String orderItemSn) {
        this.orderItemSn = orderItemSn;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLevelTypeName() {
        return levelTypeName;
    }

    public void setLevelTypeName(String levelTypeName) {
        this.levelTypeName = levelTypeName;
    }

    public String getClassTypeName() {
        return classTypeName;
    }

    public void setClassTypeName(String classTypeName) {
        this.classTypeName = classTypeName;
    }

    public Integer getCate() {
		return cate;
	}

	public void setCate(Integer cate) {
		this.cate = cate;
	}

	public String getSiteSn() {
		return siteSn;
	}

	public void setSiteSn(String siteSn) {
		this.siteSn = siteSn;
	}

	public String getIsTouch() {
		return ValidatorUtil.isEmpty(isTouch) ? "1" : isTouch;
	}

	public void setIsTouch(String isTouch) {
		this.isTouch = isTouch;
	}

	@Override
    public String toString() {
        return "RespQryOrdersByDeptIdVO{" +
                "orderSn='" + orderSn + '\'' +
                ", orderItemSn='" + orderItemSn + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", paidAmount=" + paidAmount +
                ", orderTime='" + orderTime + '\'' +
                ", classType='" + classType + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", flowId='" + flowId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", levelTypeName='" + levelTypeName + '\'' +
                ", classTypeName='" + classTypeName + '\'' +
                '}';
    }
}
