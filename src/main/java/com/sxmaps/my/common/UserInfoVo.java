package com.sxmaps.my.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 类：当前登录人基本信息
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Data
@ApiModel(description = "当前登录人基本信息")
public class UserInfoVo {

    @ApiModelProperty(name = "token", value = "登录令牌", example = "143515325413254",hidden = true)
    private String token;

    @ApiModelProperty(name = "userName", value = "登录人名称", example = "张三",hidden = true)
    private String userName;

    @ApiModelProperty(name = "userUid", value = "登录人id", example = "1",hidden = true)
    private String userUid;

    @ApiModelProperty(name = "livestockName", value = "畜牧场名称", example = "明远牧场",hidden = true)
    private String livestockName;

    @ApiModelProperty(name = "livestockUide", value = "畜牧场id", example = "1",hidden = true)
    private String livestockUide;
}
