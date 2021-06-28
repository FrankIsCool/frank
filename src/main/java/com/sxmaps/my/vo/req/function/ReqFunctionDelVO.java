package com.sxmaps.my.vo.req.function;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "删除功能信息")
public class ReqFunctionDelVO extends UserInfoVo {

    @ApiModelProperty(value = "uid")
    @NotNull(message = "uid不可为空")
    private Long functionUid;
}
