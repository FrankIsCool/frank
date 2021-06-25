package com.sxmaps.my.vo.req.pay;

import com.sxmaps.my.common.QueryInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "支付分类信息")
public class ReqPayTypeListVO extends QueryInfoVO {

    @ApiModelProperty(value = "支付分类名称")
    private String payTypeName;

}
