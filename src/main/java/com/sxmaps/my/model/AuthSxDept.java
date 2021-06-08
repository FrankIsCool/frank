package com.sxmaps.mms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "auth_dept_sx")
public class AuthSxDept {

    /**
     * 部门ID
     */
    @Id
    @Column(name = "dept_id")
    private String deptId;

    /**
     * 上级部门ID
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 上级部门名称
     */
    private String parentName;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 状态: 0:正常 ,1:停用
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 数据来源（0:默认;1:SHR）
     */
    private Integer source;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Date createBy;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * ztree属性
     */
    private Boolean open;

    /**
     * 子部门集合
     */
    private List<AuthSxDept> childList;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Integer getOrderNum() {
        return orderNum == null ? 0 : orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<AuthSxDept> getChildList() {
        return childList;
    }

    public void setChildList(List<AuthSxDept> childList) {
        this.childList = childList;
    }

}
