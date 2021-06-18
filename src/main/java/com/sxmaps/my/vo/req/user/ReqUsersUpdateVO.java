package com.sxmaps.my.vo.req.user;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "子账户uid")
public class ReqUsersUpdateVO extends UserInfoVo {

	@ApiModelProperty(value = "主账号Uid")
	@NotNull(message = "主账号Uid不能为空")
	private Long uid;

	@ApiModelProperty(value = "用户名")
	private String name;

	@ApiModelProperty(value = "手机号")
	private String phone;
}
