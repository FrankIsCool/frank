package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "联系学员入参VO")
public class ReqStudentVO implements Serializable {

	/**
	 * 会员id
	 */
	@ApiModelProperty(name = "memberId", value = "会员id", example = "123")
	private String memberId;

	/**
	 * 手机号
	 */
	@ApiModelProperty(name = "phone", value = "手机号", example = "13465985236")
	private String phone;

	/**
	 * 记录id
	 */
	@NotBlank(message = "记录id不可为空")
	@ApiModelProperty(name = "recordId", value = "记录id(必填)", example = "456", allowEmptyValue = false)
	private String recordId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Override
	public String toString() {
		return "ReqStudentVO [memberId=" + memberId + ", phone=" + phone + ", recordId=" + recordId + "]";
	}

}
