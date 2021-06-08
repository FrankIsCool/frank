package com.sxmaps.mms.vo.resp;

import java.math.BigDecimal;

import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "商品详情信息")
public class RespReservationCommodityVO {
	@Id
	@ApiModelProperty(value = "uid")
	private Long uid;

	/**
	 * 推荐商品UID
	 */
	@ApiModelProperty(value = "推荐商品UID")
	private Integer recCommodityUid;

	/**
	 * 推荐班级UID
	 */
	@ApiModelProperty(value = "推荐班级UID")
	private Integer recClassUid;

	/**
	 * 预约ID
	 */
	@ApiModelProperty(value = "预约ID")
	private Long reservationUid;

	/**
	 * 流量ID
	 */
	@ApiModelProperty(value = "流量ID")
	private Long flowUid;

	@ApiModelProperty(value = "商品名称", name = "productName", example = "我的商品")
	private String productName;

	@ApiModelProperty(value = "商品学员价格", name = "stuPrice", example = "100")
	private BigDecimal stuPrice;

	@ApiModelProperty(value = "商品价格", name = "martketPrice", example = "100")
	private BigDecimal martketPrice;

	@ApiModelProperty(value = "层级名称", name = "levelName", example = "专科")
	private String levelName;

	@ApiModelProperty(value = "学校名称", name = "collegeName", example = "南昌大学")
	private String collegeName;

	@ApiModelProperty(value = "专业名称", name = "deptName", example = "计算机应用")
	private String deptName;

	@ApiModelProperty(value = "商品图片")
	private String productImg;

	@ApiModelProperty(value = "班型名称")
	public String classTypeName;

	public String getClassTypeName() {
		return classTypeName;
	}

	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}

	public BigDecimal getStuPrice() {
		return stuPrice;
	}

	public void setStuPrice(BigDecimal stuPrice) {
		this.stuPrice = stuPrice;
	}

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
	 * @return reservation_uid
	 */
	public Long getReservationUid() {
		return reservationUid;
	}

	/**
	 * @param reservationUid
	 */
	public void setReservationUid(Long reservationUid) {
		this.reservationUid = reservationUid;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getMartketPrice() {
		return martketPrice;
	}

	public void setMartketPrice(BigDecimal martketPrice) {
		this.martketPrice = martketPrice;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "RespReservationCommodityVO{" + "uid=" + uid + ", recCommodityUid=" + recCommodityUid + ", recClassUid="
				+ recClassUid + ", reservationUid=" + reservationUid + ", flowUid=" + flowUid + ", productName='"
				+ productName + '\'' + ", martketPrice=" + martketPrice + ", levelName='" + levelName + '\''
				+ ", collegeName='" + collegeName + '\'' + ", deptName='" + deptName + '\'' + ", productImg='"
				+ productImg + '\'' + '}';
	}
}