package com.sxmaps.my.vo.req.pay;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "新增支付分类信息")
public class ReqPayTypeCreateVO extends UserInfoVo {

    @ApiModelProperty(value = "分类名称")
    @NotBlank(message = "分类名称不可为空")
    private String payName;

    @ApiModelProperty(value = "分类名称")
    @NotNull(message = "分类名称不可为空")
    private Integer payType;

}
