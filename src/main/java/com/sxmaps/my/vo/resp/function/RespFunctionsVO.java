package com.sxmaps.my.vo.resp.function;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 类：功能结构树
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/25
 */
@Data
@ApiModel(description = "用户功能返回实体类")
public class RespFunctionsVO implements Serializable {

    @ApiModelProperty(name = "functionSn", value = "功能编码", example = "1")
    private String functionSn;

    @ApiModelProperty(name = "functionName", value = "功能名称", example = "1")
    private String functionName;

    @ApiModelProperty(name = "funllName", value = "功能全称", example = "1")
    private String funllName;

    @ApiModelProperty(name = "functionPath", value = "功能地址", example = "1")
    private String functionPath;

    @ApiModelProperty(name = "functionType", value = "功能类型", example = "1")
    private Integer functionType;

    @ApiModelProperty(name = "remark", value = "功能备注", example = "1")
    private String remark;
}
