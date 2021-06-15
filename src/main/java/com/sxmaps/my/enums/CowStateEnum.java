package com.sxmaps.my.enums;

/**
 * 类：牛生命状态
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/15
 */
public enum CowStateEnum {
    //    1：正常，2：怀孕，3：生病，4：死亡，5：售卖
    COWSTATEENUM_1(1, "正常"),
    COWSTATEENUM_2(2, "怀孕"),
    COWSTATEENUM_3(3, "生病"),
    COWSTATEENUM_4(4, "死亡"),
    COWSTATEENUM_5(5, "售卖"),

    ;

    private Integer state;
    private String desc;

    CowStateEnum(Integer state, String desc) {
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
}
