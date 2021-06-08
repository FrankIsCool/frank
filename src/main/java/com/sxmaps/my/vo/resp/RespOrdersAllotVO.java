package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqReserveOrdersAllotVO;

import io.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(description = "请求预约单分配管理响应VO")
public class RespOrdersAllotVO extends ReqReserveOrdersAllotVO implements Serializable {

	@Override
	public String toString() {
		return "RespOrdersAllotVO [getOrdersItemSn()=" + getOrdersItemSn() + ", getDeptCode()=" + getDeptCode()
				+ ", getHandlerUid()=" + getHandlerUid() + ", getHandlerName()=" + getHandlerName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}