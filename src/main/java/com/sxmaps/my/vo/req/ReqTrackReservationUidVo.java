package com.sxmaps.mms.vo.req;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

/**
 * 推荐类型UID(推荐项目 级别 学校 专业 等)
 * 
 * @Author：hw
 * @Date:2018/4/10 下午4:38
 * @Description:
 */
public class ReqTrackReservationUidVo {

	@NotBlank(message = "咨询师UID不能为空")
	@ApiModelProperty(name = "consultantUid", value = "咨询师UID(必填)", example = "InQIcB+eTTuK/GPJk2uzRIDvfe0=", allowEmptyValue = false)
	private String consultantUid;

	public String getConsultantUid() {
		return consultantUid;
	}

	public void setConsultantUid(String consultantUid) {
		this.consultantUid = consultantUid;
	}

	@Override
	public String toString() {
		return "ReqTrackReservationUidVo [consultantUid=" + consultantUid + "]";
	}
}
