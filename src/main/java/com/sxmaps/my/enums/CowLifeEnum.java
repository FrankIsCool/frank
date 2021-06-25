package com.sxmaps.my.enums;

import java.util.stream.Stream;

/**
 * 类：牛生命状态
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/15
 */
public enum CowLifeEnum {
    //    1：正常，2：死亡，3：售卖
    LIFE_1(1, "正常"),
    LIFE_2(2, "死亡"),
    LIFE_3(3, "售卖")

    ;

    private Integer state;
    private String desc;

    CowLifeEnum(Integer state, String desc) {
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

    public static CowLifeEnum getEnum(Integer value) {
        return Stream.of(values()).filter(p -> p.getState().equals(value)).findFirst().orElse(null);
    }
}
