package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：性别枚举
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public enum SexEnum {
    MAN(1, "公"),
    WOMAN(2, "母"),

    ;

    private Integer state;
    private String desc;

    SexEnum(Integer state, String desc) {
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
    public static SexEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
