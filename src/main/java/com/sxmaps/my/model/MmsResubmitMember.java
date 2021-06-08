package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "mms_resubmit_member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MmsResubmitMember {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 学员ID
     */
    @Column(name = "member_uid")
    private String memberUid;

    /**
     * 姓名
     */
    @Column(name = "true_name")
    private String trueName;

    /**
     * 学员电话
     */
    @Column(name = "member_phone")
    private String memberPhone;

    /**
     * 报名时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 报名城市
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 学校id
     */
    @Column(name = "college_uid")
    private Long collegeUid;

    /**
     * 学校
     */
    @Column(name = "college_name")
    private String collegeName;

    /**
     * 专业id
     */
    @Column(name = "department_uid")
    private Long departmentUid;

    /**
     * 专业
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 级别id
     */
    @Column(name = "level_type_uid")
    private Long levelTypeUid;

    /**
     * 级别
     */
    @Column(name = "level_type_name")
    private String levelTypeName;

    /**
     * 班主任id
     */
    @Column(name = "teacher_uid")
    private String teacherUid;

    /**
     * 班主任
     */
    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * 分配状态
     */
    @Column(name = "distribution_state")
    private Integer distributionState;

    /**
     * 中端咨询师id
     */
    @Column(name = "consult_id")
    private String consultId;

    /**
     * 中端咨询师
     */
    @Column(name = "consult_name")
    private String consultName;

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
     * 学员类型
     */
    @Column(name = "member_type")
    private String memberType;
    
    /**
     * 第一次分配时间
     */
    @Column(name = "first_update_time")
    private Date firstUpdateTime;
    /**
     * 机会类型：1：续报:2：老带新 0：未知
     */
    @Column(name = "change_type")
    private Integer changeType;
    /**
     * 微信类型：1：已添加 2：未添加，0：未处理
     */
    @Column(name = "wx_chart")
    private Integer wxChart;

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Integer getWxChart() {
        return wxChart;
    }

    public void setWxChart(Integer wxChart) {
        this.wxChart = wxChart;
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
     * 获取学员ID
     *
     * @return member_uid - 学员ID
     */
    public String getMemberUid() {
        return memberUid;
    }

    /**
     * 设置学员ID
     *
     * @param memberUid 学员ID
     */
    public void setMemberUid(String memberUid) {
        this.memberUid = memberUid == null ? null : memberUid.trim();
    }

    /**
     * 获取姓名
     *
     * @return true_name - 姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 设置姓名
     *
     * @param trueName 姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    /**
     * 获取学员电话
     *
     * @return member_phone - 学员电话
     */
    public String getMemberPhone() {
        return memberPhone;
    }

    /**
     * 设置学员电话
     *
     * @param memberPhone 学员电话
     */
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    /**
     * 获取报名时间
     *
     * @return order_time - 报名时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置报名时间
     *
     * @param orderTime 报名时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取报名城市
     *
     * @return area_name - 报名城市
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置报名城市
     *
     * @param areaName 报名城市
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 获取学校id
     *
     * @return college_uid - 学校id
     */
    public Long getCollegeUid() {
        return collegeUid;
    }

    /**
     * 设置学校id
     *
     * @param collegeUid 学校id
     */
    public void setCollegeUid(Long collegeUid) {
        this.collegeUid = collegeUid;
    }

    /**
     * 获取学校
     *
     * @return college_name - 学校
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置学校
     *
     * @param collegeName 学校
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    /**
     * 获取专业id
     *
     * @return department_uid - 专业id
     */
    public Long getDepartmentUid() {
        return departmentUid;
    }

    /**
     * 设置专业id
     *
     * @param departmentUid 专业id
     */
    public void setDepartmentUid(Long departmentUid) {
        this.departmentUid = departmentUid;
    }

    /**
     * 获取专业
     *
     * @return department_name - 专业
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置专业
     *
     * @param departmentName 专业
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * 获取级别id
     *
     * @return level_type_uid - 级别id
     */
    public Long getLevelTypeUid() {
        return levelTypeUid;
    }

    /**
     * 设置级别id
     *
     * @param levelTypeUid 级别id
     */
    public void setLevelTypeUid(Long levelTypeUid) {
        this.levelTypeUid = levelTypeUid;
    }

    /**
     * 获取级别
     *
     * @return level_type_name - 级别
     */
    public String getLevelTypeName() {
        return levelTypeName;
    }

    /**
     * 设置级别
     *
     * @param levelTypeName 级别
     */
    public void setLevelTypeName(String levelTypeName) {
        this.levelTypeName = levelTypeName == null ? null : levelTypeName.trim();
    }

    /**
     * 获取班主任id
     *
     * @return teacher_uid - 班主任id
     */
    public String getTeacherUid() {
        return teacherUid;
    }

    /**
     * 设置班主任id
     *
     * @param teacherUid 班主任id
     */
    public void setTeacherUid(String teacherUid) {
        this.teacherUid = teacherUid == null ? null : teacherUid.trim();
    }

    /**
     * 获取班主任
     *
     * @return teacher_name - 班主任
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置班主任
     *
     * @param teacherName 班主任
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    /**
     * 获取分配状态
     *
     * @return distribution_state - 分配状态
     */
    public Integer getDistributionState() {
        return distributionState;
    }

    /**
     * 设置分配状态
     *
     * @param distributionState 分配状态
     */
    public void setDistributionState(Integer distributionState) {
        this.distributionState = distributionState;
    }

    /**
     * 获取中端咨询师id
     *
     * @return consult_id - 中端咨询师id
     */
    public String getConsultId() {
        return consultId;
    }

    /**
     * 设置中端咨询师id
     *
     * @param consultId 中端咨询师id
     */
    public void setConsultId(String consultId) {
        this.consultId = consultId == null ? null : consultId.trim();
    }

    /**
     * 获取中端咨询师
     *
     * @return consult_name - 中端咨询师
     */
    public String getConsultName() {
        return consultName;
    }

    /**
     * 设置中端咨询师
     *
     * @param consultName 中端咨询师
     */
    public void setConsultName(String consultName) {
        this.consultName = consultName == null ? null : consultName.trim();
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

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Date getFirstUpdateTime() {
		return firstUpdateTime;
	}

	public void setFirstUpdateTime(Date firstUpdateTime) {
		this.firstUpdateTime = firstUpdateTime;
	}

}