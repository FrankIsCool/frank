package com.sxmaps.mms.vo.resp;

import java.time.LocalDateTime;

import com.google.common.base.MoreObjects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Description: 评价咨询回访信息
 * @author tanglei
 * @date 2018年3月29日
 */
@ApiModel(value = "评价咨询回访信息")
public class TrackAndLogVO {

	/**
	 * uid
	 */
	@ApiModelProperty(value = "uid")
	private Long uid;

	/**
	 * 下次预约时间
	 */
	@ApiModelProperty(value = "下次回访时间")
	private LocalDateTime nextVisitDate;

	/**
	 * 反馈
	 */
	@ApiModelProperty(value = "反馈")
	private String remark;

	/**
	 * 0：不预约 1:预约
	 */
	@ApiModelProperty(value = "预约状态(0：不预约 1:预约)")
	private Integer isreservation;

	/**
	 * 咨询顾问
	 */
	@ApiModelProperty(value = "咨询顾问")
	private String consultantUid;

	/**
	 * 分配UID
	 */
	@ApiModelProperty(value = "分配UID")
	private Long flowAllotdUid;

	/**
	 * 流量UID
	 */
	@ApiModelProperty(value = "流量UID")
	private Long flowUid;

	/**
	 * 流量UID
	 */
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createDate;

	/**
	 * 0:有效。1:无效
	 */
	@ApiModelProperty(value = "0:有效。1:无效")
	private Integer iseffective;

	/**
	 * 无效类型
	 */
	@ApiModelProperty(value = "无效类型")
	private Integer invalidType;

	/**
	 * 无效备注
	 */
	@ApiModelProperty(value = "无效备注")
	private String invalidRemark;

	/**
	 * 预约记录
	 */
	@ApiModelProperty(value = "预约记录")
	private RespReservationProdcutVO reservation;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public LocalDateTime getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(LocalDateTime nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsreservation() {
		return isreservation;
	}

	public void setIsreservation(Integer isreservation) {
		this.isreservation = isreservation;
	}

	public String getConsultantUid() {
		return consultantUid;
	}

	public void setConsultantUid(String consultantUid) {
		this.consultantUid = consultantUid;
	}

	public Long getFlowAllotdUid() {
		return flowAllotdUid;
	}

	public void setFlowAllotdUid(Long flowAllotdUid) {
		this.flowAllotdUid = flowAllotdUid;
	}

	public Long getFlowUid() {
		return flowUid;
	}

	public void setFlowUid(Long flowUid) {
		this.flowUid = flowUid;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getIseffective() {
		return iseffective;
	}

	public void setIseffective(Integer iseffective) {
		this.iseffective = iseffective;
	}

	public Integer getInvalidType() {
		return invalidType;
	}

	public void setInvalidType(Integer invalidType) {
		this.invalidType = invalidType;
	}

	public String getInvalidRemark() {
		return invalidRemark;
	}

	public void setInvalidRemark(String invalidRemark) {
		this.invalidRemark = invalidRemark;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("uid", uid).add("nextVisitDate", nextVisitDate)
				.add("remark", remark).add("isreservation", isreservation).add("consultantUid", consultantUid)
				.add("flowAllotdUid", flowAllotdUid).add("flowUid", flowUid).add("createDate", createDate)
				.add("iseffective", iseffective).add("invalidType", invalidType).add("invalidRemark", invalidRemark)
				.add("reservation", reservation).toString();
	}

	public RespReservationProdcutVO getReservation() {
		return reservation;
	}

	public void setReservation(RespReservationProdcutVO reservation) {
		this.reservation = reservation;
	}
}
