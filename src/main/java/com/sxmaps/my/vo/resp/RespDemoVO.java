package com.sxmaps.mms.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 测试Demo返回对象
 * 
 * @author chendehua
 *
 */
@SuppressWarnings("serial")
public class RespDemoVO implements Serializable {

	@ApiModelProperty(name = "name", value = "姓名", example = "test")
	private String name;

	@ApiModelProperty(name = "age", value = "姓名", example = "21")
	private int age;

	@ApiModelProperty(name = "sex", value = "性别", example = "MALE")
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "RespDemoVO [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
