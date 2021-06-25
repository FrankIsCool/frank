package com.sxmaps.my.vo.resp.pay;

import com.sxmaps.my.enums.PayTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "支付类型列表实体类")
public class RespPayTypeListVO implements Serializable {

	@ApiModelProperty(name = "payTypeUid", value = "uid", example = "1")
	private Long payTypeUid;

	@ApiModelProperty(name = "payName", value = "名称", example = "张三")
	private String payName;

	@ApiModelProperty(name = "payType", value = "支付类型", example = "支付类型")
	private Integer payType;

	@ApiModelProperty(name = "payTypeDesc", value = "支付类型名称", example = "固定资产")
	private String payTypeDesc;

	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	private Date createTime;

	public String getPayTypeDesc() {
		return payTypeDesc = PayTypeEnum.getEnum(this.payType).getDesc();
	}
}