package com.sxmaps.my.enums;

/**
 * 类：异常信息枚举
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
public enum ApiExceptionEnum {
    SUCCESS("200", "SUCCESS"),

    NOTFOUND("404", "没有找到该接口"),

    EXCEPTION("500", "服务异常"),

    PARAM("600", "参数异常"),
    PARAM_TOKEN("601", "token不能为空"),

    SAVE("5001", "保存数据失败"),
    UPDATE("5002", "修改数据失败"),
    SELECT("5003", "查询失败"),
    NOTSELECT("5004", "没有找到该数据"),
    DB("5005", "数据库异常"),

    ;

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
