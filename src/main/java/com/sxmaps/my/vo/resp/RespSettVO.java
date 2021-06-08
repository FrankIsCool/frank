package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqSettingVO;

import io.swagger.annotations.ApiModel;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年4月12日
 */
@SuppressWarnings("serial")
@ApiModel(description = "类别请求返回VO")
public class RespSettVO extends ReqSettingVO implements Serializable {

	@Override
	public String toString() {
		return "RespSettVO [getUid()=" + getUid() + ", getOpName()=" + getOpName() + ", getCateId()=" + getCateId()
				+ ", getCateCode()=" + getCateCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
