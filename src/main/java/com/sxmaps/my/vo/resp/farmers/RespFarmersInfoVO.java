package com.sxmaps.my.vo.resp.farmers;

import com.franks.util.param.encrypt.annotation.PhoneEncrypt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "牧场详情")
public class RespFarmersInfoVO {

	@ApiModelProperty(value = "牧场uid")
	private Long farmersUid;

	@ApiModelProperty(value = "牧场名字")
	private String farmersName;

	@ApiModelProperty(value = "牧场地址")
	private String farmersAddress;

	@ApiModelProperty(value = "牧场创建日期")
	private Date farmersCreateTime;

	@ApiModelProperty(value = "牧场主uid")
	private Long farmersUserUid;

	@ApiModelProperty(value = "牧场主名字")
	private String farmersUserName;

	@ApiModelProperty(value = "牧场主手机号")
	@PhoneEncrypt
	private String farmersUserPhone;
}
