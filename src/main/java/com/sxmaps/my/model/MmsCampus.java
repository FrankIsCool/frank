package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mms_campus")
public class MmsCampus {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 分校编号
     */
    @Column(name = "campus_code")
    private String campusCode;

    /**
     * 分校名称
     */
    @Column(name = "campus_name")
    private String campusName;

    /**
     * 所属部门编码
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 所属部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 分校图片
     */
    private String photo;

    /**
     * 省份编号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 省份名称
     */
    @Column(name = "province_name")
    private String provinceName;

    /**
     * 城市编号
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 区编号
     */
    @Column(name = "county_code")
    private String countyCode;

    /**
     * 区名称
     */
    @Column(name = "county_name")
    private String countyName;

    /**
     * 街道
     */
    private String street;

    /**
     * 全地址
     */
    private String address;

    /**
     * X,Y坐标
     */
    private String coordinate;

    /**
     * 操作人uid
     */
    @Column(name = "operator_uid")
    private String operatorUid;

    /**
     * 操作人名称
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态 1有效,0删除
     */
    private String state;

    /**
     * 部门信息
     */
    @Column(name = "dept_item")
    private String deptItem;

    /**
     * 获取uid
     *
     * @return uid - uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取分校编号
     *
     * @return campus_code - 分校编号
     */
    public String getCampusCode() {
        return campusCode;
    }

    /**
     * 设置分校编号
     *
     * @param campusCode 分校编号
     */
    public void setCampusCode(String campusCode) {
        this.campusCode = campusCode == null ? null : campusCode.trim();
    }

    /**
     * 获取分校名称
     *
     * @return campus_name - 分校名称
     */
    public String getCampusName() {
        return campusName;
    }

    /**
     * 设置分校名称
     *
     * @param campusName 分校名称
     */
    public void setCampusName(String campusName) {
        this.campusName = campusName == null ? null : campusName.trim();
    }

    /**
     * 获取所属部门编码
     *
     * @return dept_code - 所属部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置所属部门编码
     *
     * @param deptCode 所属部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 获取所属部门名称
     *
     * @return dept_name - 所属部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置所属部门名称
     *
     * @param deptName 所属部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取分校图片
     *
     * @return photo - 分校图片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置分校图片
     *
     * @param photo 分校图片
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取省份编号
     *
     * @return province_code - 省份编号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省份编号
     *
     * @param provinceCode 省份编号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 获取省份名称
     *
     * @return province_name - 省份名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置省份名称
     *
     * @param provinceName 省份名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * 获取城市编号
     *
     * @return city_code - 城市编号
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市编号
     *
     * @param cityCode 城市编号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取城市名称
     *
     * @return city_name - 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     *
     * @param cityName 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取区编号
     *
     * @return county_code - 区编号
     */
    public String getCountyCode() {
        return countyCode;
    }

    /**
     * 设置区编号
     *
     * @param countyCode 区编号
     */
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    /**
     * 获取区名称
     *
     * @return county_name - 区名称
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * 设置区名称
     *
     * @param countyName 区名称
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    /**
     * 获取街道
     *
     * @return street - 街道
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置街道
     *
     * @param street 街道
     */
    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    /**
     * 获取全地址
     *
     * @return address - 全地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置全地址
     *
     * @param address 全地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取X,Y坐标
     *
     * @return coordinate - X,Y坐标
     */
    public String getCoordinate() {
        return coordinate;
    }

    /**
     * 设置X,Y坐标
     *
     * @param coordinate X,Y坐标
     */
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    /**
     * 获取操作人uid
     *
     * @return operator_uid - 操作人uid
     */
    public String getOperatorUid() {
        return operatorUid;
    }

    /**
     * 设置操作人uid
     *
     * @param operatorUid 操作人uid
     */
    public void setOperatorUid(String operatorUid) {
        this.operatorUid = operatorUid == null ? null : operatorUid.trim();
    }

    /**
     * 获取操作人名称
     *
     * @return operator_name - 操作人名称
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作人名称
     *
     * @param operatorName 操作人名称
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态 1有效,0删除
     *
     * @return state - 状态 1有效,0删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 1有效,0删除
     *
     * @param state 状态 1有效,0删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取部门信息
     *
     * @return dept_item - 部门信息
     */
    public String getDeptItem() {
        return deptItem;
    }

    /**
     * 设置部门信息
     *
     * @param deptItem 部门信息
     */
    public void setDeptItem(String deptItem) {
        this.deptItem = deptItem == null ? null : deptItem.trim();
    }
}