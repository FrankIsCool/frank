package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：怀孕
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/15
 */
public enum CowFetationEnum {
    FETATION_1(1, "正常"),
    FETATION_2(2, "怀孕"),

    ;

    private Integer state;
    private String desc;

    CowFetationEnum(Integer state, String desc) {
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

    public static CowFetationEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
