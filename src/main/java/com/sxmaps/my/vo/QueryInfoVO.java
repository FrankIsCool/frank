package com.sxmaps.my.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 模糊查询基类
 * 
 * @author chendehua
 *
 */
@SuppressWarnings("serial")
@ApiModel("QueryInfoVO")
public class QueryInfoVO implements Serializable {

	/**
	 * 每页显示条数
	 */
	@ApiModelProperty(name = "pageSige", value = "每页显示条数", example = "10")
	@NotNull(message = "pageSize参数不能为空")
	private transient Integer pageSize;
	/**
	 * 页码
	 */
	@ApiModelProperty(name = "pageNum", value = "页码", example = "1")
	@NotNull(message = "pageNum参数不能为空")
	private transient Integer pageNum;
	
	@ApiModelProperty(name = "startTime", value = "开始时间", example = "2018-02-02")
	private String startTime;

	 /**
	  * 结束时间
	  */
	 @ApiModelProperty(name = "endTime", value = "结束时间", example = "2018-02-02")
	 private String endTime;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "QueryInfoVO []";
	}

}
