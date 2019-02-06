package com.imoco.sm.global;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest quest, ServletResponse ponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)quest;
		HttpServletResponse response=(HttpServletResponse)ponse;
		String path=request.getServletPath();
		//如果是登陆页面
		if (path.toLowerCase().indexOf("login")!=-1) {
			chain.doFilter(request, response);
		}else{
			//不是登陆界面就要验证是否登陆
			Object object=request.getSession().getAttribute("USER");
			if(object!=null){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/toLogin.do");
			}
		}
		
	}

}
