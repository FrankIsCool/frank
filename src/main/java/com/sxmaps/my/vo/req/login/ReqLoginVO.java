package com.sxmaps.my.vo.req.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(description = "登录请求对象")
public class ReqLoginVO {

	@ApiModelProperty(value = "账户名称/邮箱/手机号")
	@NotBlank(message = "账户名称/邮箱/手机号不能为空")
	private String userName;
	
	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;

	@ApiModelProperty(value = "是否记住密码，七天免登陆")
	private Boolean isRemember = false;
}
