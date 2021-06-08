package com.sxmaps.my.utils;

import javax.servlet.*;
import java.io.IOException;

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
