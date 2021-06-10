package com.sxmaps.my.vo.req.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel(description = "牛修改基本信息请求对象")
public class ReqCowUpdateVO {

	@ApiModelProperty(value = "uid")
	@NotBlank(message = "uid不能为空")
	private String uid;

	@ApiModelProperty(value = "耳钉号")
	private String cowNum;

	@ApiModelProperty(value = "性别：1，公，2：母")
	private Integer sex;

	@ApiModelProperty(value = "母亲耳钉号")
	private String cowMonNum;

	@ApiModelProperty(value = "父亲耳钉号")
	private String cowFatherKind;

	@ApiModelProperty(value = "出生日期")
	private String cowBirth;

	@ApiModelProperty(value = "存栏日期")
	private Integer livestockTime;
}
