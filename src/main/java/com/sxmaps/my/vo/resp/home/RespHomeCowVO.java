package com.sxmaps.my.vo.resp.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

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

	//昨天
	/**
	 * 昨天新增死亡数
	 */
	@ApiModelProperty(name = "yesterdayAddDie", value = "昨天新增死亡数", example = "0")
	private Integer yesterdayAddDie;

	/**
	 * 昨天新增生病数
	 */
	@ApiModelProperty(name = "yesterdayAddIll", value = "昨天新增生病数", example = "0")
	private Integer yesterdayAddIll;

	/**
	 * 昨天新增治愈数
	 */
	@ApiModelProperty(name = "yesterdayAddCure", value = "昨天新增治愈数", example = "0")
	private Integer yesterdayAddCure;

	/**
	 * 昨天新增怀孕数
	 */
	@ApiModelProperty(name = "yesterdayAddFetation", value = "昨天新增怀孕数", example = "0")
	private Integer yesterdayAddFetation;

	/**
	 * 昨天新增出生数
	 */
	@ApiModelProperty(name = "yesterdayAddBirth", value = "昨天新增出生数", example = "0")
	private Integer yesterdayAddBirth;

	/**
	 * 昨天新增购买数
	 */
	@ApiModelProperty(name = "yesterdayAddBuy", value = "昨天新增购买数", example = "0")
	private Integer yesterdayAddBuy;
	/**
	 * 昨天新增售卖数
	 */
	@ApiModelProperty(name = "yesterdayAddSale", value = "昨天新增售卖数", example = "0")
	private Integer yesterdayAddSale;
// 总数
	/**
	 * 死亡总数
	 */
	private Integer die;

	/**
	 * 生病总数
	 */
	private Integer ill;

	/**
	 * 治愈总数
	 */
	private Integer cure;

	/**
	 * 售卖总数
	 */
	private Integer sale;

	/**
	 * 怀孕总数
	 */
	private Integer fetation;

	/**
	 * 出生总数
	 */
	private Integer birth;

	/**
	 * 购买总数
	 */
	private Integer buy;
}