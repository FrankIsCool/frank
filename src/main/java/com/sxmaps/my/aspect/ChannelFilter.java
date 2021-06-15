package com.sxmaps.my.aspect;

import com.sxmaps.my.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 类：拦截器
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Component
@WebFilter(filterName = "channelFilter", urlPatterns = {"/check/*"})
public class ChannelFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            ServletRequest requestWrapper = null;
            if (request instanceof HttpServletRequest) {
                requestWrapper = new RequestWrapper((HttpServletRequest) request);
            }
            if (requestWrapper == null) {
                chain.doFilter(request, response);
            } else {
                chain.doFilter(requestWrapper, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void destroy() {
    }
}


