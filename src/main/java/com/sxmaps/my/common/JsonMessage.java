package com.sxmaps.my.common;

import lombok.Data;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
@Data
public class JsonMessage<T> {

    private String code;

    private String text;

    private T data;

    public static JsonMessage createSuccessMessage(Object msgData) {
        JsonMessage responseMsg = new JsonMessage();
        responseMsg.setCode("200");
        responseMsg.setText("success");
        responseMsg.setData(msgData);
        return responseMsg;
    }

    public static JsonMessage createSuccessMessage() {
        return createSuccessMessage(null);
    }

    public static JsonMessage createErrorMessage(String errorCode, String errorMsg) {
        return createErrorMessage(errorCode, errorMsg, null);
    }

    public static JsonMessage createErrorMessage(String errorCode, String errorMsg, Object msgData) {
        JsonMessage responseMsg = new JsonMessage();
        responseMsg.setCode(errorCode);
        responseMsg.setText(errorMsg);
        responseMsg.setData(msgData);
        return responseMsg;
    }
}
