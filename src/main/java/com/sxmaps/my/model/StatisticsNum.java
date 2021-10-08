package com.sxmaps.my.model;

import javax.persistence.*;

@Table(name = "statistics_num")
public class StatisticsNum {
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
     * 死亡总数
     */
    private Integer die;

    /**
     * 生病总数
     */
    private Integer ill;

    /**
     * 治愈总数
     */
    private Integer cure;

    /**
     * 售卖总数
     */
    private Integer sale;

    /**
     * 怀孕总数
     */
    private Integer fetation;

    /**
     * 出生总数
     */
    private Integer birth;

    /**
     * 购买总数
     */
    private Integer buy;

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
     * 获取死亡总数
     *
     * @return die - 死亡总数
     */
    public Integer getDie() {
        return die;
    }

    /**
     * 设置死亡总数
     *
     * @param die 死亡总数
     */
    public void setDie(Integer die) {
        this.die = die;
    }

    /**
     * 获取生病总数
     *
     * @return ill - 生病总数
     */
    public Integer getIll() {
        return ill;
    }

    /**
     * 设置生病总数
     *
     * @param ill 生病总数
     */
    public void setIll(Integer ill) {
        this.ill = ill;
    }

    /**
     * 获取治愈总数
     *
     * @return cure - 治愈总数
     */
    public Integer getCure() {
        return cure;
    }

    /**
     * 设置治愈总数
     *
     * @param cure 治愈总数
     */
    public void setCure(Integer cure) {
        this.cure = cure;
    }

    /**
     * 获取售卖总数
     *
     * @return sale - 售卖总数
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * 设置售卖总数
     *
     * @param sale 售卖总数
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * 获取怀孕总数
     *
     * @return fetation - 怀孕总数
     */
    public Integer getFetation() {
        return fetation;
    }

    /**
     * 设置怀孕总数
     *
     * @param fetation 怀孕总数
     */
    public void setFetation(Integer fetation) {
        this.fetation = fetation;
    }

    /**
     * 获取出生总数
     *
     * @return birth - 出生总数
     */
    public Integer getBirth() {
        return birth;
    }

    /**
     * 设置出生总数
     *
     * @param birth 出生总数
     */
    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    /**
     * 获取购买总数
     *
     * @return buy - 购买总数
     */
    public Integer getBuy() {
        return buy;
    }

    /**
     * 设置购买总数
     *
     * @param buy 购买总数
     */
    public void setBuy(Integer buy) {
        this.buy = buy;
    }
}