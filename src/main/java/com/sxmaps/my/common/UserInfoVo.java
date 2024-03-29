package com.sxmaps.my.common;

import com.sxmaps.my.vo.resp.function.RespFunctionsVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * 类：当前登录人基本信息
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Data
@ApiModel(description = "当前登录人基本信息")
public class UserInfoVo {

    @ApiModelProperty(name = "token", value = "登录令牌", example = "143515325413254", hidden = true)
    private String token;

    @ApiModelProperty(name = "userName", value = "登录人名称", example = "张三", hidden = true)
    private String userName;

    @ApiModelProperty(name = "userUid", value = "登录人id", example = "1", hidden = true)
    private Long userUid;

    @ApiModelProperty(name = "farmersName", value = "牧场名称", example = "明远牧场", hidden = true)
    private String farmersName;

    @ApiModelProperty(name = "farmersUid", value = "牧场id", example = "1", hidden = true)
    private Long farmersUid;

    @ApiModelProperty(name = "validTime", value = "登录有效时间", example = "2021/5/20 5:30:30", hidden = true)
    private Date validTime;

    @ApiModelProperty(name = "userType", value = "登录人类型", example = "1", hidden = true)
    private Integer userType;

    @ApiModelProperty(name = "functionsMap", value = "登录人功能权限", example = "1", hidden = true)
    private Map<String, RespFunctionsVO> functionsMap;
}
