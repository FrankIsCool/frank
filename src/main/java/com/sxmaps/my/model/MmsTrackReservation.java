package com.sxmaps.mms.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mms_track_reservation")
public class MmsTrackReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;

	/**
	 * 跟踪记录UID
	 */
	@Column(name = "track_log_uid")
	private Long trackLogUid;

	/**
	 * 流量ID
	 */
	@Column(name = "flow_uid")
	private Long flowUid;

	/**
	 * 性别
	 */
	private Byte sex;

	/**
	 * 预约分校
	 */
	@Column(name = "school_uid")
	private Integer schoolUid;

	/**
	 * 分校名称
	 */
	@Column(name = "school_name")
	private String schoolName;

	/**
	 * 优惠金额
	 */
	@Column(name = "coupon_price")
	private BigDecimal couponPrice;

	/**
	 * 优惠券UID
	 */
	@Column(name = "coupon_uid")
	private Long couponUid;

	/**
	 * 其他优惠
	 */
	@Column(name = "other_price")
	private String otherPrice;

	private String phone;

	@Column(name = "is_conform")
	private Byte isConform;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

	private Byte state;

	/**
	 * 预约时间
	 */
	@Column(name = "reservation_date")
	private Date reservationDate;

	/**
	 * 推荐项目
	 */
	@Column(name = "rec_item_uid")
	private Integer recItemUid;

	/**
	 * 推荐项名称
	 */
	@Column(name = "rec_item_name")
	private String recItemName;

	/**
	 * 推荐级别ID
	 */
	@Column(name = "rec_level_uid")
	private Integer recLevelUid;

	/**
	 * 推荐级别名称
	 */
	@Column(name = "rec_level_name")
	private String recLevelName;

	/**
	 * 推荐学校
	 */
	@Column(name = "rec_school_uid")
	private Integer recSchoolUid;

	/**
	 * 推荐学校名称
	 */
	@Column(name = "rec_school_name")
	private String recSchoolName;

	/**
	 * 推荐专业
	 */
	@Column(name = "rec_profession_uid")
	private Integer recProfessionUid;

	/**
	 * 推荐专业名称
	 */
	@Column(name = "rec_profession_name")
	private String recProfessionName;

	/**
	 * 推荐商品UID
	 */
	@Column(name = "rec_commodity_uid")
	private Integer recCommodityUid;

	/**
	 * 推荐商品名称
	 */
	@Column(name = "rec_commodity_name")
	private String recCommodityName;

	/**
	 * 推荐班级UID
	 */
	@Column(name = "rec_class_uid")
	private Integer recClassUid;

	/**
	 * 推荐班级
	 */
	@Column(name = "rec_class_name")
	private String recClassName;

	/**
	 * @return uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param uid
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * 获取跟踪记录UID
	 *
	 * @return track_log_uid - 跟踪记录UID
	 */
	public Long getTrackLogUid() {
		return trackLogUid;
	}

	/**
	 * 设置跟踪记录UID
	 *
	 * @param trackLogUid
	 *            跟踪记录UID
	 */
	public void setTrackLogUid(Long trackLogUid) {
		this.trackLogUid = trackLogUid;
	}

	/**
	 * 获取流量ID
	 *
	 * @return flow_uid - 流量ID
	 */
	public Long getFlowUid() {
		return flowUid;
	}

	/**
	 * 设置流量ID
	 *
	 * @param flowUid
	 *            流量ID
	 */
	public void setFlowUid(Long flowUid) {
		this.flowUid = flowUid;
	}

	/**
	 * 获取性别
	 *
	 * @return sex - 性别
	 */
	public Byte getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 *
	 * @param sex
	 *            性别
	 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

	/**
	 * 获取预约分校
	 *
	 * @return school_uid - 预约分校
	 */
	public Integer getSchoolUid() {
		return schoolUid;
	}

	/**
	 * 设置预约分校
	 *
	 * @param schoolUid
	 *            预约分校
	 */
	public void setSchoolUid(Integer schoolUid) {
		this.schoolUid = schoolUid;
	}

	/**
	 * 获取分校名称
	 *
	 * @return school_name - 分校名称
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * 设置分校名称
	 *
	 * @param schoolName
	 *            分校名称
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName == null ? null : schoolName.trim();
	}

	/**
	 * 获取优惠金额
	 *
	 * @return coupon_price - 优惠金额
	 */
	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	/**
	 * 设置优惠金额
	 *
	 * @param couponPrice
	 *            优惠金额
	 */
	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	/**
	 * 获取优惠券UID
	 *
	 * @return coupon_uid - 优惠券UID
	 */
	public Long getCouponUid() {
		return couponUid;
	}

	/**
	 * 设置优惠券UID
	 *
	 * @param couponUid
	 *            优惠券UID
	 */
	public void setCouponUid(Long couponUid) {
		this.couponUid = couponUid;
	}

	/**
	 * 获取其他优惠
	 *
	 * @return other_price - 其他优惠
	 */
	public String getOtherPrice() {
		return otherPrice;
	}

	/**
	 * 设置其他优惠
	 *
	 * @param otherPrice
	 *            其他优惠
	 */
	public void setOtherPrice(String otherPrice) {
		this.otherPrice = otherPrice == null ? null : otherPrice.trim();
	}

	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * @return is_conform
	 */
	public Byte getIsConform() {
		return isConform;
	}

	/**
	 * @param isConform
	 */
	public void setIsConform(Byte isConform) {
		this.isConform = isConform;
	}

	/**
	 * @return create_date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return update_date
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return state
	 */
	public Byte getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(Byte state) {
		this.state = state;
	}

	/**
	 * 获取预约时间
	 *
	 * @return reservation_date - 预约时间
	 */
	public Date getReservationDate() {
		return reservationDate;
	}

	/**
	 * 设置预约时间
	 *
	 * @param reservationDate
	 *            预约时间
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * 获取推荐项目
	 *
	 * @return rec_item_uid - 推荐项目
	 */
	public Integer getRecItemUid() {
		return recItemUid;
	}

	/**
	 * 设置推荐项目
	 *
	 * @param recItemUid
	 *            推荐项目
	 */
	public void setRecItemUid(Integer recItemUid) {
		this.recItemUid = recItemUid;
	}

	/**
	 * 获取推荐项名称
	 *
	 * @return rec_item_name - 推荐项名称
	 */
	public String getRecItemName() {
		return recItemName;
	}

	/**
	 * 设置推荐项名称
	 *
	 * @param recItemName
	 *            推荐项名称
	 */
	public void setRecItemName(String recItemName) {
		this.recItemName = recItemName == null ? null : recItemName.trim();
	}

	/**
	 * 获取推荐级别ID
	 *
	 * @return rec_level_uid - 推荐级别ID
	 */
	public Integer getRecLevelUid() {
		return recLevelUid;
	}

	/**
	 * 设置推荐级别ID
	 *
	 * @param recLevelUid
	 *            推荐级别ID
	 */
	public void setRecLevelUid(Integer recLevelUid) {
		this.recLevelUid = recLevelUid;
	}

	/**
	 * 获取推荐级别名称
	 *
	 * @return rec_level_name - 推荐级别名称
	 */
	public String getRecLevelName() {
		return recLevelName;
	}

	/**
	 * 设置推荐级别名称
	 *
	 * @param recLevelName
	 *            推荐级别名称
	 */
	public void setRecLevelName(String recLevelName) {
		this.recLevelName = recLevelName == null ? null : recLevelName.trim();
	}

	/**
	 * 获取推荐学校
	 *
	 * @return rec_school_uid - 推荐学校
	 */
	public Integer getRecSchoolUid() {
		return recSchoolUid;
	}

	/**
	 * 设置推荐学校
	 *
	 * @param recSchoolUid
	 *            推荐学校
	 */
	public void setRecSchoolUid(Integer recSchoolUid) {
		this.recSchoolUid = recSchoolUid;
	}

	/**
	 * 获取推荐学校名称
	 *
	 * @return rec_school_name - 推荐学校名称
	 */
	public String getRecSchoolName() {
		return recSchoolName;
	}

	/**
	 * 设置推荐学校名称
	 *
	 * @param recSchoolName
	 *            推荐学校名称
	 */
	public void setRecSchoolName(String recSchoolName) {
		this.recSchoolName = recSchoolName == null ? null : recSchoolName.trim();
	}

	/**
	 * 获取推荐专业
	 *
	 * @return rec_profession_uid - 推荐专业
	 */
	public Integer getRecProfessionUid() {
		return recProfessionUid;
	}

	/**
	 * 设置推荐专业
	 *
	 * @param recProfessionUid
	 *            推荐专业
	 */
	public void setRecProfessionUid(Integer recProfessionUid) {
		this.recProfessionUid = recProfessionUid;
	}

	/**
	 * 获取推荐专业名称
	 *
	 * @return rec_profession_name - 推荐专业名称
	 */
	public String getRecProfessionName() {
		return recProfessionName;
	}

	/**
	 * 设置推荐专业名称
	 *
	 * @param recProfessionName
	 *            推荐专业名称
	 */
	public void setRecProfessionName(String recProfessionName) {
		this.recProfessionName = recProfessionName == null ? null : recProfessionName.trim();
	}

	/**
	 * 获取推荐商品UID
	 *
	 * @return rec_commodity_uid - 推荐商品UID
	 */
	public Integer getRecCommodityUid() {
		return recCommodityUid;
	}

	/**
	 * 设置推荐商品UID
	 *
	 * @param recCommodityUid
	 *            推荐商品UID
	 */
	public void setRecCommodityUid(Integer recCommodityUid) {
		this.recCommodityUid = recCommodityUid;
	}

	/**
	 * 获取推荐商品名称
	 *
	 * @return rec_commodity_name - 推荐商品名称
	 */
	public String getRecCommodityName() {
		return recCommodityName;
	}

	/**
	 * 设置推荐商品名称
	 *
	 * @param recCommodityName
	 *            推荐商品名称
	 */
	public void setRecCommodityName(String recCommodityName) {
		this.recCommodityName = recCommodityName == null ? null : recCommodityName.trim();
	}

	/**
	 * 获取推荐班级UID
	 *
	 * @return rec_class_uid - 推荐班级UID
	 */
	public Integer getRecClassUid() {
		return recClassUid;
	}

	/**
	 * 设置推荐班级UID
	 *
	 * @param recClassUid
	 *            推荐班级UID
	 */
	public void setRecClassUid(Integer recClassUid) {
		this.recClassUid = recClassUid;
	}

	/**
	 * 获取推荐班级
	 *
	 * @return rec_class_name - 推荐班级
	 */
	public String getRecClassName() {
		return recClassName;
	}

	/**
	 * 设置推荐班级
	 *
	 * @param recClassName
	 *            推荐班级
	 */
	public void setRecClassName(String recClassName) {
		this.recClassName = recClassName == null ? null : recClassName.trim();
	}
}