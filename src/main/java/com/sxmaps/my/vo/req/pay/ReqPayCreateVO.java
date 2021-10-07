package com.sxmaps.my.vo.req.pay;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel(description = "新增支付信息")
public class ReqPayCreateVO extends UserInfoVo {

    @ApiModelProperty(value = "支付金额")
    @NotNull(message = "支付金额不可为空")
    private BigDecimal amount;

    @ApiModelProperty(value = "支付类型")
    @NotNull(message = "支付类型不可为空")
    private Long payTypeUid;

}
