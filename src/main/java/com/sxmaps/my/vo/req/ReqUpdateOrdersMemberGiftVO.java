package com.sxmaps.mms.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReqUpdateOrdersMemberGiftVO")
public class ReqUpdateOrdersMemberGiftVO {
	@ApiModelProperty(value = "记录UID")
	private Long uid;
	@ApiModelProperty(value = "收件人名称")
	private String receiver;
	@ApiModelProperty(value = "收件人电话")
	private String phone;
	@ApiModelProperty(value = "收件人邮箱")
	private String email;
	@ApiModelProperty(value = "省编号")
	private String provinceCode;
	@ApiModelProperty(value = "省名称")
	private String provinceName;
	@ApiModelProperty(value = "市编号")
	private String cityCode;
	@ApiModelProperty(value = "市名称")
	private String cityName;
	@ApiModelProperty(value = "区名称")
	private String countyCode;
	@ApiModelProperty(value = "区编号")
	private String countyName;
	@ApiModelProperty(value = "街道")
	private String street;
	@ApiModelProperty(value = "地址")
	private String address;
	@ApiModelProperty(value = "是否赠送 1赠送;0未赠送")
	private Integer isDeal;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "ReqUpdateOrdersMemberGiftVO [uid=" + uid + ", receiver=" + receiver + ", phone=" + phone + ", email="
				+ email + ", provinceCode=" + provinceCode + ", provinceName=" + provinceName + ", cityCode=" + cityCode
				+ ", cityName=" + cityName + ", countyCode=" + countyCode + ", countyName=" + countyName + ", street="
				+ street + ", address=" + address + ", isDeal=" + isDeal + "]";
	}

}
