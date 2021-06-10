package com.sxmaps.my.vo.req.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "牛详情请求对象")
public class ReqCowInfoVO {

	@ApiModelProperty(value = "uid")
	@NotBlank(message = "uid不能为空")
	private String uid;

}
