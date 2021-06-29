package com.sxmaps.my.aspect;

import com.sxmaps.my.common.FunctionsThreadLocal;
import com.sxmaps.my.common.LoginThreadLocal;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.exception.ApiException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类：拦截器
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/29
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new ApiException(ApiExceptionEnum.PARAM_TOKEN);
        }
        String functionsSn = request.getHeader("functionsSn");
        if(StringUtils.isEmpty(functionsSn)){
            throw new ApiException(ApiExceptionEnum.PARAM_FUNCTION);
        }
        UserInfoVo userInfo = LoginThreadLocal.getUserInfoVo(token);
        if(userInfo.getUserType()== UserTypeEnum.USERTYP_3.getState()){
            return true;
        }
        return FunctionsThreadLocal.clickFunction(functionsSn,userInfo.getUserUid());
    }


    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }

}
