package com.sxmaps.my.vo.req.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "新增牛请求对象")
public class ReqCowCreateVO {

	@ApiModelProperty(value = "耳钉号")
	@NotBlank(message = "耳钉号不能为空")
	private String cowNum;
	
	@ApiModelProperty(value = "性别：1，公，2：母")
	@NotBlank(message = "性别不能为空")
	@Max(value = 2,message = "性别只能为：1，公，2：母")
	@Min(value = 1,message = "性别只能为：1，公，2：母")
	private Integer sex;

	@ApiModelProperty(value = "品种")
	private String cowKind;

	@ApiModelProperty(value = "体重/市斤")
	private Integer weigth;

	@ApiModelProperty(value = "母亲耳钉号")
	private String cowMonNum;

	@ApiModelProperty(value = "父亲耳钉号")
	private String cowFatherKind;

	@ApiModelProperty(value = "出生日期")
	private String cowBirth;
}
