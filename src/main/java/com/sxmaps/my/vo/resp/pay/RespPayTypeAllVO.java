package com.sxmaps.my.vo.resp.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "返回所有支付类型实体类")
public class RespPayTypeAllVO implements Serializable {

	@ApiModelProperty(name = "payTypeUid", value = "uid", example = "1")
	private Long payTypeUid;

	@ApiModelProperty(name = "payName", value = "名称", example = "张三")
	private Integer payName;

	@ApiModelProperty(name = "payType", value = "支付类型", example = "支付类型")
	private String payType;
}