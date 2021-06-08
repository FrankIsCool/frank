package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "隶属信息返回VO")
public class RespOrdersMemberVO implements Serializable {

	/**
	 * 班主任uid
	 */
	@ApiModelProperty(name = "teacherUid", value = "班主任uid")
	private String teacherUid;

	/**
	 * 分校接待老师uid
	 */
	@ApiModelProperty(name = "stationTeacherUid", value = "分校接待老师uid")
	private String stationTeacherUid;

	/**
	 * 前端咨询老师uid
	 */
	@ApiModelProperty(name = "sellerUid", value = "前端咨询老师uid")
	private String sellerUid;

	/**
	 * 前端电话咨询老师uid
	 */
	@ApiModelProperty(name = "callSellerUid", value = "前端电话咨询老师uid")
	private String callSellerUid;

	public String getTeacherUid() {
		return teacherUid;
	}

	public void setTeacherUid(String teacherUid) {
		this.teacherUid = teacherUid;
	}

	public String getStationTeacherUid() {
		return stationTeacherUid;
	}

	public void setStationTeacherUid(String stationTeacherUid) {
		this.stationTeacherUid = stationTeacherUid;
	}

	public String getSellerUid() {
		return sellerUid;
	}

	public void setSellerUid(String sellerUid) {
		this.sellerUid = sellerUid;
	}

	public String getCallSellerUid() {
		return callSellerUid;
	}

	public void setCallSellerUid(String callSellerUid) {
		this.callSellerUid = callSellerUid;
	}

	@Override
	public String toString() {
		return "RespOrdersMemberVO [teacherUid=" + teacherUid + ", stationTeacherUid=" + stationTeacherUid
				+ ", sellerUid=" + sellerUid + ", callSellerUid=" + callSellerUid + "]";
	}

}
