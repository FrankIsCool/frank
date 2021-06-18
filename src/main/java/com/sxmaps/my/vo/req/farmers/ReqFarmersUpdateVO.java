package com.sxmaps.my.vo.req.farmers;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(description = "牧场信息修改")
public class ReqFarmersUpdateVO extends UserInfoVo {

	@ApiModelProperty(value = "牧场名字")
	private String farmerName;

	@ApiModelProperty(value = "牧场地址")
	private String farmerAddress;

	@ApiModelProperty(value = "牧场创建日期")
	private Date farmerCreateTime;
}
