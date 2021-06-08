package com.sxmaps.mms.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String code=null;
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		request.setCharacterEncoding(code);
		response.setCharacterEncoding(code);
		response.setContentType("text/html;charset="+code);
		fc.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.code=config.getInitParameter("code");

	}

}
