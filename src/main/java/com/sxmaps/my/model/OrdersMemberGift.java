package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "orders_member_gift")
public class OrdersMemberGift {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 编号
     */
    @Column(name = "record_sn")
    private String recordSn;

    /**
     * 主订单号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 子订单号
     */
    @Column(name = "order_item_sn")
    private String orderItemSn;

    /**
     * 收件人
     */
    @Column(name = "receiver")
    private String receiver;

    /**
     * 收件人手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 收件人邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 省编号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 省名称
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
    @Column(name = "street")
    private String street;

    /**
     * 地址全称
     */
    @Column(name = "address")
    private String address;

    /**
     * 是否赠送 1赠送;0未赠送
     */
    @Column(name = "is_deal")
    private Integer isDeal;

    /**
     * 是否发货 1已发货;0未发货
     */
    @Column(name = "is_send")
    private Integer isSend;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 发货时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 状态 1有效;0失效
     */
    @Column(name = "state")
    private Integer state;

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
     * 获取编号
     *
     * @return record_sn - 编号
     */
    public String getRecordSn() {
        return recordSn;
    }

    /**
     * 设置编号
     *
     * @param recordSn 编号
     */
    public void setRecordSn(String recordSn) {
        this.recordSn = recordSn == null ? null : recordSn.trim();
    }

    /**
     * 获取主订单号
     *
     * @return order_sn - 主订单号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置主订单号
     *
     * @param orderSn 主订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 获取子订单号
     *
     * @return order_item_sn - 子订单号
     */
    public String getOrderItemSn() {
        return orderItemSn;
    }

    /**
     * 设置子订单号
     *
     * @param orderItemSn 子订单号
     */
    public void setOrderItemSn(String orderItemSn) {
        this.orderItemSn = orderItemSn == null ? null : orderItemSn.trim();
    }

    /**
     * 获取收件人
     *
     * @return receiver - 收件人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收件人
     *
     * @param receiver 收件人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * 获取收件人手机号
     *
     * @return phone - 收件人手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置收件人手机号
     *
     * @param phone 收件人手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取收件人邮箱
     *
     * @return eamil - 收件人邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置收件人邮箱
     *
     * @param eamil 收件人邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取省编号
     *
     * @return province_code - 省编号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省编号
     *
     * @param provinceCode 省编号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 获取省名称
     *
     * @return province_name - 省名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置省名称
     *
     * @param provinceName 省名称
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
     * 获取地址全称
     *
     * @return address - 地址全称
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址全称
     *
     * @param address 地址全称
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取是否赠送 1赠送;0未赠送
     *
     * @return is_deal - 是否赠送 1赠送;0未赠送
     */
    public Integer getIsDeal() {
        return isDeal;
    }

    /**
     * 设置是否赠送 1赠送;0未赠送
     *
     * @param isDeal 是否赠送 1赠送;0未赠送
     */
    public void setIsDeal(Integer isDeal) {
        this.isDeal = isDeal;
    }

    /**
     * 获取是否发货 1已发货;0未发货
     *
     * @return is_send - 是否发货 1已发货;0未发货
     */
    public Integer getIsSend() {
        return isSend;
    }

    /**
     * 设置是否发货 1已发货;0未发货
     *
     * @param isSend 是否发货 1已发货;0未发货
     */
    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取发货时间
     *
     * @return send_time - 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发货时间
     *
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取状态 1有效;0失效
     *
     * @return state - 状态 1有效;0失效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 1有效;0失效
     *
     * @param state 状态 1有效;0失效
     */
    public void setState(Integer state) {
        this.state = state;
    }
}