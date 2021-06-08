package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(description = "预约单分配管理VO")
public class RespReserveOrdersAllotVO implements Serializable {
	/**
	 * uid
	 */
	private Long uid;

	/**
	 * 子预约单号
	 */
	private String orderItemSn;

	/**
	 * 子预约单uid
	 */
	private Long orderItemUid;

	/**
	 * 预约单号
	 */
	private String orderSn;

	/**
	 * 预约单uid
	 */
	private Long orderUid;

	/**
	 * 负责跟进人所属部门编号
	 */
	private String deptCode;

	/**
	 * 负责跟进人所属分组编号
	 */
	private String groupCode;

	/**
	 * 负责跟进人职位编号
	 */
	private String positionCode;

	/**
	 * 负责跟进人uid
	 */
	private String handlerUid;

	/**
	 * 负责跟进人名称
	 */
	private String handlerName;

	/**
	 * 操作人uid
	 */
	private String operatorUid;

	/**
	 * 操作人名称
	 */
	private String operatorName;

	/**
	 * 操作人所属部门编号
	 */
	private String opDeptCode;

	/**
	 * 操作人职位编号
	 */
	private String opPoCode;

	/**
	 * 状态 1有效,0失效
	 */
	private String state;

	/**
	 * 院校uid
	 */
	private Long collegeUid;

	/**
	 * 院校名称
	 */
	private String collegeName;

	public Long getCollegeUid() {
		return collegeUid;
	}

	public void setCollegeUid(Long collegeUid) {
		this.collegeUid = collegeUid;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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
	 * @param uid
	 *            uid
	 */
	public void setUid(Long uid) {
		this.uid = uid;
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
	 * @param orderItemSn
	 *            子预约单号
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
	 * @param orderItemUid
	 *            子预约单uid
	 */
	public void setOrderItemUid(Long orderItemUid) {
		this.orderItemUid = orderItemUid;
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
	 * @param orderSn
	 *            预约单号
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
	 * @param orderUid
	 *            预约单uid
	 */
	public void setOrderUid(Long orderUid) {
		this.orderUid = orderUid;
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
	 * @param deptCode
	 *            负责跟进人所属部门编号
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
	 * @param groupCode
	 *            负责跟进人所属分组编号
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
	 * @param positionCode
	 *            负责跟进人职位编号
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
	 * @param handlerUid
	 *            负责跟进人uid
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
	 * @param handlerName
	 *            负责跟进人名称
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
	 * @param operatorUid
	 *            操作人uid
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
	 * @param operatorName
	 *            操作人名称
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
	 * @param opDeptCode
	 *            操作人所属部门编号
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
	 * @param opPoCode
	 *            操作人职位编号
	 */
	public void setOpPoCode(String opPoCode) {
		this.opPoCode = opPoCode == null ? null : opPoCode.trim();
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
	 * @param state
	 *            状态 1有效,0失效
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	@Override
	public String toString() {
		return "RespReserveOrdersAllotVO [uid=" + uid + ", orderItemSn=" + orderItemSn + ", orderItemUid="
				+ orderItemUid + ", orderSn=" + orderSn + ", orderUid=" + orderUid + ", deptCode=" + deptCode
				+ ", groupCode=" + groupCode + ", positionCode=" + positionCode + ", handlerUid=" + handlerUid
				+ ", handlerName=" + handlerName + ", operatorUid=" + operatorUid + ", operatorName=" + operatorName
				+ ", opDeptCode=" + opDeptCode + ", opPoCode=" + opPoCode + ", state=" + state + ", collegeUid="
				+ collegeUid + ", collegeName=" + collegeName + "]";
	}

}