package com.sxmaps.my.vo.resp.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "支出统计实体类")
public class RespPayCollectVO implements Serializable {

    @ApiModelProperty(name = "amountAll", value = "总支出", example = "1100.00")
    private BigDecimal amountAll = BigDecimal.ZERO;

    @ApiModelProperty(name = "info", value = "统计明细")
    private List<RespPayCollectInfoVO> info;

    public void setInfo(List<RespPayCollectInfoVO> info) {
        this.info = info;
        info.stream().forEach(respPayCollectInfoVO -> {
            this.amountAll = this.amountAll.add(respPayCollectInfoVO.getPayAmount());
        });
    }
}