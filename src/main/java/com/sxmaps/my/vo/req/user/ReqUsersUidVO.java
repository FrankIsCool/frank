package com.sxmaps.my.vo.req.user;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "子账户uid")
public class ReqUsersUidVO extends UserInfoVo {

	@ApiModelProperty(value = "子账户Uid")
	@NotNull(message = "子账户Uid不能为空")
	private Long uid;
}
