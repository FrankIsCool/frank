package com.sxmaps.mms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年3月23日
 */
@SuppressWarnings("serial")
@ApiModel(description = "预约单分配管理VO")
public class TrackReservationVO extends QueryInfoVO implements Serializable {

    /**
     * 预约分校ID
     */
    @ApiModelProperty(name = "uid", value = "预约单id")
    private String uid;

	/**
	 * 预约分校ID
	 */
	@ApiModelProperty(name = "schoolUid", value = "预约分校ID")
	private String schoolUid;

	/**
	 * 状态
	 */
	@ApiModelProperty(name = "state", value = "状态")
	private String state;
	
	@ApiModelProperty(name = "deptCoeds", value = "部门codeLIST")
	private List<String> deptCodes;
	@ApiModelProperty(name = "phone", value = "学员电话")
	private String phone;
	@ApiModelProperty(name = "userName", value = "学员姓名")
	private String userName;
	@ApiModelProperty(name = "reservationStartTime",value = "预约开始时间")
	private String reservationStartTime;
	@ApiModelProperty(name = "reservationEndTime",value = "预约结束时间")
	private String reservationEndTime;
	@ApiModelProperty(value = "状态列表",hidden = true)
	private List<String> stateList;
	public String getSchoolUid() {
		return schoolUid;
	}


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setSchoolUid(String schoolUid) {
		this.schoolUid = schoolUid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getDeptCodes() {
		return deptCodes;
	}

	public void setDeptCodes(List<String> deptCodes) {
		this.deptCodes = deptCodes;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(String reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public String getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(String reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	@Override
	public String toString() {
		return "TrackReservationVO [schoolUid=" + schoolUid + ", state=" + state + ", deptCodes=" + deptCodes
				+ ", phone=" + phone + ", userName=" + userName + ", reservationStartTime=" + reservationStartTime
				+ ", reservationEndTime=" + reservationEndTime + "]";
	}

}
