package com.sxmaps.my.vo.req.farmers;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "创建牧场")
public class ReqFarmersCreateVO extends UserInfoVo {

	@ApiModelProperty(value = "牧场名字")
	@NotBlank(message = "牧场名字不能为空")
	private String farmersName;

	@ApiModelProperty(value = "牧场所在地")
	@NotBlank(message = "牧场所在地不能为空")
	private String farmersAddress;

	@ApiModelProperty(value = "用户名")
	@NotBlank(message = "用户名不能为空")
	private String userName;

	@ApiModelProperty(value = "手机号")
	@NotBlank(message = "手机号不能为空")
	private String phone;

	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;
}
