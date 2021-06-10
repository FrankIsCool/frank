package com.sxmaps.my.vo.req.cow;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "牛id请求对象")
public class ReqCowIdVO extends UserInfoVo {

	@ApiModelProperty(value = "uid")
	@NotBlank(message = "uid不能为空")
	private String uid;

}
