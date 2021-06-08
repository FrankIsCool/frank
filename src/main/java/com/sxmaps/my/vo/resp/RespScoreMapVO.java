package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqScoreOpinionMapVO;

import io.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(description = "星级点评信息管理VO")
public class RespScoreMapVO extends ReqScoreOpinionMapVO implements Serializable {

	@Override
	public String toString() {
		return "RespScoreMapVO [getScoreUid()=" + getScoreUid() + ", getOpinionList()=" + getOpinionList()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}