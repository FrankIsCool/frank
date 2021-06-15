package com.sxmaps.my.vo.req.user;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel(description = "子账户注销")
public class ReqUsersDelVO extends UserInfoVo {

	@ApiModelProperty(value = "子账户Uid")
	@NotBlank(message = "子账户Uid不能为空")
	private Long userUid;
}
