package com.sxmaps.my.vo.req.cow;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel(description = "牛id请求对象")
public class ReqCowSaleVO extends UserInfoVo {

	@ApiModelProperty(value = "牛Uid")
	@NotNull(message = "牛Uid不能为空")
	private Long cowUid;

	@ApiModelProperty(value = "售价")
	@NotNull(message = "售价不能为空")
	private BigDecimal saleAmount;
}
