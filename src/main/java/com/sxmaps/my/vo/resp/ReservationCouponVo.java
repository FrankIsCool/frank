package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author：liuyindong
 * @Date:2018/4/21 下午1:43
 * @Description:
 */
@ApiModel(value = "优惠券信息")
public class ReservationCouponVo {

	private Long uid;

	/**
	 * 预约单
	 */
	@ApiModelProperty(value = "预约单ID")
	private Long reservationUid;

	/**
	 * 优惠券UID
	 */
	@ApiModelProperty(value = "优惠券UID")
	private Integer couponUid;

	/**
	 * 优惠券名称
	 */
	@ApiModelProperty(value = "优惠券名称")
	private String couponName;

	/**
	 * 优惠金额
	 */
	@ApiModelProperty(value = "优惠金额")
	private BigDecimal couponPrice;

	@ApiModelProperty(name = "createDate", value = "创建时间", example = "2018-04-21 14:55:20")
	private LocalDateTime createDate;

	/**
	 * 流量ID
	 */
	@ApiModelProperty(value = "流量ID")
	private Long flowUid;

	/**
	 * 跟踪记录UID
	 */
	@ApiModelProperty(value = "访问记录UID")
	private Long trackLogUid;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人UID")
	private String operatorUid;

	@ApiModelProperty(value = "手机号")
	private String phone;

	/**
	 * 状态 0:正常 1:失效
	 */
	@ApiModelProperty(value = "状态（0：正常 1：失效）")
	private Integer state;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getReservationUid() {
		return reservationUid;
	}

	public void setReservationUid(Long reservationUid) {
		this.reservationUid = reservationUid;
	}

	public Integer getCouponUid() {
		return couponUid;
	}

	public void setCouponUid(Integer couponUid) {
		this.couponUid = couponUid;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Long getFlowUid() {
		return flowUid;
	}

	public void setFlowUid(Long flowUid) {
		this.flowUid = flowUid;
	}

	public Long getTrackLogUid() {
		return trackLogUid;
	}

	public void setTrackLogUid(Long trackLogUid) {
		this.trackLogUid = trackLogUid;
	}

	public String getOperatorUid() {
		return operatorUid;
	}

	public void setOperatorUid(String operatorUid) {
		this.operatorUid = operatorUid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ReservationCouponVo [uid=" + uid + ", reservationUid=" + reservationUid + ", couponUid=" + couponUid
				+ ", couponName=" + couponName + ", couponPrice=" + couponPrice + ", createDate=" + createDate
				+ ", flowUid=" + flowUid + ", trackLogUid=" + trackLogUid + ", operatorUid=" + operatorUid + ", phone="
				+ phone + ", state=" + state + "]";
	}

}
