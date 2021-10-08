package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_add")
public class StatisticsAdd {
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
     * 日期
     */
    @Column(name = "date_time")
    private Date dateTime;

    /**
     * 新增死亡数
     */
    @Column(name = "add_die")
    private Integer addDie;

    /**
     * 新增生病数
     */
    @Column(name = "add_ill")
    private Integer addIll;

    /**
     * 新增治愈数
     */
    @Column(name = "add_cure")
    private Integer addCure;

    /**
     * 新增怀孕数
     */
    @Column(name = "add_fetation")
    private Integer addFetation;

    /**
     * 新增出生数
     */
    @Column(name = "add_birth")
    private Integer addBirth;

    /**
     * 新增购买数
     */
    @Column(name = "add_buy")
    private Integer addBuy;
    /**
     * 新增售卖数
     */
    @Column(name = "add_sale")
    private Integer addSale;

    public Integer getAddSale() {
        return addSale;
    }

    public void setAddSale(Integer addSale) {
        this.addSale = addSale;
    }

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
     * 获取日期
     *
     * @return date_time - 日期
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * 设置日期
     *
     * @param dateTime 日期
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 获取新增死亡数
     *
     * @return add_die - 新增死亡数
     */
    public Integer getAddDie() {
        return addDie;
    }

    /**
     * 设置新增死亡数
     *
     * @param addDie 新增死亡数
     */
    public void setAddDie(Integer addDie) {
        this.addDie = addDie;
    }

    /**
     * 获取新增生病数
     *
     * @return add_ill - 新增生病数
     */
    public Integer getAddIll() {
        return addIll;
    }

    /**
     * 设置新增生病数
     *
     * @param addIll 新增生病数
     */
    public void setAddIll(Integer addIll) {
        this.addIll = addIll;
    }

    /**
     * 获取新增治愈数
     *
     * @return add_cure - 新增治愈数
     */
    public Integer getAddCure() {
        return addCure;
    }

    /**
     * 设置新增治愈数
     *
     * @param addCure 新增治愈数
     */
    public void setAddCure(Integer addCure) {
        this.addCure = addCure;
    }

    /**
     * 获取新增怀孕数
     *
     * @return add_fetation - 新增怀孕数
     */
    public Integer getAddFetation() {
        return addFetation;
    }

    /**
     * 设置新增怀孕数
     *
     * @param addFetation 新增怀孕数
     */
    public void setAddFetation(Integer addFetation) {
        this.addFetation = addFetation;
    }

    /**
     * 获取新增出生数
     *
     * @return add_birth - 新增出生数
     */
    public Integer getAddBirth() {
        return addBirth;
    }

    /**
     * 设置新增出生数
     *
     * @param addBirth 新增出生数
     */
    public void setAddBirth(Integer addBirth) {
        this.addBirth = addBirth;
    }

    /**
     * 获取新增购买数
     *
     * @return add_buy - 新增购买数
     */
    public Integer getAddBuy() {
        return addBuy;
    }

    /**
     * 设置新增购买数
     *
     * @param addBuy 新增购买数
     */
    public void setAddBuy(Integer addBuy) {
        this.addBuy = addBuy;
    }
}