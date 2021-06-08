package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "分校管理VO")
public class RespCampusVO implements Serializable {

	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "分校ID", example = "1")
	private Long uid;

	/**
	 * 所属部门编码
	 */
	@NotBlank(message = "所属部门编码不可为空")
	@ApiModelProperty(name = "deptCode", value = "所属部门编码")
	private String deptCode;

	/**
	 * 所属部门名称
	 */
	@NotBlank(message = "所属部门名称不可为空")
	@ApiModelProperty(name = "deptName", value = "所属部门名称")
	private String deptName;

	/**
	 * 分校编号
	 */
	@ApiModelProperty(name = "campusCode", value = "分校编号", example = "1122")
	private String campusCode;

	/**
	 * 分校名称
	 */
	@ApiModelProperty(name = "campusName", value = "分校名称", example = "车公庙分校")
	private String campusName;

	/**
	 * 联系电话
	 */
	@ApiModelProperty(name = "phone", value = "联系电话", example = "13465985623")
	private String phone;

	/**
	 * 分校图片
	 */
	@ApiModelProperty(name = "photo", value = "分校图片", example = "123.jpg")
	private String photo;

	/**
	 * 省份编号
	 */
	@ApiModelProperty(name = "provinceCode", value = "省份编号", example = "440000")
	private String provinceCode;

	/**
	 * 省份名称
	 */
	@ApiModelProperty(name = "provinceName", value = "省份名称", example = "广东省")
	private String provinceName;

	/**
	 * 城市编号
	 */
	@ApiModelProperty(name = "cityCode", value = "城市编号", example = "440300")
	private String cityCode;

	/**
	 * 城市名称
	 */
	@ApiModelProperty(name = "cityName", value = "城市名称", example = "深圳市")
	private String cityName;

	/**
	 * 区编号
	 */
	@ApiModelProperty(name = "countyCode", value = "区编号", example = "440307")
	private String countyCode;

	/**
	 * 区名称
	 */
	@ApiModelProperty(name = "countyName", value = "区名称", example = "龙岗区")
	private String countyName;

	/**
	 * 街道
	 */
	@ApiModelProperty(name = "street", value = "街道", example = "坂田街道1122")
	private String street;

	/**
	 * 全地址
	 */
	@ApiModelProperty(name = "address", value = "详细地址", example = "广东省深圳市龙岗区坂田街道1122")
	private String address;

	/**
	 * X,Y坐标
	 */
	@ApiModelProperty(name = "coordinate", value = "X,Y坐标", example = "15,16")
	private String coordinate;

	/**
	 * 操作人uid
	 */
	@ApiModelProperty(name = "operatorUid", value = "操作人uid", example = "123456")
	private String operatorUid;

	/**
	 * 操作人名称
	 */
	@ApiModelProperty(name = "operatorName", value = "操作人名称", example = "李小二")
	private String operatorName;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2018-04-08 14:55:20")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(name = "updateTime", value = "修改时间", example = "2018-04-08 14:55:20")
	private Date updateTime;

	/**
	 * 状态 1有效,0删除
	 */
	@ApiModelProperty(name = "state", value = "状态 1有效,0删除", example = "1")
	private String state;

	/**
	 * 部门信息
	 */
	@ApiModelProperty(name = "deptItem", value = "部门信息")
	private String deptItem;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCampusCode() {
		return campusCode;
	}

	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDeptItem() {
		return deptItem;
	}

	public void setDeptItem(String deptItem) {
		this.deptItem = deptItem;
	}

	@Override
	public String toString() {
		return "RespCampusVO [uid=" + uid + ", deptCode=" + deptCode + ", deptName=" + deptName + ", campusCode="
				+ campusCode + ", campusName=" + campusName + ", phone=" + phone + ", photo=" + photo
				+ ", provinceCode=" + provinceCode + ", provinceName=" + provinceName + ", cityCode=" + cityCode
				+ ", cityName=" + cityName + ", countyCode=" + countyCode + ", countyName=" + countyName + ", street="
				+ street + ", address=" + address + ", coordinate=" + coordinate + ", operatorUid=" + operatorUid
				+ ", operatorName=" + operatorName + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", state=" + state + ", deptItem=" + deptItem + "]";
	}

}