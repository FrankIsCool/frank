package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqOpinionVO;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "评价请求管理VO")
@SuppressWarnings("serial")
public class RespOpinionVO extends ReqOpinionVO implements Serializable {

	@Override
	public String toString() {
		return "RespOpinionVO [getUid()=" + getUid() + ", getViews()=" + getViews() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
