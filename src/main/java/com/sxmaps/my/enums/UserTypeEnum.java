package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：用户类型
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public enum UserTypeEnum {
    USERTYP_1(1,"商户主账号"),
    USERTYP_2(2,"商户子账户"),
    USERTYP_3(3,"系统主账户"),
    USERTYP_4(4,"系统子账户"),

            ;

    private Integer state;
    private String desc;

    UserTypeEnum(Integer state, String desc) {
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

    public static UserTypeEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
