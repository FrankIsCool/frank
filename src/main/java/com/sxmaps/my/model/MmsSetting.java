package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mms_setting")
public class MmsSetting {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 选项编码
     */
    @Column(name = "op_code")
    private String opCode;

    /**
     * 选项名称
     */
    @Column(name = "op_name")
    private String opName;

    /**
     * 类别id
     */
    @Column(name = "cate_id")
    private Long cateId;

    /**
     * 类别编码
     */
    @Column(name = "cate_code")
    private String cateCode;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态 1有效0失效
     */
    private String state;

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
     * 获取选项编码
     *
     * @return op_code - 选项编码
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * 设置选项编码
     *
     * @param opCode 选项编码
     */
    public void setOpCode(String opCode) {
        this.opCode = opCode == null ? null : opCode.trim();
    }

    /**
     * 获取选项名称
     *
     * @return op_name - 选项名称
     */
    public String getOpName() {
        return opName;
    }

    /**
     * 设置选项名称
     *
     * @param opName 选项名称
     */
    public void setOpName(String opName) {
        this.opName = opName == null ? null : opName.trim();
    }

    /**
     * 获取类别id
     *
     * @return cate_id - 类别id
     */
    public Long getCateId() {
        return cateId;
    }

    /**
     * 设置类别id
     *
     * @param cateId 类别id
     */
    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    /**
     * 获取类别编码
     *
     * @return cate_code - 类别编码
     */
    public String getCateCode() {
        return cateCode;
    }

    /**
     * 设置类别编码
     *
     * @param cateCode 类别编码
     */
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态 1有效0失效
     *
     * @return state - 状态 1有效0失效
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 1有效0失效
     *
     * @param state 状态 1有效0失效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}