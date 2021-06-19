package com.sxmaps.my.vo.req.kind;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(description = "新增种类信息")
public class ReqKindCreateVO extends UserInfoVo {

    @ApiModelProperty(value = "种类名称")
    @NotBlank(message = "种类名称不可为空")
    private String kindName;

}
