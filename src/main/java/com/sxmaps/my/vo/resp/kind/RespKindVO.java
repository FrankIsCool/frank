package com.sxmaps.my.vo.resp.kind;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "种类列表返回实体类")
public class RespKindVO implements Serializable {

	@ApiModelProperty(name = "kindUid", value = "uid", example = "1")
	private Long kindUid;

	@ApiModelProperty(name = "kindName", value = "名称", example = "张三")
	private String kindName;

	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2021/8/21")
	private String createTime;

	@ApiModelProperty(name = "useKind", value = "使用变化", example = "2021/8/21")
	private List<String> useKind;
}