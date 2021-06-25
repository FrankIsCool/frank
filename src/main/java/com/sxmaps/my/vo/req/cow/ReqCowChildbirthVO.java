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
@ApiModel(description = "牛分娩请求对象")
public class ReqCowChildbirthVO extends UserInfoVo {

	@ApiModelProperty(value = "牛Uid")
	@NotNull(message = "牛Uid不能为空")
	private Long cowUid;

	@ApiModelProperty(value = "耳钉号")
	@NotBlank(message = "耳钉号不能为空")
	private String cowNum;

	@ApiModelProperty(value = "性别：1，公，2：母")
	@NotNull(message = "性别不能为空")
	@Max(value = 2,message = "性别只能为：1，公，2：母")
	@Min(value = 1,message = "性别只能为：1，公，2：母")
	private Integer sex;

	@ApiModelProperty(value = "体重/市斤")
	private Integer weigth;

	@ApiModelProperty(value = "父亲耳钉号")
	private String cowFaNum;
}
