package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_type")
public class PayType {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 支付名称
     */
    @Column(name = "pay_name")
    private String payName;
    /**
     * 类型：1：消耗品，2：固定支出
     */
    @Column(name = "pay_type")
    private Byte payType;

    /**
     * 创建名称
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

    public void setPayType(Byte payType) {
        this.payType = payType;
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
     * 获取支付名称
     *
     * @return pay_name - 支付名称
     */
    public String getPayName() {
        return payName;
    }

    /**
     * 设置支付名称
     *
     * @param payName 支付名称
     */
    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    /**
     * 获取创建名称
     *
     * @return create_time - 创建名称
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建名称
     *
     * @param createTime 创建名称
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}