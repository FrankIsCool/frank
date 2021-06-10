package com.sxmaps.my.vo.req.cow;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Data
@ApiModel(description = "牛售卖请求对象")
public class ReqCowSaleVO extends UserInfoVo {

	@ApiModelProperty(value = "uid")
	@NotBlank(message = "uid不能为空")
	private String uid;

	@ApiModelProperty(value = "售卖金额")
	private BigDecimal saleAmount;

	@ApiModelProperty(value = "售卖体重")
	private Integer weigth;
}
