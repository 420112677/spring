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
import com.imoco.sm.service.StraffService;

@Controller("personController")
public class PersonController {
	@Autowired
	SelfService selfService;
	
	public void toPersonInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Staff staff=(Staff) request.getSession().getAttribute("USER");
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("../person_detail.jsp").forward(request, response);
	}
	
	public void toChangePassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Staff staff=(Staff) request.getSession().getAttribute("USER");
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("../person_change.jsp").forward(request, response);
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void changePassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Staff staff=(Staff) request.getSession().getAttribute("USER");
		String newPassword=request.getParameter("newPassword");
		String oldPassword=request.getParameter("oldPassword");
		if (staff.getPassword().equals(oldPassword)) {
			selfService.changPassword(newPassword, staff.getId());
			request.setAttribute("message", "0");
			
			response.getWriter().print("<script type=\"text/javasctipt\"> paret.location.href=\"../loginOut.do\"</script>");

		}else{
			response.sendRedirect("toChangePassword.do");
		}
	}

}
