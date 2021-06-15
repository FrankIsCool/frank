package com.sxmaps.my.vo.req.farmers;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel(description = "注销牧场")
public class ReqFarmersDelVO extends UserInfoVo {

	@ApiModelProperty(value = "牧场uid")
	@NotBlank(message = "牧场uid不能为空")
	private Long farmersUid;
}
