package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "协议管理入参VO")
public class ReqProtocolLevelVO implements Serializable {

	@ApiModelProperty(name = "itemId", value = "子订单ID", example = "222", allowEmptyValue = true)
	private String itemId;

	@NotBlank(message = "层级ID不可为空")
	@ApiModelProperty(name = "levelId", value = "层级ID", example = "222", allowEmptyValue = false)
	private String levelId;

	@ApiModelProperty(value = "商品ID", example = "97", allowEmptyValue = true)
	private String productUid;

	@ApiModelProperty(value = "班型ID", example = "4", allowEmptyValue = true)
	private String classTypeUid;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getProductUid() {
		return productUid;
	}

	public void setProductUid(String productUid) {
		this.productUid = productUid;
	}

	public String getClassTypeUid() {
		return classTypeUid;
	}

	public void setClassTypeUid(String classTypeUid) {
		this.classTypeUid = classTypeUid;
	}

	@Override
	public String toString() {
		return "ReqProtocolLevelVO [itemId=" + itemId + ", levelId=" + levelId + ", productUid=" + productUid
				+ ", classTypeUid=" + classTypeUid + "]";
	}

}
