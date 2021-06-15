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

	@ApiModelProperty(value = "牛Uid")
	@NotBlank(message = "牛Uid不能为空")
	private Long cowUid;

}
