package com.sxmaps.mms.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年4月12日
 */
@SuppressWarnings("serial")
@ApiModel(description = "类别请求返回VO")
public class RespStudentListVO implements Serializable {
	/**
	 * id
	 */
	@ApiModelProperty(name = "uid", value = "主键ID", example = "1")
	private Long uid;

	/**
	 * 会员id
	 */
	@ApiModelProperty(name = "memberId", value = "会员id", example = "xhzyl123456")
	private String memberId;

	/**
	 * 手机号
	 */
	@ApiModelProperty(name = "phone", value = "手机号", example = "13456896532")
	private String phone;

	/**
	 * 记录id
	 */
	@ApiModelProperty(name = "recordId", value = "记录id", example = "1000")
	private String recordId;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2018-05-02 12:33:55")
	private Date createTime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "RespStudentListVO [uid=" + uid + ", memberId=" + memberId + ", phone=" + phone + ", recordId="
				+ recordId + ", createTime=" + createTime + "]";
	}

}
