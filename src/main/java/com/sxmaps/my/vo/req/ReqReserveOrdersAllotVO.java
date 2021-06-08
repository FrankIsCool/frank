package com.sxmaps.mms.vo.req;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "预约单分配管理VO")
public class ReqReserveOrdersAllotVO implements Serializable {

	@NotEmpty(message = "预约单号不可为空")
	@ApiModelProperty(name = "OrdersItemSn", value = "预约单号(必填)", allowEmptyValue = false)
	private List<ReqOrdersAllotVO> OrdersItemSn;

	/**
	 * 负责跟进人所属部门编号
	 */
	@NotBlank(message = "负责跟进人所属部门编号不可为空")
	@ApiModelProperty(name = "deptCode", value = "负责跟进人所属部门编号(必填)", example = "123456879", allowEmptyValue = false)
	private String deptCode;

	/**
	 * 负责跟进人uid
	 */
	@NotBlank(message = "负责跟进人uid不可为空")
	@ApiModelProperty(name = "handlerUid", value = "负责跟进人uid(必填)", example = "258", allowEmptyValue = false)
	private String handlerUid;

	/**
	 * 负责跟进人名称
	 */
	@NotBlank(message = "负责跟进人名称不可为空")
	@ApiModelProperty(name = "handlerName", value = "负责跟进人名称(必填)", example = "李小二", allowEmptyValue = false)
	private String handlerName;

	public List<ReqOrdersAllotVO> getOrdersItemSn() {
		return OrdersItemSn;
	}

	public void setOrdersItemSn(List<ReqOrdersAllotVO> ordersItemSn) {
		OrdersItemSn = ordersItemSn;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getHandlerUid() {
		return handlerUid;
	}

	public void setHandlerUid(String handlerUid) {
		this.handlerUid = handlerUid;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public String toString() {
		return "ReqReserveOrdersAllotVO [OrdersItemSn=" + OrdersItemSn + ", deptCode=" + deptCode + ", handlerUid="
				+ handlerUid + ", handlerName=" + handlerName + "]";
	}
}