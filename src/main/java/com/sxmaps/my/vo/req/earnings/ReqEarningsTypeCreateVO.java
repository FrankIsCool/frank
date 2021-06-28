package com.sxmaps.my.vo.req.earnings;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "新增收益分类信息")
public class ReqEarningsTypeCreateVO extends UserInfoVo {

    @ApiModelProperty(value = "分类名称")
    @NotBlank(message = "分类名称不可为空")
    private String earningsName;
}
