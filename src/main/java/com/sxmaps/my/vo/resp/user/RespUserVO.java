package com.sxmaps.my.vo.resp.user;

import com.franks.util.param.encrypt.annotation.PhoneEncrypt;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@ApiModel(description = "子账户返回实体类")
public class RespUserVO implements Serializable {

	@ApiModelProperty(name = "userUid", value = "uid", example = "1")
	private Long userUid;

	@ApiModelProperty(name = "userName", value = "名称", example = "张三")
	private String userName;

	@ApiModelProperty(name = "phone", value = "手机号", example = "15074446434")
	@PhoneEncrypt
	private String phone;

	@ApiModelProperty(name = "userType", value = "用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户", example = "1")
	private Integer userType;

	@ApiModelProperty(name = "del", value = "状态：1：正常 2：已删除", example = "1")
	private Integer del;

	@ApiModelProperty(name = "delDesc", value = "状态：1：正常 2：已删除", example = "1")
	private String delDesc;

	@ApiModelProperty(name = "userTypeDesc", value = "用户类型：1，商户主账号,2，商户子账户，3，系统主账户，4，系统子账户", example = "1")
	private String userTypeDesc;

	public void setDel(Integer del) {
		this.del = del;
		this.delDesc = StateEnum.getEnum(del).getDesc();
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
		this.userTypeDesc = UserTypeEnum.getEnum(userType).getDesc();
	}
}