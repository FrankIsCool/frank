package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqStudentVO;

import io.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(description = "联系学员返回VO")
public class RespStudentVO extends ReqStudentVO implements Serializable {

	@Override
	public String toString() {
		return "RespStudentVO [getMemberId()=" + getMemberId() + ", getPhone()=" + getPhone() + ", getRecordId()="
				+ getRecordId() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
