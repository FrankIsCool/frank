package com.sxmaps.mms.vo;

import java.io.Serializable;
import java.util.List;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

@SuppressWarnings("serial")
public class ExportOrderOnlineVO implements Serializable {

	@Excel(name = "子订单编号", width = 25, orderNum = "0")
	private String orderSn;

	@Excel(name = "订单运营类别", width = 25, orderNum = "1")
	private String orderCate;

	@Excel(name = "订单类型", width = 25, orderNum = "2")
	private String orderType;

	@Excel(name = "录单时间", width = 25, orderNum = "3")
	private String createTime;

	@Excel(name = "录单人", width = 25, orderNum = "4")
	private String deal;

	@Excel(name = "审核人", width = 25, orderNum = "5")
	private String audit;

	@Excel(name = "支付时间", width = 25, orderNum = "6")
	private String payTime;

	@Excel(name = "审核时间", width = 25, orderNum = "7")
	private String auditTime;

	@Excel(name = "姓名", width = 25, orderNum = "8")
	private String memberName;

	@Excel(name = "手机号", width = 25, orderNum = "9")
	private String memberPhone;

	@Excel(name = "站点号", width = 25, orderNum = "10")
	private String siteSn;

	@Excel(name = "身份证", width = 30, orderNum = "11")
	private String memberIdCard;

	@Excel(name = "报名城市", width = 25, orderNum = "12")
	private String areaName;

	@Excel(name = "录单来源", width = 25, orderNum = "13")
	private String cateDesc;

	@Excel(name = "订单状态", width = 25, orderNum = "14")
	private String orderState;

	@Excel(name = "服务状态", width = 25, orderNum = "15")
	private String serviceState;

	// @Excel(name = "咨询组", width = 25, orderNum = "12")
	// private String sellerGroupName;

	@Excel(name = "课程咨询师", width = 25, orderNum = "16")
	private String sellerName;

	@Excel(name = "四级", width = 60, orderNum = "17")
	private String lDept;

	@Excel(name = "三级", width = 60, orderNum = "18")
	private String tDept;

	@Excel(name = "二级", width = 60, orderNum = "19")
	private String sDept;

	@Excel(name = "一级", width = 60, orderNum = "20")
	private String fDept;

	@Excel(name = "机构", width = 60, orderNum = "21")
	private String dept;

	@Excel(name = "报名分校", width = 25, orderNum = "22")
	private String stationName;

	@Excel(name = "现场咨询师", width = 25, orderNum = "23")
	private String stationTeacherName;

	@Excel(name = "班主任", width = 25, orderNum = "24")
	private String teacherName;

	@Excel(name = "级别", width = 20, orderNum = "25")
	private String levelTypeName;

	@Excel(name = "学校", width = 25, orderNum = "26")
	private String collegeName;

	@Excel(name = "专业", width = 30, orderNum = "27")
	private String departmentName;

	@Excel(name = "班型", width = 25, orderNum = "28")
	private String classTypeName;

	@Excel(name = "商品价格", width = 20, orderNum = "29")
	private String productPrice;

	@Excel(name = "优惠金额", width = 20, orderNum = "30")
	private String couponAmount;

	@Excel(name = "商品实缴金额", width = 20, orderNum = "31")
	private String paidAmount;

	@Excel(name = "订单交易金额", width = 20, orderNum = "32")
	private String orderAmount;

	@Excel(name = "定金流水号", width = 30, orderNum = "33")
	private String hanselSn;

	@Excel(name = "定金支付方式", width = 20, orderNum = "33")
	private String hanselWay;

	@Excel(name = "定金缴费时间", width = 20, orderNum = "33")
	private String hanselPayTime;

	@Excel(name = "定金金额", width = 20, orderNum = "33")
	private String hanselAmount;

	@ExcelEntity(id = "totalRemark")
	@Excel(name = "订单支付流水汇总", width = 150, orderNum = "34", isWrap = true, needMerge = true, mergeRely = { 45, 46, 47,
			48, 49 })
	@ExcelCollection(type = String.class, name = "支付流水汇总", orderNum = "45", id = "totalRemark")
	private List<String> totalRemark;

	@Excel(name = "代收费用类型", width = 25, orderNum = "35")
	private String feesDesc;

	@Excel(name = "代收费用支付方式", width = 20, orderNum = "36")
	private String feesWay;

	@Excel(name = "代收费用金额", width = 20, orderNum = "37")
	private String feesPay;

	@Excel(name = "代收费用", width = 100, orderNum = "38", isWrap = true)
	private String fees;

	@Excel(name = "订单备注", width = 100, orderNum = "39", isWrap = true)
	private String remark;
	
	@Excel(name = "收件人", width = 20, orderNum = "40")
	private String receiver;

	@Excel(name = "手机号", width = 20, orderNum = "41")
	private String phone;

	@Excel(name = "地址", width = 20, orderNum = "42")
	private String address;

	@Excel(name = "邮箱", width = 20, orderNum = "43")
	private String email;

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public String getOrderCate() {
		return orderCate;
	}

	public void setOrderCate(String orderCate) {
		this.orderCate = orderCate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
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

	public String getSiteSn() {
		return siteSn;
	}

	public void setSiteSn(String siteSn) {
		this.siteSn = siteSn;
	}

	public String getMemberIdCard() {
		return memberIdCard;
	}

	public void setMemberIdCard(String memberIdCard) {
		this.memberIdCard = memberIdCard;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCateDesc() {
		return cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getServiceState() {
		return serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getlDept() {
		return lDept;
	}

	public void setlDept(String lDept) {
		this.lDept = lDept;
	}

	public String gettDept() {
		return tDept;
	}

	public void settDept(String tDept) {
		this.tDept = tDept;
	}

	public String getsDept() {
		return sDept;
	}

	public void setsDept(String sDept) {
		this.sDept = sDept;
	}

	public String getfDept() {
		return fDept;
	}

	public void setfDept(String fDept) {
		this.fDept = fDept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationTeacherName() {
		return stationTeacherName;
	}

	public void setStationTeacherName(String stationTeacherName) {
		this.stationTeacherName = stationTeacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getLevelTypeName() {
		return levelTypeName;
	}

	public void setLevelTypeName(String levelTypeName) {
		this.levelTypeName = levelTypeName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(String couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public List<String> getTotalRemark() {
		return totalRemark;
	}

	public void setTotalRemark(List<String> totalRemark) {
		this.totalRemark = totalRemark;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHanselAmount() {
		return hanselAmount;
	}

	public void setHanselAmount(String hanselAmount) {
		this.hanselAmount = hanselAmount;
	}

	public String getHanselSn() {
		return hanselSn;
	}

	public void setHanselSn(String hanselSn) {
		this.hanselSn = hanselSn;
	}

	public String getHanselWay() {
		return hanselWay;
	}

	public void setHanselWay(String hanselWay) {
		this.hanselWay = hanselWay;
	}

	public String getHanselPayTime() {
		return hanselPayTime;
	}

	public void setHanselPayTime(String hanselPayTime) {
		this.hanselPayTime = hanselPayTime;
	}

	public String getFeesDesc() {
		return feesDesc;
	}

	public void setFeesDesc(String feesDesc) {
		this.feesDesc = feesDesc;
	}

	public String getFeesWay() {
		return feesWay;
	}

	public void setFeesWay(String feesWay) {
		this.feesWay = feesWay;
	}

	public String getFeesPay() {
		return feesPay;
	}

	public void setFeesPay(String feesPay) {
		this.feesPay = feesPay;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
