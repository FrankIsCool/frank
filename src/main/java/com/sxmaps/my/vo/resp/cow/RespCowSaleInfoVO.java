package com.sxmaps.my.vo.resp.cow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "牛死亡详情返回对象")
public class RespCowSaleInfoVO {

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

	@ApiModelProperty(value = "存栏月数")
	private Integer livestockNum;

	@ApiModelProperty(value = "母亲耳钉号")
	private String cowMonNum;

	@ApiModelProperty(value = "父亲耳钉号")
	private String cowFatherKind;

	@ApiModelProperty(value = "出生日期")
	private String cowBirth;

	@ApiModelProperty(value = "存栏日期")
	private Integer livestockTime;

	@ApiModelProperty(value = "售卖时间")
	private String saleTime;

	@ApiModelProperty(value = "体重增长信息")
	private List<RespCowListWeigthVO>  weigthVOS;

	@ApiModelProperty(value = "生病历史信息")
	private List<RespCowListWeigthVO>  illVOS;

	@ApiModelProperty(value = "繁殖信息")
	private List<RespCowListWeigthVO>  breedVOS;
}
