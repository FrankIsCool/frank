package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "分校管理VO")
public class ReqCampusVO implements Serializable {
	/**
	 * uid
	 */
	@ApiModelProperty(name = "uid", value = "主键id,添加可不用传", example = "1")
	private Long uid;

	/**
	 * 所属部门编码
	 */
	@NotBlank(message = "所属部门编码不可为空")
	@ApiModelProperty(name = "deptCode", value = "所属部门编码(必填)", allowEmptyValue = false)
	private String deptCode;

	/**
	 * 所属部门名称
	 */
	@NotBlank(message = "所属部门名称不可为空")
	@ApiModelProperty(name = "deptName", value = "所属部门名称(必填)", allowEmptyValue = false)
	private String deptName;
	/**
	 * 分校名称
	 */
	@NotBlank(message = "分校名称不可为空")
	@ApiModelProperty(name = "campusName", value = "分校名称(必填)", example = "车公庙分校", allowEmptyValue = false)
	private String campusName;

	/**
	 * 联系电话
	 */
	@NotBlank(message = "联系电话不可为空")
	@ApiModelProperty(name = "phone", value = "联系电话(必填)", example = "13465985623", allowEmptyValue = false)
	private String phone;

	/**
	 * 分校图片
	 */
	@NotBlank(message = "分校图片不可为空")
	@ApiModelProperty(name = "photo", value = "分校图片(必填)", example = "123.jpg", allowEmptyValue = false)
	private String photo;

	/**
	 * 省份编号
	 */
	@NotBlank(message = "省份编号不可为空")
	@ApiModelProperty(name = "provinceCode", value = "省份编号(必填)", example = "440000", allowEmptyValue = false)
	private String provinceCode;

	/**
	 * 省份名称
	 */
	@NotBlank(message = "省份名称不可为空")
	@ApiModelProperty(name = "provinceName", value = "省份名称(必填)", example = "广东省", allowEmptyValue = false)
	private String provinceName;

	/**
	 * 城市编号
	 */
	@NotBlank(message = "城市编号不可为空")
	@ApiModelProperty(name = "cityCode", value = "城市编号(必填)", example = "440300", allowEmptyValue = false)
	private String cityCode;

	/**
	 * 城市名称
	 */
	@NotBlank(message = "城市名称不可为空")
	@ApiModelProperty(name = "cityName", value = "城市名称(必填)", example = "深圳市", allowEmptyValue = false)
	private String cityName;

	/**
	 * 区编号
	 */
	@ApiModelProperty(name = "countyCode", value = "区编号", example = "440307", allowEmptyValue = false)
	private String countyCode;

	/**
	 * 区名称
	 */
	@ApiModelProperty(name = "countyName", value = "区名称", example = "龙岗区", allowEmptyValue = false)
	private String countyName;

	/**
	 * 街道
	 */
	@NotBlank(message = "街道不可为空")
	@ApiModelProperty(name = "street", value = "街道(必填)", example = "坂田街道1122", allowEmptyValue = false)
	private String street;

	/**
	 * X,Y坐标
	 */
	@NotBlank(message = "坐标不可为空")
	@ApiModelProperty(name = "coordinate", value = "X,Y坐标(必填)", example = "15,16", allowEmptyValue = false)
	private String coordinate;

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

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getDeptItem() {
		return deptItem;
	}

	public void setDeptItem(String deptItem) {
		this.deptItem = deptItem;
	}

	@Override
	public String toString() {
		return "ReqCampusVO [uid=" + uid + ", deptCode=" + deptCode + ", deptName=" + deptName + ", campusName="
				+ campusName + ", phone=" + phone + ", photo=" + photo + ", provinceCode=" + provinceCode
				+ ", provinceName=" + provinceName + ", cityCode=" + cityCode + ", cityName=" + cityName
				+ ", countyCode=" + countyCode + ", countyName=" + countyName + ", street=" + street + ", coordinate="
				+ coordinate + ", deptItem=" + deptItem + "]";
	}

}