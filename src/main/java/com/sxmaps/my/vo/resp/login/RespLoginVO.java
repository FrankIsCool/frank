package com.sxmaps.my.vo.resp.login;

import com.sxmaps.my.vo.resp.function.RespFunctionsVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "登录返回实体类")
public class RespLoginVO implements Serializable {

	@ApiModelProperty(name = "token", value = "登录令牌", example = "143515325413254")
	private String token;

	@ApiModelProperty(name = "userName", value = "登录人名称", example = "张三")
	private String userName;

	@ApiModelProperty(name = "farmersName", value = "牧场名称", example = "明远牧场")
	private String farmersName;

	@ApiModelProperty(name = "functionsVOS", value = "用户对应的功能集合")
	private List<RespFunctionsVO> functionsVOS;
}