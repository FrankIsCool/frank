package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mms_category")
public class MmsCategory {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 类别编码
     */
    @Column(name = "cate_code")
    private String cateCode;

    /**
     * 类别名称
     */
    @Column(name = "cate_name")
    private String cateName;

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
     * 状态 1有效0失效
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
     * 获取类别编码
     *
     * @return cate_code - 类别编码
     */
    public String getCateCode() {
        return cateCode;
    }

    /**
     * 设置类别编码
     *
     * @param cateCode 类别编码
     */
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    /**
     * 获取类别名称
     *
     * @return cate_name - 类别名称
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * 设置类别名称
     *
     * @param cateName 类别名称
     */
    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
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
     * 获取状态 1有效0失效
     *
     * @return state - 状态 1有效0失效
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 1有效0失效
     *
     * @param state 状态 1有效0失效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}