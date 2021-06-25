package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cow_ill_log")
public class CowIllLog {
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
     * 生病时间
     */
    @Column(name = "ill_time")
    private Date illTime;

    /**
     * 治愈时间
     */
    @Column(name = "cure_time")
    private Date cureTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 修改时间
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
     * 获取生病时间
     *
     * @return ill_time - 生病时间
     */
    public Date getIllTime() {
        return illTime;
    }

    /**
     * 设置生病时间
     *
     * @param illTime 生病时间
     */
    public void setIllTime(Date illTime) {
        this.illTime = illTime;
    }

    /**
     * 获取治愈时间
     *
     * @return cure_time - 治愈时间
     */
    public Date getCureTime() {
        return cureTime;
    }

    /**
     * 设置治愈时间
     *
     * @param cureTime 治愈时间
     */
    public void setCureTime(Date cureTime) {
        this.cureTime = cureTime;
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