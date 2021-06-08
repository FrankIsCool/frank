package com.sxmaps.mms.vo.req;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sxmaps.mms.vo.ReqMemberTypeVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "新增回访记录VO")
@Data
public class ReqCallBackVO {
	
	@ApiModelProperty("uid")
	@NotNull(message = "uid不能为空")
	private Long resubmitUid;

    /**
     * 下次回访时间
     */
	@ApiModelProperty(value = "下次回访时间")
	@NotBlank(message = "下次回访时间不能为空")
    private String nextCallTime;

    /**
     * 回访内容
     */
	@ApiModelProperty(value = "回访内容")
	@NotBlank(message = "回访内容不能为空")
    private String callRecord;

	/**
	 * 微信状态
	 */
	@ApiModelProperty(value = "微信状态：1：已添加 2：未添加")
	@NotBlank(message = "微信状态不能为空")
	private Integer wxChart;
	/**
	 * 机会类型
	 */
	@ApiModelProperty(value = "机会类型：1：续报:2：老带新")
	private Integer changeType;
}
