package com.imoco.sm.global;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding="UTF-8";
	public void init(FilterConfig filterConfig) throws ServletException {
		if (filterConfig.getInitParameter("ENCODING")!=null) {
			encoding=filterConfig.getInitParameter("ENCODING");
		}
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		arg2.doFilter(request, response);
	}
	public void destroy() {
		encoding=null;
	}

}
