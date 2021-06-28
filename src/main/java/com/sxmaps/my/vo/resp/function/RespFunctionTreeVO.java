package com.sxmaps.my.vo.resp.function;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类：功能结构树
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/25
 */
@Data
@ApiModel(description = "功能结构树返回实体类")
public class RespFunctionTreeVO implements Serializable {

    @ApiModelProperty(name = "functionUid", value = "功能uid", example = "1")
    private Long functionUid;

    @ApiModelProperty(name = "functionSn", value = "功能编码", example = "0001")
    private String functionSn;

    @ApiModelProperty(name = "functionName", value = "功能名称", example = "首页")
    private String functionName;

    @ApiModelProperty(name = "funllName", value = "功能名称路径", example = "首页")
    private String funllName;

    @ApiModelProperty(name = "functionPath", value = "功能url，或html url", example = "homepage.html")
    private String functionPath;

    @ApiModelProperty(name = "functionType", value = "功能类型：1：页面，2：功能", example = "1")
    private Integer functionType;

    @ApiModelProperty(name = "remark", value = "备注", example = "1")
    private String remark;

    @ApiModelProperty(name = "del", value = "状态：1：正常，2：已删除", example = "1")
    private Integer del;

    @ApiModelProperty(name = "childTree", value = "子树")
    private List<RespFunctionTreeVO> childTree;
}
