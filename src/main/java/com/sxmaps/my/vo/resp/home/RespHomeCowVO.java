package com.sxmaps.my.vo.resp.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "牛只总数返回实体类")
public class RespHomeCowVO implements Serializable {

//	存栏
	@ApiModelProperty(name = "cowLivestockNum", value = "存栏总数", example = "1")
	private Integer cowLivestockNum;

	@ApiModelProperty(name = "cowManCount", value = "存栏母牛数", example = "2021/8/21")
	private Integer cowManCount;

	@ApiModelProperty(name = "cowMonCount", value = "存栏公牛数", example = "2021/8/21")
	private Integer cowWomanCount;

//	总

	@ApiModelProperty(name = "cowCount", value = "总数", example = "1")
	private Integer cowCount;

	@ApiModelProperty(name = "cowIllCount", value = "生病数", example = "10")
	private Integer cowIllCount;

	@ApiModelProperty(name = "cowFetationCount", value = "怀孕数", example = "10")
	private Integer cowFetationCount;

	@ApiModelProperty(name = "cowDieCount", value = "死亡数", example = "10")
	private Integer cowDieCount;

	@ApiModelProperty(name = "cowSaleCount", value = "售卖数", example = "10")
	private Integer cowSaleCount;

	@ApiModelProperty(name = "cowNormalCount", value = "正常数", example = "2021/8/21")
	private Integer cowNormalCount;
}