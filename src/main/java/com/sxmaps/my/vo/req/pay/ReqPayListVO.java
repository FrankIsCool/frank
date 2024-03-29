package com.sxmaps.my.vo.req.pay;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "支付详情列表实体类")
public class ReqPayListVO extends QueryInfoVO implements Serializable {

	@ApiModelProperty(name = "payTypeUid", value = "支付类型uid", example = "1")
	private Long payTypeUid;
}