package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mms_opinion")
public class MmsOpinion {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 点评项
     */
    @Column(name = "views")
    private String views;

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
     * 状态 1有效,0失效
     */
    private String state;

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
     * 获取点评项
     *
     * @return views - 点评项
     */
    public String getViews() {
        return views;
    }

    /**
     * 设置点评项
     *
     * @param views 点评项
     */
    public void setViews(String views) {
        this.views = views == null ? null : views.trim();
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
     * 获取状态 1有效,0失效
     *
     * @return state - 状态 1有效,0失效
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 1有效,0失效
     *
     * @param state 状态 1有效,0失效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}