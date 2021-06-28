package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：功能类型
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/22
 */
public enum FunctionTypeEnum {
    FUNCTIONTYPE_1(1, "页面"),
    FUNCTIONTYPE_2(2, "功能"),
    FUNCTIONTYPE_3(3, "系统"),
    FUNCTIONTYPE_4(4, "菜单"),

    ;

    private Integer state;
    private String desc;

    FunctionTypeEnum(Integer state, String desc) {
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

    public static FunctionTypeEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
