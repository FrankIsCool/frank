package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：支付类型
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/22
 */
public enum PayTypeEnum {
    PayType_1(1, "消耗品"),
    PayType_2(2, "固定资产"),

    ;

    private Integer state;
    private String desc;

    PayTypeEnum(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static PayTypeEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
