package com.sxmaps.my.vo.req.farmers;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "牧场列表请求对象")
public class ReqFarmersListVO extends QueryInfoVO {

	@ApiModelProperty(value = "牧场名称")
	private String farmersName;

	@ApiModelProperty(value = "牧场状态")
	@Max(value = 2,message = "状态只能为：1，正常，2：已删除")
	@Min(value = 1,message = "状态只能为：1，正常，2：已删除")
	private Integer del;
}
