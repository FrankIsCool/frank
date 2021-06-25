package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kind_collect")
public class KindCollect {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 种类uid
     */
    @Column(name = "kind_uid")
    private Long kindUid;

    /**
     * 牧场uid
     */
    @Column(name = "farmers_uid")
    private Long farmersUid;

    /**
     * 汇总日期
     */
    @Column(name = "collect_date")
    private Date collectDate;

    /**
     * 数量
     */
    private Integer num;

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
     * 获取种类uid
     *
     * @return kind_uid - 种类uid
     */
    public Long getKindUid() {
        return kindUid;
    }

    /**
     * 设置种类uid
     *
     * @param kindUid 种类uid
     */
    public void setKindUid(Long kindUid) {
        this.kindUid = kindUid;
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
     * 获取汇总日期
     *
     * @return collect_date - 汇总日期
     */
    public Date getCollectDate() {
        return collectDate;
    }

    /**
     * 设置汇总日期
     *
     * @param collectDate 汇总日期
     */
    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    /**
     * 获取数量
     *
     * @return num - 数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置数量
     *
     * @param num 数量
     */
    public void setNum(Integer num) {
        this.num = num;
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