package com.sxmaps.my.vo.req.cow;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "牛售卖分页请求对象")
public class ReqCowSaleListVO extends QueryInfoVO {

	@ApiModelProperty(value = "耳钉号")
	private String cowNum;

	@ApiModelProperty(value = "性别：1，公，2：母")
	@Max(value = 2,message = "性别只能为：1，公，2：母")
	@Min(value = 1,message = "性别只能为：1，公，2：母")
	private Integer sex;
}
