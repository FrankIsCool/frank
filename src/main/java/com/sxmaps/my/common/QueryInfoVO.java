package com.sxmaps.my.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 分页基础类
 *
 * @author chendehua
 */
@SuppressWarnings("serial")
@Data
@ApiModel(description = "分页基础类")
public class QueryInfoVO extends UserInfoVo implements Serializable {

    /**
     * 每页显示条数
     */
    @ApiModelProperty(name = "pageSige", value = "每页显示条数", example = "10")
    @NotNull(message = "pageSize参数不能为空")
    private transient Integer pageSize;
    /**
     * 页码
     */
    @ApiModelProperty(name = "pageNum", value = "页码", example = "1")
    @NotNull(message = "pageNum参数不能为空")
    private transient Integer pageNum;
}
