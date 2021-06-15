package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "users")
public class User {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 0
     */
    @Column(name = "farmers_uid")
    private Long farmersUid;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户
     */
    @Column(name = "user_type")
    private Byte userType;

    /**
     * 状态：1：正常 2：已删除
     */
    private Byte del;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取0
     *
     * @return farmers_uid - 0
     */
    public Long getFarmersUid() {
        return farmersUid;
    }

    /**
     * 设置0
     *
     * @param farmersUid 0
     */
    public void setFarmersUid(Long farmersUid) {
        this.farmersUid = farmersUid;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户
     *
     * @return user_type - 用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户
     *
     * @param userType 用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取状态：1：正常 2：已删除
     *
     * @return state - 状态：1：正常 2：已删除
     */
    public Byte getDel() {
        return del;
    }

    /**
     * 设置状态：1：正常 2：已删除
     *
     * @param state 状态：1：正常 2：已删除
     */
    public void setDel(Byte del) {
        this.del = del;
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
}