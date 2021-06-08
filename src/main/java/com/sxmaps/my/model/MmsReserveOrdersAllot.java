package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mms_reserve_orders_allot")
public class MmsReserveOrdersAllot {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 预约单号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 预约单uid
     */
    @Column(name = "order_uid")
    private Long orderUid;

    /**
     * 子预约单号
     */
    @Column(name = "order_item_sn")
    private String orderItemSn;

    /**
     * 子预约单uid
     */
    @Column(name = "order_item_uid")
    private Long orderItemUid;

    /**
     * 负责跟进人所属部门编号
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 负责跟进人所属分组编号
     */
    @Column(name = "group_code")
    private String groupCode;

    /**
     * 负责跟进人职位编号
     */
    @Column(name = "position_code")
    private String positionCode;

    /**
     * 负责跟进人uid
     */
    @Column(name = "handler_uid")
    private String handlerUid;

    /**
     * 负责跟进人名称
     */
    @Column(name = "handler_name")
    private String handlerName;

    /**
     * 操作人uid
     */
    @Column(name = "operator_uid")
    private String operatorUid;

    /**
     * 操作人名称
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 操作人所属部门编号
     */
    @Column(name = "op_dept_code")
    private String opDeptCode;

    /**
     * 操作人职位编号
     */
    @Column(name = "op_po_code")
    private String opPoCode;

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
     * 状态 1有效,0失效
     */
    private String state;

    /**
     * 院校uid
     */
    @Column(name = "college_uid")
    private Long collegeUid;

    /**
     * 院校名称
     */
    @Column(name = "college_name")
    private String collegeName;

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
     * 获取预约单号
     *
     * @return order_sn - 预约单号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置预约单号
     *
     * @param orderSn 预约单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 获取预约单uid
     *
     * @return order_uid - 预约单uid
     */
    public Long getOrderUid() {
        return orderUid;
    }

    /**
     * 设置预约单uid
     *
     * @param orderUid 预约单uid
     */
    public void setOrderUid(Long orderUid) {
        this.orderUid = orderUid;
    }

    /**
     * 获取子预约单号
     *
     * @return order_item_sn - 子预约单号
     */
    public String getOrderItemSn() {
        return orderItemSn;
    }

    /**
     * 设置子预约单号
     *
     * @param orderItemSn 子预约单号
     */
    public void setOrderItemSn(String orderItemSn) {
        this.orderItemSn = orderItemSn == null ? null : orderItemSn.trim();
    }

    /**
     * 获取子预约单uid
     *
     * @return order_item_uid - 子预约单uid
     */
    public Long getOrderItemUid() {
        return orderItemUid;
    }

    /**
     * 设置子预约单uid
     *
     * @param orderItemUid 子预约单uid
     */
    public void setOrderItemUid(Long orderItemUid) {
        this.orderItemUid = orderItemUid;
    }

    /**
     * 获取负责跟进人所属部门编号
     *
     * @return dept_code - 负责跟进人所属部门编号
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置负责跟进人所属部门编号
     *
     * @param deptCode 负责跟进人所属部门编号
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 获取负责跟进人所属分组编号
     *
     * @return group_code - 负责跟进人所属分组编号
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 设置负责跟进人所属分组编号
     *
     * @param groupCode 负责跟进人所属分组编号
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    /**
     * 获取负责跟进人职位编号
     *
     * @return position_code - 负责跟进人职位编号
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * 设置负责跟进人职位编号
     *
     * @param positionCode 负责跟进人职位编号
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode == null ? null : positionCode.trim();
    }

    /**
     * 获取负责跟进人uid
     *
     * @return handler_uid - 负责跟进人uid
     */
    public String getHandlerUid() {
        return handlerUid;
    }

    /**
     * 设置负责跟进人uid
     *
     * @param handlerUid 负责跟进人uid
     */
    public void setHandlerUid(String handlerUid) {
        this.handlerUid = handlerUid == null ? null : handlerUid.trim();
    }

    /**
     * 获取负责跟进人名称
     *
     * @return handler_name - 负责跟进人名称
     */
    public String getHandlerName() {
        return handlerName;
    }

    /**
     * 设置负责跟进人名称
     *
     * @param handlerName 负责跟进人名称
     */
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName == null ? null : handlerName.trim();
    }

    /**
     * 获取操作人uid
     *
     * @return operator_uid - 操作人uid
     */
    public String getOperatorUid() {
        return operatorUid;
    }

    /**
     * 设置操作人uid
     *
     * @param operatorUid 操作人uid
     */
    public void setOperatorUid(String operatorUid) {
        this.operatorUid = operatorUid == null ? null : operatorUid.trim();
    }

    /**
     * 获取操作人名称
     *
     * @return operator_name - 操作人名称
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作人名称
     *
     * @param operatorName 操作人名称
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 获取操作人所属部门编号
     *
     * @return op_dept_code - 操作人所属部门编号
     */
    public String getOpDeptCode() {
        return opDeptCode;
    }

    /**
     * 设置操作人所属部门编号
     *
     * @param opDeptCode 操作人所属部门编号
     */
    public void setOpDeptCode(String opDeptCode) {
        this.opDeptCode = opDeptCode == null ? null : opDeptCode.trim();
    }

    /**
     * 获取操作人职位编号
     *
     * @return op_po_code - 操作人职位编号
     */
    public String getOpPoCode() {
        return opPoCode;
    }

    /**
     * 设置操作人职位编号
     *
     * @param opPoCode 操作人职位编号
     */
    public void setOpPoCode(String opPoCode) {
        this.opPoCode = opPoCode == null ? null : opPoCode.trim();
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
     * 获取状态 1有效,0失效
     *
     * @return state - 状态 1有效,0失效
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 1有效,0失效
     *
     * @param state 状态 1有效,0失效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取院校uid
     *
     * @return college_uid - 院校uid
     */
    public Long getCollegeUid() {
        return collegeUid;
    }

    /**
     * 设置院校uid
     *
     * @param collegeUid 院校uid
     */
    public void setCollegeUid(Long collegeUid) {
        this.collegeUid = collegeUid;
    }

    /**
     * 获取院校名称
     *
     * @return college_name - 院校名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置院校名称
     *
     * @param collegeName 院校名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}