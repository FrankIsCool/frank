package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(value = "查询预约商品信息vo")
public class RespReservationProdcutVO implements Serializable {
	/**
	 * 跟踪记录UID
	 */
	@ApiModelProperty(value = "跟踪记录UID", name = "uid", example = "1")
	private Long trackLogUid;
	/**
	 * 预约ID
	 */
	@ApiModelProperty(value = "预约ID", name = "uid", example = "1")
	private Long uid;

	/**
	 * 流量ID
	 */
	@ApiModelProperty(value = "流量ID")
	private Long flowUid;

	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别", name = "uid", example = "1")
	private Integer sex;

	/**
	 * 预约分校
	 */
	@ApiModelProperty(value = "预约分校", name = "uid", example = "1")
	private Integer schoolUid;

	/**
	 * 分校名称
	 */
	@ApiModelProperty(value = "分校名称", name = "uid", example = "1")
	private String schoolName;

	/**
	 * 其他优惠
	 */
	@ApiModelProperty(value = "其他优惠", name = "uid", example = "1")
	private String otherPrice;

	/**
	 * 电话
	 */
	@ApiModelProperty(value = "电话", name = "uid", example = "1")
	private String phone;

	/**
	 * 是否符合
	 */
	@ApiModelProperty(value = "是否符合", name = "uid", example = "1")
	private Integer isConform;

	@ApiModelProperty(value = "创建时间", name = "uid", example = "1")
	private LocalDateTime createDate;

	/**
	 * 0: 正常 1: 到访
	 */
	@ApiModelProperty(value = "0: 正常 1: 到访", name = "uid", example = "1")
	private Integer state;

	/**
	 * 预约时间
	 */
	@ApiModelProperty(value = "预约时间", name = "uid", example = "1")
	private LocalDateTime reservationDate;

	/**
	 * 到访时间
	 */
	@ApiModelProperty(value = "到访时间", name = "uid", example = "1")
	private LocalDateTime visitDate;

	/**
	 * 优惠券UID
	 */
	@ApiModelProperty(value = "优惠券UID", name = "uid", example = "1")
	private Integer couponUid;

	/**
	 * 优惠金额
	 */
	@ApiModelProperty(value = "优惠金额", name = "uid", example = "1")
	private BigDecimal couponPrice;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人", name = "uid", example = "1")
	private String operatorUid;

	/**
	 * 创建人名称
	 */
	@ApiModelProperty(value = "创建人名称", name = "uid", example = "1")
	private String operatorName;

	/**
	 * 学员姓名
	 */
	@ApiModelProperty(value = "学员姓名", name = "uid", example = "1")
	private String userName;

	/**
	 * 咨询师
	 */
	@ApiModelProperty(value = "咨询师", name = "uid", example = "1")
	private String consultantOnline;
	private List<RespReservationCommodityVO> reservationCommodityList;

	public List<RespReservationCommodityVO> getReservationCommodityList() {
		return reservationCommodityList;
	}

	public void setReservationCommodityList(List<RespReservationCommodityVO> reservationCommodityList) {
		this.reservationCommodityList = reservationCommodityList;
	}

	public Long getTrackLogUid() {
		return trackLogUid;
	}

	public void setTrackLogUid(Long trackLogUid) {
		this.trackLogUid = trackLogUid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getFlowUid() {
		return flowUid;
	}

	public void setFlowUid(Long flowUid) {
		this.flowUid = flowUid;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSchoolUid() {
		return schoolUid;
	}

	public void setSchoolUid(Integer schoolUid) {
		this.schoolUid = schoolUid;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getOtherPrice() {
		return otherPrice;
	}

	public void setOtherPrice(String otherPrice) {
		this.otherPrice = otherPrice;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsConform() {
		return isConform;
	}

	public void setIsConform(Integer isConform) {
		this.isConform = isConform;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalDateTime getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDateTime visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getCouponUid() {
		return couponUid;
	}

	public void setCouponUid(Integer couponUid) {
		this.couponUid = couponUid;
	}

	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	public String getOperatorUid() {
		return operatorUid;
	}

	public void setOperatorUid(String operatorUid) {
		this.operatorUid = operatorUid;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConsultantOnline() {
		return consultantOnline;
	}

	public void setConsultantOnline(String consultantOnline) {
		this.consultantOnline = consultantOnline;
	}

	@Override
	public String toString() {
		return "RespReservationProdcutVO{" + "trackLogUid=" + trackLogUid + ", uid=" + uid + ", flowUid=" + flowUid
				+ ", sex=" + sex + ", schoolUid=" + schoolUid + ", schoolName='" + schoolName + '\'' + ", otherPrice='"
				+ otherPrice + '\'' + ", phone='" + phone + '\'' + ", isConform=" + isConform + ", createDate="
				+ createDate + ", state=" + state + ", reservationDate=" + reservationDate + ", visitDate=" + visitDate
				+ ", couponUid=" + couponUid + ", couponPrice=" + couponPrice + ", operatorUid='" + operatorUid + '\''
				+ ", operatorName='" + operatorName + '\'' + ", userName='" + userName + '\'' + ", consultantOnline='"
				+ consultantOnline + '\'' + ", reservationCommodityList=" + reservationCommodityList + '}';
	}
}
