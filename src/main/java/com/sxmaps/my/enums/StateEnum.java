package com.sxmaps.my.enums;

/**
 * 类：状态枚举
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public enum StateEnum {
    NOTDEL(1, "有效"),
    DEL(2, "已删除"),

    ;

    private Integer state;
    private String desc;

    StateEnum(Integer state, String desc) {
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
