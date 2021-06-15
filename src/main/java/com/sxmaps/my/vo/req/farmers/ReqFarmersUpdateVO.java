package com.sxmaps.my.vo.req.farmers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "牧场信息修改")
public class ReqFarmersUpdateVO {

	@ApiModelProperty(value = "牧场uid")
	@NotNull(message = "牧场uid不能为空")
	private Long farmersUid;

	@ApiModelProperty(value = "牧场名字")
	private String farmersName;

	@ApiModelProperty(value = "牧场地址")
	private String farmersAddress;
}
