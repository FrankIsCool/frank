package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "func")
public class Func {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 上级uid
     */
    @Column(name = "father_uid")
    private Long fatherUid;

    /**
     * 功能编码
     */
    @Column(name = "function_sn")
    private String functionSn;

    /**
     * 功能名称
     */
    @Column(name = "function_name")
    private String functionName;

    /**
     * 功能路径
     */
    @Column(name = "funll_name")
    private String funllName;

    /**
     * 对应html的url，或者功能的url
     */
    @Column(name = "function_path")
    private String functionPath;

    /**
     * 类型：1：页面，2：功能
     */
    @Column(name = "function_type")
    private Byte functionType;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 状态：1：正常，2：已删除
     */
    private Byte del;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取上级uid
     *
     * @return father_uid - 上级uid
     */
    public Long getFatherUid() {
        return fatherUid;
    }

    /**
     * 设置上级uid
     *
     * @param fatherUid 上级uid
     */
    public void setFatherUid(Long fatherUid) {
        this.fatherUid = fatherUid;
    }

    /**
     * 获取功能编码
     *
     * @return function_sn - 功能编码
     */
    public String getFunctionSn() {
        return functionSn;
    }

    /**
     * 设置功能编码
     *
     * @param functionSn 功能编码
     */
    public void setFunctionSn(String functionSn) {
        this.functionSn = functionSn == null ? null : functionSn.trim();
    }

    /**
     * 获取功能名称
     *
     * @return function_name - 功能名称
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * 设置功能名称
     *
     * @param functionName 功能名称
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    /**
     * 获取功能路径
     *
     * @return funll_name - 功能路径
     */
    public String getFunllName() {
        return funllName;
    }

    /**
     * 设置功能路径
     *
     * @param funllName 功能路径
     */
    public void setFunllName(String funllName) {
        this.funllName = funllName == null ? null : funllName.trim();
    }

    /**
     * 获取对应html的url，或者功能的url
     *
     * @return function_path - 对应html的url，或者功能的url
     */
    public String getFunctionPath() {
        return functionPath;
    }

    /**
     * 设置对应html的url，或者功能的url
     *
     * @param functionPath 对应html的url，或者功能的url
     */
    public void setFunctionPath(String functionPath) {
        this.functionPath = functionPath == null ? null : functionPath.trim();
    }

    /**
     * 获取类型：1：页面，2：功能
     *
     * @return function_type - 类型：1：页面，2：功能
     */
    public Byte getFunctionType() {
        return functionType;
    }

    /**
     * 设置类型：1：页面，2：功能
     *
     * @param functionType 类型：1：页面，2：功能
     */
    public void setFunctionType(Byte functionType) {
        this.functionType = functionType;
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