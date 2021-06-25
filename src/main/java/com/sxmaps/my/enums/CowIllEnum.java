package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：生病
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/15
 */
public enum CowIllEnum {
    ILL_1(1, "正常"),
    ILL_2(2, "生病"),

    ;

    private Integer state;
    private String desc;

    CowIllEnum(Integer state, String desc) {
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

    public static CowIllEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
