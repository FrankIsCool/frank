package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "预约单分配管理返回VO")
public class RespTrackReservationVO implements Serializable {
	/**
	 * 学校名称
	 */
	@ApiModelProperty(name = "collegeName", value = "学校名称")
	private String collegeName;
	/**
	 * 咨询师
	 */
	@ApiModelProperty(name = "consultantOnline", value = "咨询师")
	private String consultantOnline;
	/**
	 * 优惠金额
	 */
	@ApiModelProperty(name = "couponPrice", value = "优惠金额")
	private String couponPrice;
	/**
	 * 优惠券UID
	 */
	@ApiModelProperty(name = "couponUid", value = "优惠券UID")
	private Integer couponUid;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createDate", value = "创建时间", example = "yyyy-MM-dd HH:mm:ss")
	private String createDate;
	/**
	 * 专业名称
	 */
	@ApiModelProperty(name = "deptName", value = "专业名称")
	private String deptName;
	/**
	 * 流量ID
	 */
	@ApiModelProperty(name = "flowUid", value = "流量ID")
	private Integer flowUid;
	/**
	 * 是否符合
	 */
	@ApiModelProperty(name = "isConform", value = "是否符合")
	private Integer isConform;

	/**
	 * 层级名称
	 */
	@ApiModelProperty(name = "levelName", value = "层级名称")
	private String levelName;

	/**
	 * 商品价格
	 */
	@ApiModelProperty(name = "martketPrice", value = "商品价格")
	private BigDecimal martketPrice;

	/**
	 * 创建人名称
	 */
	@ApiModelProperty(name = "operatorName", value = "创建人名称")
	private String operatorName;

	/**
	 * 创建人
	 */
	@ApiModelProperty(name = "operatorUid", value = "创建人")
	private String operatorUid;

	/**
	 * 其他优惠
	 */
	@ApiModelProperty(name = "otherPrice", value = "其他优惠")
	private String otherPrice;

	/**
	 * 电话
	 */
	@ApiModelProperty(name = "phone", value = "电话")
	private String phone;

	/**
	 * 商品图片
	 */
	@ApiModelProperty(name = "productImg", value = "商品图片")
	private String productImg;

	/**
	 * 商品名称
	 */
	@ApiModelProperty(name = "productName", value = "商品名称")
	private String productName;

	/**
	 * 推荐商品UID
	 */
	@ApiModelProperty(name = "recCommodityUid", value = "推荐商品UID")
	private Integer recCommodityUid;

	/**
	 * 预约时间
	 */
	@ApiModelProperty(name = "reservationDate", value = "预约时间", example = "yyyy-MM-dd HH:mm:ss")
	private String reservationDate;
	/**
	 * 分校名称
	 */
	@ApiModelProperty(name = "schoolName", value = "分校名称")
	private String schoolName;

	/**
	 * 预约分校
	 */
	@ApiModelProperty(name = "schoolUid", value = "预约分校")
	private Integer schoolUid;

	/**
	 * 性别
	 */
	@ApiModelProperty(name = "sex", value = "性别")
	private Integer sex;
	/**
	 * 0: 正常 1: 到访
	 */
	@ApiModelProperty(name = "state", value = "状态 0: 正常 1: 到访")
	private Integer state;

	/**
	 * 跟踪记录UID
	 */
	@ApiModelProperty(name = "trackLogUid", value = "跟踪记录UID")
	private Long trackLogUid;
	/**
	 * 预约ID
	 */
	@ApiModelProperty(name = "uid", value = " 预约ID")
	private Long uid;
	/**
	 * 学员姓名
	 */
	@ApiModelProperty(name = "userName", value = "学员姓名")
	private String userName;
	/**
	 * 到访时间
	 */
	@ApiModelProperty(name = "visitDate", value = "到访时间", example = "yyyy-MM-dd HH:mm:ss")
	private String visitDate;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getConsultantOnline() {
		return consultantOnline;
	}

	public void setConsultantOnline(String consultantOnline) {
		this.consultantOnline = consultantOnline;
	}

	public String getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Integer getCouponUid() {
		return couponUid;
	}

	public void setCouponUid(Integer couponUid) {
		this.couponUid = couponUid;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getFlowUid() {
		return flowUid;
	}

	public void setFlowUid(Integer flowUid) {
		this.flowUid = flowUid;
	}

	public Integer getIsConform() {
		return isConform;
	}

	public void setIsConform(Integer isConform) {
		this.isConform = isConform;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public BigDecimal getMartketPrice() {
		return martketPrice;
	}

	public void setMartketPrice(BigDecimal martketPrice) {
		this.martketPrice = martketPrice;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorUid() {
		return operatorUid;
	}

	public void setOperatorUid(String operatorUid) {
		this.operatorUid = operatorUid;
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

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getRecCommodityUid() {
		return recCommodityUid;
	}

	public void setRecCommodityUid(Integer recCommodityUid) {
		this.recCommodityUid = recCommodityUid;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getSchoolUid() {
		return schoolUid;
	}

	public void setSchoolUid(Integer schoolUid) {
		this.schoolUid = schoolUid;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		return "RespTrackReservationVO [collegeName=" + collegeName + ", consultantOnline=" + consultantOnline
				+ ", couponPrice=" + couponPrice + ", couponUid=" + couponUid + ", createDate=" + createDate
				+ ", deptName=" + deptName + ", flowUid=" + flowUid + ", isConform=" + isConform + ", levelName="
				+ levelName + ", martketPrice=" + martketPrice + ", operatorName=" + operatorName + ", operatorUid="
				+ operatorUid + ", otherPrice=" + otherPrice + ", phone=" + phone + ", productImg=" + productImg
				+ ", productName=" + productName + ", recCommodityUid=" + recCommodityUid + ", reservationDate="
				+ reservationDate + ", schoolName=" + schoolName + ", schoolUid=" + schoolUid + ", sex=" + sex
				+ ", state=" + state + ", trackLogUid=" + trackLogUid + ", uid=" + uid + ", userName=" + userName
				+ ", visitDate=" + visitDate + "]";
	}

}