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
//  token
    PARAM("600", "参数异常"),
    PARAM_TOKEN("601", "token不能为空"),
    NOTVALID_TOKEN("601", "无效token"),
    PARAM_FUNCTION("602", "功能码不能为空"),
//  基础
    SAVE("5001", "保存数据失败"),
    UPDATE("5002", "修改数据失败"),
    SELECT("5003", "查询失败"),
    NOTSELECT("5004", "没有找到该数据"),
    DB("5005", "数据库异常"),

//    登录
    NOTUSER("5101", "账户不存在"),
    PASSWORDERROR("5102", "密码错误"),
    DELUSER("5103", "账户已注销"),
    NOTVALIDTIME("5104", "登录超时，请重新登录"),

//用户
    NOTUSERTYPE("5201", "不支持该用户类型"),
    NOTDELUSERTYPE("5202", "主账户不能注销"),
    NOTFARMERSUSER("5203", "非当前牧场账户，禁止修改"),

//牛
    NOTCOW("5301", "该牛只不存在"),
    COWNUM("5302", "该牛耳编号已存在"),
    NOTKIND("5303", "该种类不存在"),
    NOTGETCOW("5304", "该牛只不存在"),
    COWDIE("5305", "该牛只已死亡，不可编辑"),
    COWSALE("5305", "该牛只已售卖，不可编辑"),
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
