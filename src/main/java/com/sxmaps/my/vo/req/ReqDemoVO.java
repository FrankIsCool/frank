package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

/**
 * 测试Demo请求对象
 * 
 * @author chendehua
 *
 */
@SuppressWarnings("serial")
public class ReqDemoVO implements Serializable {

	@NotBlank(message = "acount参数不可为空")
	@ApiModelProperty(name = "acount", value = "账号", example = "test", allowEmptyValue = false)
	private String acount;

	@NotBlank(message = "pwd参数不可为空")
	@ApiModelProperty(name = "pwd", value = "密码", example = "test", allowEmptyValue = false)
	private String pwd;

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "ReqDemoVO [acount=" + acount + ", pwd=" + pwd + "]";
	}

}
