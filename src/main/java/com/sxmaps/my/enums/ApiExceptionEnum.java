package com.sxmaps.my.enums;

/**
 * 类：错误信息枚举
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
public enum ApiExceptionEnum {

    SAVE("5001", "保存数据失败"),
    UPDATE("5002", "修改数据失败");

    private String exceptionCode;
    private String exceptionDesc;

    ApiExceptionEnum(String exceptionCode, String exceptionDesc) {
        this.exceptionCode = exceptionCode;
        this.exceptionDesc = exceptionDesc;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDesc() {
        return exceptionDesc;
    }

    public void setExceptionDesc(String exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }
}
