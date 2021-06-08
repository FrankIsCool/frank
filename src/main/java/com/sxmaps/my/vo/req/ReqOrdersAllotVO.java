package com.sxmaps.mms.vo.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(description = "预约单号管理VO")
public class ReqOrdersAllotVO implements Serializable {
	/**
	 * 预约单uid
	 */
	@NotNull(message = "预约单uid不可为空")
	@ApiModelProperty(name = "reservationUid", value = "预约单uid(必填)", example = "1", allowEmptyValue = false)
	private Long reservationUid;

	public Long getReservationUid() {
		return reservationUid;
	}

	public void setReservationUid(Long reservationUid) {
		this.reservationUid = reservationUid;
	}

	@Override
	public String toString() {
		return "ReqOrdersAllotVO [reservationUid=" + reservationUid + "]";
	}

}
