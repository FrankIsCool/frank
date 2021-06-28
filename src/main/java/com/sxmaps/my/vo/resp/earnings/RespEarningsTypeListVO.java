package com.sxmaps.my.vo.resp.earnings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "收益类型列表实体类")
public class RespEarningsTypeListVO implements Serializable {

	@ApiModelProperty(name = "earningsTypeUid", value = "uid", example = "1")
	private Long earningsTypeUid;

	@ApiModelProperty(name = "earningsName", value = "名称", example = "张三")
	private String earningsName;

	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	private Date createTime;
}