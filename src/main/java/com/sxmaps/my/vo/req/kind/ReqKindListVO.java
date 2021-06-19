package com.sxmaps.my.vo.req.kind;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "种类信息")
public class ReqKindListVO extends QueryInfoVO {

    @ApiModelProperty(value = "种类名称")
    private String kindName;

}
