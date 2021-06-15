package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "farmers")
public class Farmers {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 牧场名称
     */
    @Column(name = "farmers_name")
    private String farmersName;

    /**
     * 牧场详细地址
     */
    @Column(name = "farmers_address")
    private String farmersAddress;

    /**
     * 状态：1：正常 2：已删除
     */
    private Byte del;

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
     * 获取牧场名称
     *
     * @return farmers_name - 牧场名称
     */
    public String getFarmersName() {
        return farmersName;
    }

    /**
     * 设置牧场名称
     *
     * @param farmersName 牧场名称
     */
    public void setFarmersName(String farmersName) {
        this.farmersName = farmersName == null ? null : farmersName.trim();
    }

    /**
     * 获取牧场详细地址
     *
     * @return farmers_address - 牧场详细地址
     */
    public String getFarmersAddress() {
        return farmersAddress;
    }

    /**
     * 设置牧场详细地址
     *
     * @param farmersAddress 牧场详细地址
     */
    public void setFarmersAddress(String farmersAddress) {
        this.farmersAddress = farmersAddress == null ? null : farmersAddress.trim();
    }

    /**
     * 获取状态：1：正常 2：已删除
     *
     * @return del - 状态：1：正常 2：已删除
     */
    public Byte getDel() {
        return del;
    }

    /**
     * 设置状态：1：正常 2：已删除
     *
     * @param del 状态：1：正常 2：已删除
     */
    public void setDel(Byte del) {
        this.del = del;
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