package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import com.sxmaps.mms.vo.req.ReqCampusVO;

import io.swagger.annotations.ApiModel;

@SuppressWarnings("serial")
@ApiModel(description = "分校请求响应VO")
public class RespCampuVO extends ReqCampusVO implements Serializable {

	@Override
	public String toString() {
		return "RespCampuVO [getUid()=" + getUid() + ", getDeptCode()=" + getDeptCode() + ", getDeptName()="
				+ getDeptName() + ", getCampusName()=" + getCampusName() + ", getPhone()=" + getPhone()
				+ ", getPhoto()=" + getPhoto() + ", getProvinceCode()=" + getProvinceCode() + ", getProvinceName()="
				+ getProvinceName() + ", getCityCode()=" + getCityCode() + ", getCityName()=" + getCityName()
				+ ", getCountyCode()=" + getCountyCode() + ", getCountyName()=" + getCountyName() + ", getStreet()="
				+ getStreet() + ", getCoordinate()=" + getCoordinate() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
