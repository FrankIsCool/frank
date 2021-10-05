package com.sxmaps.my.advice;

import com.franks.util.empty.EmptyUtil;
import com.franks.util.model.ApiResponse;
import com.franks.util.param.ParamAdvice;
import com.franks.util.param.encrypt.advice.IDCardEncryptAdvice;
import com.franks.util.param.encrypt.advice.PhoneEncryptAdvice;
import com.franks.util.param.encrypt.annotation.EncryptField;
import com.franks.util.sign.SignUtils;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.PageInfoTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice(basePackages = {"com.sxmaps.my.controller"})
public class ResponseMessageAdvice implements ResponseBodyAdvice<Object> {

    final Logger logger = LoggerFactory.getLogger(ResponseMessageAdvice.class);

    List<MediaType> mediaTypes = Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8);

    /**
     * 格式化输出为统一JSON格式
     *
     * @param object
     * @param methodParameter
     * @param mediaType
     * @param converter
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> converter, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // 记录日志
        logger.info("线程id: {},  返回结果集: {}", Thread.currentThread().getId(), object);
        if (!mediaTypes.contains(mediaType)) {
            return object;
        }
        // 返回结果非统一对象，则封装为同一对象
        if (EmptyUtil.isEmpty(object)) {
            object = ApiResponse.success(object);
        } else if (object instanceof PageInfo) {
            object = ApiResponse.success(new PageInfoTable().setPage((PageInfo) object, ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()));
        } else if (!(object instanceof ApiResponse)) {
            object = ApiResponse.success(object);
        }
        ParamAdvice.encryptField(object, EncryptField.class, s -> SignUtils.MD5.createSign(s, "frank", "utf-8"));
        IDCardEncryptAdvice.encryptField(object);
        PhoneEncryptAdvice.encryptField(object);
//        PhoneValidAdvice.validField(object);
//        IDCardValidAdvice.validField(object);
        return object;
    }

    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> httpMessageConverter) {
        return true;
    }

}