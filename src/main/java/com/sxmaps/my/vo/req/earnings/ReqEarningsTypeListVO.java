package com.sxmaps.my.vo.req.earnings;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "收益分类信息")
public class ReqEarningsTypeListVO extends QueryInfoVO {

    @ApiModelProperty(value = "收益分类名称")
    private String earningsName;

}
