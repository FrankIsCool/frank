package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="部门id VO")
public class DeptIdVO implements Serializable{
	/**
}
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="deptId",notes="角色名称",required=true)
	@NotNull(message="部门ID不能为空")
	private String deptId;
	/**
	 * 用户姓名
	 */
	@ApiModelProperty(name="name",notes="用户姓名",required=false)
	private String name;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
