package com.sxmaps.my.vo.req.cow;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(description = "新增牛体重请求对象")
public class ReqCowCreateWeightVO extends UserInfoVo {

	@ApiModelProperty(value = "牛id")
	@NotNull(message = "牛id不能为空")
	private Long cowUid;

	@ApiModelProperty(value = "体重/市斤")
	@NotNull(message = "体重不能为空")
	private Integer weigth;

	@ApiModelProperty(value = "测量日期")
	private Date measureTime;
}
