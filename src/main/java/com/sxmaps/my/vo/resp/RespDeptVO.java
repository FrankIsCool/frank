package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class RespDeptVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long uid;

	/**
	 * 上级部门ID，一级部门为0
	 */
	@Column(name = "parent_uid")
	private Long parentUid;

	/**
	 * 上级部门名称
	 */
	@Column(name = "parent_name")
	private String parentName;

	/**
	 * 部门名称
	 */
	@Column(name = "dept_name")
	private String deptName;
	/**
	 * 子部门集合
	 */
	private List<RespDeptVO> childList;

	/**
	 * 当前部门下的用户集合
	 */
	private List<Object> userList;

	/**
	 * 排序
	 */
	@Column(name = "order_num")
	private Integer orderNum;

	/**
	 * 是否删除 -1：已删除 0：正常
	 */
	@Column(name = "del_flag")
	private Byte delFlag;

	/**
	 * ztree属性
	 */
	private boolean open;

	/**
	 * 创建时间
	 */
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 修改时间
	 */
	@Column(name = "update_date")
	private Date updateDate;

	/**
	 * 修改人
	 */
	@Column(name = "create_by")
	private String createBy;

	/**
	 * @return dept_uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param deptUid
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * 获取上级部门ID，一级部门为0
	 *
	 * @return parent_uid - 上级部门ID，一级部门为0
	 */
	public Long getParentUid() {
		return parentUid;
	}

	/**
	 * 设置上级部门ID，一级部门为0
	 *
	 * @param parentUid
	 *            上级部门ID，一级部门为0
	 */
	public void setParentUid(Long parentUid) {
		this.parentUid = parentUid;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * 获取部门名称
	 *
	 * @return name - 部门名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 设置部门名称
	 *
	 * @param name
	 *            部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	public List<RespDeptVO> getChildList() {
		return childList;
	}

	public void setChildList(List<RespDeptVO> childList) {
		this.childList = childList;
	}

	public List<Object> getUserList() {
		return userList;
	}

	public void setUserList(List<Object> userList) {
		this.userList = userList;
	}

	/**
	 * 获取排序
	 *
	 * @return order_num - 排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	/**
	 * 设置排序
	 *
	 * @param orderNum
	 *            排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 获取是否删除 -1：已删除 0：正常
	 *
	 * @return del_flag - 是否删除 -1：已删除 0：正常
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * 设置是否删除 -1：已删除 0：正常
	 *
	 * @param delFlag
	 *            是否删除 -1：已删除 0：正常
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_date - 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createDate
	 *            创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取修改时间
	 *
	 * @return update_date - 修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置修改时间
	 *
	 * @param updateDate
	 *            修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取修改人
	 *
	 * @return create_by - 修改人
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置修改人
	 *
	 * @param createBy
	 *            修改人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

}
