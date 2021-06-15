package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cow")
public class Cow {
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
     * 品种uid
     */
    @Column(name = "kind_uid")
    private Long kindUid;

    /**
     * 品种
     */
    private String kind;

    /**
     * 耳钉号
     */
    private String num;

    /**
     * 父耳钉号
     */
    @Column(name = "fa_num")
    private String faNum;

    /**
     * 母耳钉号
     */
    @Column(name = "mon_num")
    private String monNum;

    /**
     * 性别：1：公，2：母
     */
    private Byte sex;

    /**
     * 体重/市斤
     */
    private String weight;

    /**
     * 出生日期
     */
    @Column(name = "birth_time")
    private Date birthTime;

    /**
     * 入栏日期
     */
    @Column(name = "lairage_time")
    private Date lairageTime;

    /**
     * 生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖
     */
    @Column(name = "cow_state")
    private Byte cowState;

    /**
     * 状态：1：正常，2：已删除
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
     * 获取品种uid
     *
     * @return kind_uid - 品种uid
     */
    public Long getKindUid() {
        return kindUid;
    }

    /**
     * 设置品种uid
     *
     * @param kindUid 品种uid
     */
    public void setKindUid(Long kindUid) {
        this.kindUid = kindUid;
    }

    /**
     * 获取品种
     *
     * @return kind - 品种
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置品种
     *
     * @param kind 品种
     */
    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    /**
     * 获取耳钉号
     *
     * @return num - 耳钉号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置耳钉号
     *
     * @param num 耳钉号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 获取父耳钉号
     *
     * @return fa_num - 父耳钉号
     */
    public String getFaNum() {
        return faNum;
    }

    /**
     * 设置父耳钉号
     *
     * @param faNum 父耳钉号
     */
    public void setFaNum(String faNum) {
        this.faNum = faNum == null ? null : faNum.trim();
    }

    /**
     * 获取母耳钉号
     *
     * @return mon_num - 母耳钉号
     */
    public String getMonNum() {
        return monNum;
    }

    /**
     * 设置母耳钉号
     *
     * @param monNum 母耳钉号
     */
    public void setMonNum(String monNum) {
        this.monNum = monNum == null ? null : monNum.trim();
    }

    /**
     * 获取性别：1：公，2：母
     *
     * @return sex - 性别：1：公，2：母
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别：1：公，2：母
     *
     * @param sex 性别：1：公，2：母
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取体重/市斤
     *
     * @return weight - 体重/市斤
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置体重/市斤
     *
     * @param weight 体重/市斤
     */
    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    /**
     * 获取出生日期
     *
     * @return birth_time - 出生日期
     */
    public Date getBirthTime() {
        return birthTime;
    }

    /**
     * 设置出生日期
     *
     * @param birthTime 出生日期
     */
    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    /**
     * 获取入栏日期
     *
     * @return lairage_time - 入栏日期
     */
    public Date getLairageTime() {
        return lairageTime;
    }

    /**
     * 设置入栏日期
     *
     * @param lairageTime 入栏日期
     */
    public void setLairageTime(Date lairageTime) {
        this.lairageTime = lairageTime;
    }

    /**
     * 获取生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖
     *
     * @return cow_state - 生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖
     */
    public Byte getCowState() {
        return cowState;
    }

    /**
     * 设置生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖
     *
     * @param cowState 生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖
     */
    public void setCowState(Byte cowState) {
        this.cowState = cowState;
    }

    /**
     * 获取状态：1：正常，2：已删除
     *
     * @return del - 状态：1：正常，2：已删除
     */
    public Byte getDel() {
        return del;
    }

    /**
     * 设置状态：1：正常，2：已删除
     *
     * @param del 状态：1：正常，2：已删除
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