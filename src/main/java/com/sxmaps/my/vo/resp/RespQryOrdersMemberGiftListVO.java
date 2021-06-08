package com.sxmaps.mms.vo.resp;

import io.swagger.annotations.ApiModelProperty;

public class RespQryOrdersMemberGiftListVO {
	@ApiModelProperty(value = "编号")
	private Long uid;
	@ApiModelProperty(value = "学员名称")
	private String memberName;
	@ApiModelProperty(value = "学员电话")
	private String memberPhone;
	@ApiModelProperty(value = "订单号")
	private String orderSn;
	@ApiModelProperty(value = "报名时间")
	private String orderTime;
	@ApiModelProperty(value = "省编号")
	private String provinceCode;
	@ApiModelProperty(value = "省名称")
	private String provinceName;
	@ApiModelProperty(value = "城市编号")
	private String cityCode;
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	@ApiModelProperty(value = "区编号")
	private String countyCode;
	@ApiModelProperty(value = "区名称")
	private String countyName;
	@ApiModelProperty(value = "街道")
	private String street;
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	@ApiModelProperty(value = "收件人")
	private String receiver;
	@ApiModelProperty(value = "联系电话")
	private String phone;
	@ApiModelProperty(value = "邮箱")
	private String email;
	@ApiModelProperty(value = "地址")
	private String address;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
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
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "RespQryOrdersMemberGiftListVO [uid=" + uid + ", memberName=" + memberName + ", memberPhone="
				+ memberPhone + ", orderSn=" + orderSn + ", orderTime=" + orderTime + ", provinceCode=" + provinceCode
				+ ", provinceName=" + provinceName + ", cityCode=" + cityCode + ", cityName=" + cityName + ", countyCode="
				+ countyCode + ", countyName=" + countyName + ", street=" + street + ", createTime=" + createTime
				+ ", receiver=" + receiver + ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
	
}
