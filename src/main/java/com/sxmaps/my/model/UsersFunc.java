package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "users_func")
public class UsersFunc {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 用户uid
     */
    @Column(name = "user_uid")
    private Long userUid;

    /**
     * 功能uid
     */
    @Column(name = "function_uid")
    private Long functionUid;

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
     * 获取用户uid
     *
     * @return user_uid - 用户uid
     */
    public Long getUserUid() {
        return userUid;
    }

    /**
     * 设置用户uid
     *
     * @param userUid 用户uid
     */
    public void setUserUid(Long userUid) {
        this.userUid = userUid;
    }

    /**
     * 获取功能uid
     *
     * @return function_uid - 功能uid
     */
    public Long getFunctionUid() {
        return functionUid;
    }

    /**
     * 设置功能uid
     *
     * @param functionUid 功能uid
     */
    public void setFunctionUid(Long functionUid) {
        this.functionUid = functionUid;
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