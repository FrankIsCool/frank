package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(value = "查询预约信息vo")
public class RespReservationVO implements Serializable {

	@ApiModelProperty(value = "反馈信息")
	private String remark;

	/**
	 * 跟踪记录UID
	 */
	@ApiModelProperty(value = "跟踪记录UID")
	private Long trackLogUid;
	/**
	 * 预约ID
	 */
	@ApiModelProperty(value = "预约ID")
	private Long uid;

	/**
	 * 流量ID
	 */
	@ApiModelProperty(value = "流量ID")
	private Long flowUid;

	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	private Integer sex;

	/**
	 * 预约分校
	 */
	@ApiModelProperty(value = "预约分校")
	private Integer schoolUid;

	/**
	 * 分校名称
	 */
	@ApiModelProperty(value = "分校名称")
	private String schoolName;

	/**
	 * 电话
	 */
	@ApiModelProperty(value = "电话")
	private String phone;

	/**
	 * 是否符合
	 */
	@ApiModelProperty(value = "是否符合")
	private Integer isConform;

	@ApiModelProperty(name = "createDate", value = "创建时间", example = "2018-04-21 14:55:20")
	private Date createDate;

	/**
	 * 0: 正常 1: 到访
	 */
	@ApiModelProperty(name = "state",value = "0:未预约 1:已预约 6:到访 7:学员 8:作废")
	private Integer state;

	/**
	 * 预约时间
	 */
	@ApiModelProperty(name = "reservationDate", value = "预约时间", example = "2018-04-21 14:55:20")
	private Date reservationDate;

	/**
	 * 到访时间
	 */
	@ApiModelProperty(name = "visitDate", value = "到访时间", example = "2018-04-21 14:55:20")
	private Date visitDate;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String operatorUid;

	/**
	 * 创建人名称
	 */
	@ApiModelProperty(value = "创建人名称")
	private String operatorName;

	/**
	 * 学员姓名
	 */
	@ApiModelProperty(value = "学员姓名")
	private String userName;

	/**
	 * 咨询师
	 */
	@ApiModelProperty(value = "流量师")
	private String consultantOnline;

	@ApiModelProperty(value = "咨询师UID")
	private String consultantUid;

	@ApiModelProperty(value = "预约单商品")
	private List<RespReservationCommodityVO> reservationCommodityList;

	@ApiModelProperty(value = "优惠券信息")
	private List<ReservationCouponVo> reservationCouponVos;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
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

	public String getConsultantUid() {
		return consultantUid;
	}

	public void setConsultantUid(String consultantUid) {
		this.consultantUid = consultantUid;
	}

	public List<RespReservationCommodityVO> getReservationCommodityList() {
		return reservationCommodityList;
	}

	public void setReservationCommodityList(List<RespReservationCommodityVO> reservationCommodityList) {
		this.reservationCommodityList = reservationCommodityList;
	}

	public List<ReservationCouponVo> getReservationCouponVos() {
		return reservationCouponVos;
	}

	public void setReservationCouponVos(List<ReservationCouponVo> reservationCouponVos) {
		this.reservationCouponVos = reservationCouponVos;
	}

	@Override
	public String toString() {
		return "RespReservationVO [remark=" + remark + ", trackLogUid=" + trackLogUid + ", uid=" + uid + ", flowUid="
				+ flowUid + ", sex=" + sex + ", schoolUid=" + schoolUid + ", schoolName=" + schoolName + ", phone="
				+ phone + ", isConform=" + isConform + ", createDate=" + createDate + ", state=" + state
				+ ", reservationDate=" + reservationDate + ", visitDate=" + visitDate + ", operatorUid=" + operatorUid
				+ ", operatorName=" + operatorName + ", userName=" + userName + ", consultantOnline=" + consultantOnline
				+ ", consultantUid=" + consultantUid + ", reservationCommodityList=" + reservationCommodityList
				+ ", reservationCouponVos=" + reservationCouponVos + "]";
	}

}