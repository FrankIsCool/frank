package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "member")
public class Member {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 登录账号
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    @Column(name = "login_pwd")
    private String loginPwd;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 性别  0:保密 1:男 2:女
     */
    @Column(name = "user_sex")
    private Byte userSex;

    /**
     * 真实姓名
     */
    @Column(name = "true_name")
    private String trueName;

    /**
     * 身份证号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 身份证号验证 1:已验证 -1:未验证
     */
    @Column(name = "id_card_verified")
    private Integer idCardVerified;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    @Column(name = "brith_day")
    private Date brithDay;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 手机号验证 1:已验证 -1:未验证
     */
    @Column(name = "cellphone_verified")
    private Integer cellphoneVerified;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱验证 1:已验证 -1:未验证
     */
    @Column(name = "email_verified")
    private Integer emailVerified;

    /**
     * 用户QQ
     */
    @Column(name = "user_QQ")
    private String userQq;

    /**
     * 用户微信号
     */
    @Column(name = "user_wechat")
    private String userWechat;

    /**
     * 紧急联系人
     */
    @Column(name = "urgent_contacts")
    private String urgentContacts;

    /**
     * 紧急联系人电话
     */
    @Column(name = "urgent_contacts_telephone")
    private String urgentContactsTelephone;

    /**
     * 备注
     */
    private String remark;

    /**
     * im账号
     */
    @Column(name = "im_accid")
    private String accid;

    /**
     * IM标示 相当于token
     */
    @Column(name = "im_token")
    private String imToken;

    /**
     * 最后登录时间
     */
    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 省编码
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 省名
     */
    @Column(name = "province_name")
    private String provinceName;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 区编码
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
     * 地址
     */
    private String address;

    /**
     * 头像
     */
    @Column(name = "icon_url")
    private String iconUrl;

    /**
     * 个性签名
     */
    private String signature;

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
     * 账号状态 1:有效 -1:删除 2:锁定
     */
    private Integer status;

    /**
     * 获取自增id
     *
     * @return uid - 自增id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置自增id
     *
     * @param uid 自增id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取登录账号
     *
     * @return login_name - 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录账号
     *
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取登录密码
     *
     * @return login_pwd - 登录密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 设置登录密码
     *
     * @param loginPwd 登录密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取性别  0:保密 1:男 2:女
     *
     * @return user_sex - 性别  0:保密 1:男 2:女
     */
    public Byte getUserSex() {
        return userSex;
    }

    /**
     * 设置性别  0:保密 1:男 2:女
     *
     * @param userSex 性别  0:保密 1:男 2:女
     */
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取真实姓名
     *
     * @return true_name - 真实姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 设置真实姓名
     *
     * @param trueName 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    /**
     * 获取身份证号
     *
     * @return id_card - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取身份证号验证 1:已验证 -1:未验证
     *
     * @return id_card_verified - 身份证号验证 1:已验证 -1:未验证
     */
    public Integer getIdCardVerified() {
        return idCardVerified;
    }

    /**
     * 设置身份证号验证 1:已验证 -1:未验证
     *
     * @param idCardVerified 身份证号验证 1:已验证 -1:未验证
     */
    public void setIdCardVerified(Integer idCardVerified) {
        this.idCardVerified = idCardVerified;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取生日
     *
     * @return brith_day - 生日
     */
    public Date getBrithDay() {
        return brithDay;
    }

    /**
     * 设置生日
     *
     * @param brithDay 生日
     */
    public void setBrithDay(Date brithDay) {
        this.brithDay = brithDay;
    }

    /**
     * 获取手机号
     *
     * @return cellphone - 手机号
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * 设置手机号
     *
     * @param cellphone 手机号
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    /**
     * 获取手机号验证 1:已验证 -1:未验证
     *
     * @return cellphone_verified - 手机号验证 1:已验证 -1:未验证
     */
    public Integer getCellphoneVerified() {
        return cellphoneVerified;
    }

    /**
     * 设置手机号验证 1:已验证 -1:未验证
     *
     * @param cellphoneVerified 手机号验证 1:已验证 -1:未验证
     */
    public void setCellphoneVerified(Integer cellphoneVerified) {
        this.cellphoneVerified = cellphoneVerified;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取邮箱验证 1:已验证 -1:未验证
     *
     * @return email_verified - 邮箱验证 1:已验证 -1:未验证
     */
    public Integer getEmailVerified() {
        return emailVerified;
    }

    /**
     * 设置邮箱验证 1:已验证 -1:未验证
     *
     * @param emailVerified 邮箱验证 1:已验证 -1:未验证
     */
    public void setEmailVerified(Integer emailVerified) {
        this.emailVerified = emailVerified;
    }

    /**
     * 获取用户QQ
     *
     * @return user_QQ - 用户QQ
     */
    public String getUserQq() {
        return userQq;
    }

    /**
     * 设置用户QQ
     *
     * @param userQq 用户QQ
     */
    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    /**
     * 获取用户微信号
     *
     * @return user_wechat - 用户微信号
     */
    public String getUserWechat() {
        return userWechat;
    }

    /**
     * 设置用户微信号
     *
     * @param userWechat 用户微信号
     */
    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat == null ? null : userWechat.trim();
    }

    /**
     * 获取紧急联系人
     *
     * @return urgent_contacts - 紧急联系人
     */
    public String getUrgentContacts() {
        return urgentContacts;
    }

    /**
     * 设置紧急联系人
     *
     * @param urgentContacts 紧急联系人
     */
    public void setUrgentContacts(String urgentContacts) {
        this.urgentContacts = urgentContacts == null ? null : urgentContacts.trim();
    }

    /**
     * 获取紧急联系人电话
     *
     * @return urgent_contacts_telephone - 紧急联系人电话
     */
    public String getUrgentContactsTelephone() {
        return urgentContactsTelephone;
    }

    /**
     * 设置紧急联系人电话
     *
     * @param urgentContactsTelephone 紧急联系人电话
     */
    public void setUrgentContactsTelephone(String urgentContactsTelephone) {
        this.urgentContactsTelephone = urgentContactsTelephone == null ? null : urgentContactsTelephone.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取im账号
     *
     * @return accid - im账号
     */
    public String getAccid() {
        return accid;
    }

    /**
     * 设置im账号
     *
     * @param accid im账号
     */
    public void setAccid(String accid) {
        this.accid = accid == null ? null : accid.trim();
    }

    

    public String getImToken() {
		return imToken;
	}

	public void setImToken(String imToken) {
		this.imToken = imToken;
	}

	/**
     * 获取最后登录时间
     *
     * @return last_time - 最后登录时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastTime 最后登录时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取省编码
     *
     * @return province_code - 省编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省编码
     *
     * @param provinceCode 省编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 获取省名
     *
     * @return province_name - 省名
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置省名
     *
     * @param provinceName 省名
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * 获取城市编码
     *
     * @return city_code - 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市编码
     *
     * @param cityCode 城市编码
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
     * 获取区编码
     *
     * @return county_code - 区编码
     */
    public String getCountyCode() {
        return countyCode;
    }

    /**
     * 设置区编码
     *
     * @param countyCode 区编码
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
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取头像
     *
     * @return icon_url - 头像
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 设置头像
     *
     * @param iconUrl 头像
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    /**
     * 获取个性签名
     *
     * @return signature - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
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
     * 获取账号状态 1:有效 -1:删除 2:锁定
     *
     * @return status - 账号状态 1:有效 -1:删除 2:锁定
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置账号状态 1:有效 -1:删除 2:锁定
     *
     * @param status 账号状态 1:有效 -1:删除 2:锁定
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}