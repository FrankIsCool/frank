package com.sxmaps.my.vo.resp.farmers;

import com.sxmaps.my.enums.StateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "牧场列表")
public class RespFarmersListVO {

	@ApiModelProperty(value = "牧场uid")
	private Long farmersUid;

	@ApiModelProperty(value = "牧场名字")
	private String farmersName;

	@ApiModelProperty(value = "牧场地址")
	private String farmersAddress;

	@ApiModelProperty(name = "del", value = "状态：1：正常 2：已删除", example = "1")
	private Integer del;

	@ApiModelProperty(name = "delDesc", value = "状态：1：正常 2：已删除", example = "1")
	private String delDesc;

	public void setDel(Integer del) {
		this.del = del;
		this.delDesc = StateEnum.getEnum(del).getDesc();
	}
}
