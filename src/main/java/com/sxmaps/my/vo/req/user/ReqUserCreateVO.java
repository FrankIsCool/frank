package com.sxmaps.my.vo.req.user;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel(description = "创建用户信息")
public class ReqUserCreateVO extends UserInfoVo {

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户类型", hidden = true)
    private Integer type;
}
