package com.sxmaps.mms.vo.resp;

import javax.persistence.Column;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table(name = "auth_role")
@ApiModel(description = "角色vo")
public class AuthRole {

	/**
	 * 角色ID
	 */
	@ApiModelProperty("角色ID")
	@Column(name = "role_id")
	private String roleId;

	/**
	 * 角色名称
	 */
	@ApiModelProperty("角色名称")
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 角色描述
	 */
	@ApiModelProperty("角色描述")
	private String descn;

	/**
	 * 是否为负责人: 1:是 ,0:否
	 */
	@ApiModelProperty("是否为负责人: 1:是 ,0:否")
	private Integer manager;

	/**
	 * 状态: 1:正常 ,2:停用
	 */
	@ApiModelProperty("状态: 1:正常 ,2:停用")
	private Integer status;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AuthRole [roleId=" + roleId + ", roleName=" + roleName + ", descn=" + descn + ", manager=" + manager
				+ ", status=" + status + "]";
	}

}