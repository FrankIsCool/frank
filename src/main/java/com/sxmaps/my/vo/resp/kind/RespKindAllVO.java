package com.sxmaps.my.vo.resp.kind;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "返回所有种类实体类")
public class RespKindAllVO implements Serializable {

	@ApiModelProperty(name = "kindUid", value = "uid", example = "1")
	private Long kindUid;

	@ApiModelProperty(name = "kindName", value = "名称", example = "张三")
	private String kindName;
}