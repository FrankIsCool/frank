package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqCategoryVO;

import io.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(description = "类型管理VO")
public class RespCateVO extends ReqCategoryVO implements Serializable {

	@Override
	public String toString() {
		return "RespCateVO [getUid()=" + getUid() + ", getCateName()=" + getCateName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}