package com.sxmaps.mms.vo.req;

import com.sxmaps.mms.vo.QueryInfoVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReqQryOrdersMemberGiftListVO")
public class ReqQryOrdersMemberGiftListVO extends QueryInfoVO{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "学员电话")
	private String memberPhone;
	@ApiModelProperty(value = "学员名称")
	private String memberName;
	@ApiModelProperty(value = "收件人姓名")
	private String receiver;
	@ApiModelProperty(value = "收件人电话")
	private String phone;
	@ApiModelProperty(value = "创建开始时间")
	private String createStartTime;
	@ApiModelProperty(value = "创建结束时间")
	private String createEndTime;
	@ApiModelProperty(value = "录单开始时间")
	private String orderStartTime;
	@ApiModelProperty(value = "录单结束时间")
	private String orderEndTime;
	@ApiModelProperty(value = "订单状态")
	private Integer step;
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getCreateStartTime() {
		return createStartTime;
	}
	public void setCreateStartTime(String createStartTime) {
		this.createStartTime = createStartTime;
	}
	public String getCreateEndTime() {
		return createEndTime;
	}
	public void setCreateEndTime(String createEndTime) {
		this.createEndTime = createEndTime;
	}
	public String getOrderStartTime() {
		return orderStartTime;
	}
	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	public String getOrderEndTime() {
		return orderEndTime;
	}
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ReqQryOrdersMemberGiftListVO [memberPhone=" + memberPhone + ", memberName=" + memberName + ", receiver="
				+ receiver + ", phone=" + phone + ", createStartTime=" + createStartTime + ", createEndTime="
				+ createEndTime + ", orderStartTime=" + orderStartTime + ", orderEndTime=" + orderEndTime + ", step="
				+ step + "]";
	}
	
}
