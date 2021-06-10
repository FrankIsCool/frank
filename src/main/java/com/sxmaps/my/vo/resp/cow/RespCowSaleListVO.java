package com.sxmaps.my.vo.resp.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "牛死亡列表返回对象")
public class RespCowSaleListVO {

	@ApiModelProperty(value = "uid")
	private String cowUid;

	@ApiModelProperty(value = "耳钉号")
	private String cowNum;

	@ApiModelProperty(value = "性别：1，公，2：母")
	private Integer sex;

	@ApiModelProperty(value = "体重/市斤")
	private Integer weigth;

	@ApiModelProperty(value = "月龄")
	private Integer age;

	@ApiModelProperty(value = "母亲耳钉号")
	private String cowMonNum;

	@ApiModelProperty(value = "父亲耳钉号")
	private String cowFatherKind;

	@ApiModelProperty(value = "出生日期")
	private String cowBirth;

	@ApiModelProperty(value = "售卖时间")
	private String saleTime;

	@ApiModelProperty(value = "体重增长信息")
	private List<RespCowListWeigthVO>  weigthVOS;
}
