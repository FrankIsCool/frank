package com.sxmaps.my.common;

import com.sxmaps.my.enums.ApiExceptionEnum;
import lombok.Data;

/**
 * 类：统一返回对象
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
@Data
public class JsonMessage<T> {
    //状态码
    private String code;
    //错误信息
    private String text;
    //返回结果集
    private T data;

    public JsonMessage(String code, String text, T data) {
        this.code = code;
        this.text = text;
        this.data = data;
    }

    private static <T> JsonMessage<T> init(String code, String msg, T msgData){
        return new JsonMessage<>(code,msg,msgData);
    }

    public static <T> JsonMessage<T> createSuccessMessage(T data) {
        return init(ApiExceptionEnum.SUCCESS.getExceptionCode(),ApiExceptionEnum.SUCCESS.getExceptionDesc(),data);
    }

    public static JsonMessage createSuccessMessage() {
        return createSuccessMessage(null);
    }

    public static JsonMessage createErrorMessage(String errorCode, String errorMsg) {
        return createErrorMessage(errorCode, errorMsg, null);
    }
    public static JsonMessage createErrorMessage(ApiExceptionEnum exceptionEnum) {
        return createErrorMessage(exceptionEnum.getExceptionCode(), exceptionEnum.getExceptionDesc(), null);
    }
    public static <T> JsonMessage<T> createErrorMessage(String errorCode, String errorMsg, T msgData) {
        return init(errorCode,errorMsg,msgData);
    }
}
