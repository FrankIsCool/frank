package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "weight")
public class Weight {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 牛只uid
     */
    @Column(name = "cow_uid")
    private Long cowUid;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 创建日期
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
     * 获取牛只uid
     *
     * @return cow_uid - 牛只uid
     */
    public Long getCowUid() {
        return cowUid;
    }

    /**
     * 设置牛只uid
     *
     * @param cowUid 牛只uid
     */
    public void setCowUid(Long cowUid) {
        this.cowUid = cowUid;
    }

    /**
     * 获取体重
     *
     * @return weight - 体重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}