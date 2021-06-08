package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "协议管理返回VO")
public class RespProtocolVO implements Serializable {

	@ApiModelProperty(name = "proName", value = "协议名称", example = "成人本科协议", allowEmptyValue = false)
	private String proName;

	@ApiModelProperty(name = "content", value = "协议内容", example = "AAAAABBBBB", allowEmptyValue = false)
	private String content;

	@ApiModelProperty(name = "version", value = "协议版本号", example = "1.0", allowEmptyValue = false)
	private String version;

	@ApiModelProperty(name = "levelId", value = "层级ID", example = "202", allowEmptyValue = false)
	private String levelId;

	@ApiModelProperty(name = "levelName", value = "层级名称", example = "远程本科", allowEmptyValue = false)
	private String levelName;

	@ApiModelProperty(value = "附加协议", example = "1231")
	private String supplyProtocol;

	@ApiModelProperty(value = "手机号", example = "1231231231")
	private String cellphone;

	@ApiModelProperty(value = "邮箱", example = "协议补充")
	private String email;

	@ApiModelProperty(value = "身份证", example = "123123123123")
	private String idCard;

	@ApiModelProperty(value = "姓名", example = "123")
	private String trueName;

	@ApiModelProperty(value = "专业名称", example = "专业名称")
	private String departmentName;

	@ApiModelProperty(value = "班型名称", example = "班型名称")
	private String classTypeName;

	@ApiModelProperty(value = "院校名称", example = "院校名称")
	private String collegeName;

	@ApiModelProperty(value = "实付金额", example = "2222")
	private String costFee;

	@ApiModelProperty(value = "实付金额中文描述", example = "12312")
	private String costFeeUppercase;

	@ApiModelProperty(value = "级别类型名称", example = "dds")
	private String levelTypeName;

	@ApiModelProperty(value = "商品价格", example = "3333")
	private String paidAmount;

	@ApiModelProperty(value = "备注", example = "备注1111")
	private String remark;

	@ApiModelProperty(value = "协议id", example = "123")
	private String contractId;

	@ApiModelProperty(value = "签名url", example = "签名url")
	private String signUrl;

	@ApiModelProperty(value = "登录账号", example = "12312312")
	private String loginName;

	@ApiModelProperty(value = "登录密码", example = "1111")
	private String loginPwd;

	@ApiModelProperty(value = "签署时间", example = "1111")
	private String signTime;

	@ApiModelProperty(value = "金额备注")
	private String amountRemark;
	
	@ApiModelProperty(value = "显示印章:1.新印章,2.老印章")
	private Integer showStamp; 
	
	@ApiModelProperty(value = "显示签名和签名日期:1.显示,2.不显示")
	private Integer showSign;
	
	@ApiModelProperty(value = "显示MBA协议修改部分:1.显示,2.不显示")
	private String showMBAsupply;
	
	@ApiModelProperty(value = "显示院校:1.显示,2.不显示")
	private Integer showCollegeName;
	
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getSupplyProtocol() {
		return supplyProtocol;
	}

	public void setSupplyProtocol(String supplyProtocol) {
		this.supplyProtocol = supplyProtocol;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getClassTypeName() {
		return classTypeName;
	}

	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCostFee() {
		return costFee;
	}

	public void setCostFee(String costFee) {
		this.costFee = costFee;
	}

	public String getCostFeeUppercase() {
		return costFeeUppercase;
	}

	public void setCostFeeUppercase(String costFeeUppercase) {
		this.costFeeUppercase = costFeeUppercase;
	}

	public String getLevelTypeName() {
		return levelTypeName;
	}

	public void setLevelTypeName(String levelTypeName) {
		this.levelTypeName = levelTypeName;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getAmountRemark() {
		return amountRemark;
	}

	public void setAmountRemark(String amountRemark) {
		this.amountRemark = amountRemark;
	}

	public Integer getShowStamp() {
		return showStamp;
	}

	public void setShowStamp(Integer showStamp) {
		this.showStamp = showStamp;
	}

	public Integer getShowSign() {
		return showSign;
	}

	public void setShowSign(Integer showSign) {
		this.showSign = showSign;
	}

	public String getShowMBAsupply() {
		return showMBAsupply;
	}

	public void setShowMBAsupply(String showMBAsupply) {
		this.showMBAsupply = showMBAsupply;
	}

	@Override
	public String toString() {
		return "RespProtocolVO [proName=" + proName + ", content=" + content + ", version=" + version + ", levelId="
				+ levelId + ", levelName=" + levelName + ", supplyProtocol=" + supplyProtocol + ", cellphone="
				+ cellphone + ", email=" + email + ", idCard=" + idCard + ", trueName=" + trueName + ", departmentName="
				+ departmentName + ", classTypeName=" + classTypeName + ", collegeName=" + collegeName + ", costFee="
				+ costFee + ", costFeeUppercase=" + costFeeUppercase + ", levelTypeName=" + levelTypeName
				+ ", paidAmount=" + paidAmount + ", remark=" + remark + ", contractId=" + contractId + ", signUrl="
				+ signUrl + ", loginName=" + loginName + ", loginPwd=" + loginPwd + ", signTime=" + signTime
				+ ", amountRemark=" + amountRemark + ", showStamp=" + showStamp + ", showSign=" + showSign
				+ ", showMBAsupply=" + showMBAsupply + "]";
	}

}