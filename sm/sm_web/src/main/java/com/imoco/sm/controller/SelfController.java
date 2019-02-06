package com.imoco.sm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imoco.sm.entity.Staff;
import com.imoco.sm.service.SelfService;

@Controller("selfController")
public class SelfController {
	@Autowired
	SelfService selfService;
	
	/**
	 * 跳转到login页面
	 */
	public void toLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		Staff staff=selfService.getStaffByAccount(account, password);
		if (staff==null) {
			//密码不对，跳到登陆页面
			response.sendRedirect("toLogin.do");
		}else{
			//账号密码争取进入index页面
			HttpSession session=request.getSession();
			session.setAttribute("USER", staff);
			response.sendRedirect("main.do");	
			}
	}
	public void loginOut(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			HttpSession session=request.getSession();
			session.setAttribute("USER", null);
			response.sendRedirect("toLogin.do");	
	}
	public void main(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
