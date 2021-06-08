package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "用户返回vo")
public class RespUserVO implements Serializable {

	/**
	 * 用户姓名
	 */
	@ApiModelProperty("用户姓名")
	@Column(name = "user_name")
	private String userName;

	/**
	 * 部门ID
	 */
	@ApiModelProperty("部门ID")
	@Column(name = "dept_id")
	private String deptId;
	/**
	 * 部门名称
	 */
	@ApiModelProperty("部门名称")
	@Column(name = "dept_name")
	private String deptName;

	/**
	 * 父部门ID
	 */
	@ApiModelProperty("父部门ID")
	private String parentDetpId;
	/**
	 * 父部门名称
	 */
	@ApiModelProperty("父部门名称")
	private String parentDetpName;

	/**
	 * 用户状态(1启用，2禁用)
	 */
	@ApiModelProperty("用户状态(1启用，2禁用)")
	private Integer state;

	/**
	 * 性别(男:1，女:2)
	 */
	@ApiModelProperty("性别(男:1，女:2)")
	private Integer sex;

	/**
	 * 出生日期
	 */
	@ApiModelProperty(name = "birthday", value = "出生日期", example = "2018-02-02 12:22:22")
	private Date birthday;

	/**
	 * 办公室电话
	 */
	@ApiModelProperty("办公室电话")
	@Column(name = "office_phone")
	private String officePhone;

	/**
	 * 分机号
	 */
	@ApiModelProperty("分机号")
	@Column(name = "extension_phone")
	private String extensionPhone;

	/**
	 * 手机号号
	 */
	@ApiModelProperty("手机号")
	private String phone;
	/**
	 * 服务专业
	 */
	@ApiModelProperty("服务专业")
	@Column(name = "service_sector")
	private String serviceSector;

	/**
	 * 员工描述
	 */
	@ApiModelProperty("员工描述")
	private String descn;

	/**
	 * 电子邮箱
	 */
	@ApiModelProperty("电子邮箱")
	private String email;

	@ApiModelProperty("数据来源（0:默认;1:SHR）")
	private Integer source;
	/**
	 * 通讯地址
	 */
	@ApiModelProperty("通讯地址")
	private String address;

	/**
	 * 入职时间
	 */
	@ApiModelProperty("入职时间")
	private String enterdate;

	/**
	 * 用户所拥有的角色列表
	 */
	@ApiModelProperty("用户所拥有的角色列表")
	private List<AuthRole> roleList;
	/**
	 * 岗位id
	 */
	@ApiModelProperty("岗位id")
	@Column(name = "post_id")
	private String postId;
	/**
	 * 岗位名称
	 */
	@ApiModelProperty("岗位名称")
	@Column(name = "post_name")
	private String postName;
	/**
	 * 最后登录时间
	 */
	@ApiModelProperty(name = "lastSigninTime", value = "最后登录时间", example = "2018-02-02 12:22:22")
	@Column(name = "last_signin_time")
	private Date lastSigninTime;

	@ApiModelProperty(value = "用户token")
	private String token;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getParentDetpId() {
		return parentDetpId;
	}

	public void setParentDetpId(String parentDetpId) {
		this.parentDetpId = parentDetpId;
	}

	public String getParentDetpName() {
		return parentDetpName;
	}

	public void setParentDetpName(String parentDetpName) {
		this.parentDetpName = parentDetpName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getExtensionPhone() {
		return extensionPhone;
	}

	public void setExtensionPhone(String extensionPhone) {
		this.extensionPhone = extensionPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServiceSector() {
		return serviceSector;
	}

	public void setServiceSector(String serviceSector) {
		this.serviceSector = serviceSector;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}

	public List<AuthRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<AuthRole> roleList) {
		this.roleList = roleList;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Date getLastSigninTime() {
		return lastSigninTime;
	}

	public void setLastSigninTime(Date lastSigninTime) {
		this.lastSigninTime = lastSigninTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "RespUserVO [userName=" + userName + ", deptId=" + deptId + ", deptName=" + deptName + ", parentDetpId="
				+ parentDetpId + ", parentDetpName=" + parentDetpName + ", state=" + state + ", sex=" + sex
				+ ", birthday=" + birthday + ", officePhone=" + officePhone + ", extensionPhone=" + extensionPhone
				+ ", phone=" + phone + ", serviceSector=" + serviceSector + ", descn=" + descn + ", email=" + email
				+ ", source=" + source + ", address=" + address + ", enterdate=" + enterdate + ", roleList=" + roleList
				+ ", postId=" + postId + ", postName=" + postName + ", lastSigninTime=" + lastSigninTime + ", token="
				+ token + "]";
	}

}