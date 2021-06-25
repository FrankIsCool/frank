package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "earnings_type")
public class EarningsType {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 收益类型名称
     */
    @Column(name = "earnings_name")
    private String earningsName;

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
     * 获取收益类型名称
     *
     * @return earnings_name - 收益类型名称
     */
    public String getEarningsName() {
        return earningsName;
    }

    /**
     * 设置收益类型名称
     *
     * @param earningsName 收益类型名称
     */
    public void setEarningsName(String earningsName) {
        this.earningsName = earningsName == null ? null : earningsName.trim();
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