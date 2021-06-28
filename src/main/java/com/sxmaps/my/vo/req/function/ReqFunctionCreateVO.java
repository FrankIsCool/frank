package com.sxmaps.my.vo.req.function;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "新增功能信息")
public class ReqFunctionCreateVO extends UserInfoVo {

    @ApiModelProperty(value = "父级uid")
    @NotNull(message = "父级uid不可为空")
    private Long fatherUid;

    @ApiModelProperty(value = "功能名称")
    @NotBlank(message = "功能名称不可为空")
    private String functionName;

    @ApiModelProperty(value = "功能编码")
    @NotBlank(message = "功能编码不可为空")
    private String functionSn;

    @ApiModelProperty(value = "功能类型")
    @NotNull(message = "功能类型不可为空")
    private Integer functionType;

    @ApiModelProperty(value = "功能地址")
    private String functionPath;

    @ApiModelProperty(value = "备注")
    @NotNull(message = "备注不可为空")
    private String remark;
}
