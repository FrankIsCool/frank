package com.sxmaps.my.vo.resp.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "牛体重返回实体类")
public class RespCowListWeigthVO {

	@ApiModelProperty(value = "牛只uid")
	private Long cowUid;

	@ApiModelProperty(value = "体重/市斤")
	private Integer weigth;

	@ApiModelProperty(value = "创建日期")
	private String createTime;

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
