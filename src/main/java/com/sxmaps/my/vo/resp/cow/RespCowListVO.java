package com.sxmaps.my.vo.resp.cow;

import com.sxmaps.my.enums.CowStateEnum;
import com.sxmaps.my.enums.SexEnum;
import com.sxmaps.my.utils.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(description = "牛列表返回对象")
public class RespCowListVO {

	@ApiModelProperty(value = "uid")
	private Long cowUid;

	@ApiModelProperty(value = "耳钉号")
	private String cowNum;

	@ApiModelProperty(value = "性别：1，公，2：母")
	private Integer sex;

	@ApiModelProperty(value = "性别：1，公，2：母")
	private String sexDesc;

	@ApiModelProperty(value = "体重/市斤")
	private Integer weigth;

	@ApiModelProperty(value = "月龄")
	private String lairageAge;

	@ApiModelProperty(value = "母亲耳钉号")
	private String cowMonNum;

	@ApiModelProperty(value = "父亲耳钉号")
	private String cowFatherKind;

	@ApiModelProperty(value = "出生日期")
	private String cowBirth;

	@ApiModelProperty(value = "喂养日期")
	private String lairageTime;

	@ApiModelProperty(value = "生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖")
	private Integer cowState;

	@ApiModelProperty(value = "生命状态：1：正常，2：怀孕，3：生病，4：死亡，5：售卖")
	private String cowStateDesc;

	@ApiModelProperty(value = "体重增长信息")
	private List<RespCowListWeigthVO>  weigthVOS;

	public void setCowState(Integer cowState) {
		this.cowState = cowState;
		this.cowStateDesc = CowStateEnum.getEnum(cowState).getDesc();
	}

	public void setSex(Integer sex) {
		this.sex = sex;
		this.sexDesc = SexEnum.getEnum(sex).getDesc();
	}

	public void setCowBirth(String cowBirth) {
		this.cowBirth = DateUtil.toString(DateUtil.toDate(cowBirth,DateUtil.FORMAT_DATE),DateUtil.FORMAT_DATE);
	}

	public void setLairageTime(String lairageTime) {
		this.lairageTime = lairageTime;
		this.lairageAge = DateUtil.dateDiff(lairageTime,DateUtil.dateToStrLong(new Date()),DateUtil.DAY_MONTH_YEAR);
	}
}
