package com.sxmaps.my.vo.req.user;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel(description = "用户列表信息")
public class ReqUserListVO extends QueryInfoVO {

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;
}
