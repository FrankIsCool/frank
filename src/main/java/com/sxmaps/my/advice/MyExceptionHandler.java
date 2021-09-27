package com.sxmaps.my.advice;

import com.franks.util.exception.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 类：异常处理
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
@ControllerAdvice
public class MyExceptionHandler extends GlobalExceptionHandler {
    public MyExceptionHandler() {
        super();
    }
}