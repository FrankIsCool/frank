package com.sxmaps.my.vo.req.cow;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "新增牛体重请求对象")
public class ReqCowCreateWeightVO extends UserInfoVo {

	@ApiModelProperty(value = "牛id")
	@NotBlank(message = "牛id不能为空")
	private String cowUid;

	@ApiModelProperty(value = "体重/市斤")
	@NotBlank(message = "体重不能为空")
	private Integer weigth;

	@ApiModelProperty(value = "测量日期")
	private String measureTime;
}
