package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login")
public class Login {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 登录人uid
     */
    @Column(name = "user_uid")
    private Long userUid;

    /**
     * 登录令牌
     */
    private String token;

    /**
     * 有效时间
     */
    @Column(name = "valid_time")
    private Date validTime;

    /**
     * 用户基本信息
     */
    @Column(name = "user_info")
    private String userInfo;

    /**
     * 功能码
     */
    private String functions;

    /**
     * 状态：1：有效 2：删除
     */
    private Byte del;

    /**
     * 登录时间
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
     * 获取登录人uid
     *
     * @return user_uid - 登录人uid
     */
    public Long getUserUid() {
        return userUid;
    }

    /**
     * 设置登录人uid
     *
     * @param userUid 登录人uid
     */
    public void setUserUid(Long userUid) {
        this.userUid = userUid;
    }

    /**
     * 获取登录令牌
     *
     * @return token - 登录令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置登录令牌
     *
     * @param token 登录令牌
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取有效时间
     *
     * @return valid_time - 有效时间
     */
    public Date getValidTime() {
        return validTime;
    }

    /**
     * 设置有效时间
     *
     * @param validTime 有效时间
     */
    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    /**
     * 获取用户基本信息
     *
     * @return user_info - 用户基本信息
     */
    public String getUserInfo() {
        return userInfo;
    }

    /**
     * 设置用户基本信息
     *
     * @param userInfo 用户基本信息
     */
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    /**
     * 获取功能码
     *
     * @return functions - 功能码
     */
    public String getFunctions() {
        return functions;
    }

    /**
     * 设置功能码
     *
     * @param functions 功能码
     */
    public void setFunctions(String functions) {
        this.functions = functions == null ? null : functions.trim();
    }

    /**
     * 获取状态：1：有效 2：删除
     *
     * @return state - 状态：1：有效 2：删除
     */
    public Byte getDel() {
        return del;
    }

    /**
     * 设置状态：1：有效 2：删除
     *
     * @param state 状态：1：有效 2：删除
     */
    public void setDel(Byte del) {
        this.del = del;
    }

    /**
     * 获取登录时间
     *
     * @return create_time - 登录时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置登录时间
     *
     * @param createTime 登录时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}