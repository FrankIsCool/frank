package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cow_die_log")
public class CowDieLog {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 牧场uid
     */
    @Column(name = "farmers_uid")
    private Long farmersUid;

    /**
     * 牛只uid
     */
    @Column(name = "cow_uid")
    private Long cowUid;

    /**
     * 死亡时间
     */
    @Column(name = "die_time")
    private Date dieTime;

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
     * 获取牧场uid
     *
     * @return farmers_uid - 牧场uid
     */
    public Long getFarmersUid() {
        return farmersUid;
    }

    /**
     * 设置牧场uid
     *
     * @param farmersUid 牧场uid
     */
    public void setFarmersUid(Long farmersUid) {
        this.farmersUid = farmersUid;
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
     * 获取死亡时间
     *
     * @return die_time - 死亡时间
     */
    public Date getDieTime() {
        return dieTime;
    }

    /**
     * 设置死亡时间
     *
     * @param dieTime 死亡时间
     */
    public void setDieTime(Date dieTime) {
        this.dieTime = dieTime;
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