package com.sxmaps.mms.common;
//操作枚举
public enum OperationEnum {
	OPERATION_IMPORT(1,"导入学员数据"),
	OPERATION_OPERATION(2,"分配了一条数据给:"),
	OPERATION_OTHER(3,"转分配了一条数据给："),
    ;


    //代码
    private int code;
    //描述
    private String msg;

    private OperationEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
