package com.sxmaps.my.vo.req.pay;

import com.sxmaps.my.common.UserInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "请求支付列表实体类")
public class ReqPayCollectVO extends UserInfoVo implements Serializable {

	@ApiModelProperty(name = "payType", value = "支付类型", example = "支付类型")
	@NotNull(message = "支付类型不能为空")
	private Integer payType;

	@ApiModelProperty(name = "payTypeUids", value = "支付类型uid", example = "1",hidden = true)
	private List<Long> payTypeUids;
}