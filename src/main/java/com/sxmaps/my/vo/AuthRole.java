package com.sxmaps.mms.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table(name = "auth_role")
@ApiModel(description="角色vo")
public class AuthRole {
    /**
     * 角色ID
     */
	@Id
    @ApiModelProperty(value="角色ID",name = "roleId",example="12", required = true)
    @Column(name = "role_id")
    private String roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value="角色名称",name = "roleName",example="班主任", required = true)
    @Column(name = "role_name")
    private String roleName;
    
    
    
    /**
     * 角色描述
     */
    @ApiModelProperty(value="角色描述",name = "descn",example="一班负责人", required = false)
    private String descn;

    /**
     * 状态: 1:正常 ,2:停用
     */
    @ApiModelProperty(value="状态: 1:正常 ,2:停用",name = "state",example="1", required = true)
    private Integer state;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色描述
     *
     * @return descn - 角色描述
     */
    public String getDescn() {
        return descn;
    }

    /**
     * 设置角色描述
     *
     * @param descn 角色描述
     */
    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }



    /**
     * 获取状态: 1:正常 ,2:停用
     *
     * @return state - 状态: 1:正常 ,2:停用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态: 1:正常 ,2:停用
     *
     * @param state 状态: 1:正常 ,2:停用
     */
    public void setState(Integer state) {
        this.state = state;
    }
 
}