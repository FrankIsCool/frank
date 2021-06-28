package com.sxmaps.my.vo.req.earnings;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "收益详情列表实体类")
public class ReqEarningsListVO extends QueryInfoVO implements Serializable {

	@ApiModelProperty(name = "earningsTypeUid", value = "收益类型uid", example = "1")
	private Long earningsTypeUid;
}