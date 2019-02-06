package com.imoco.sm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imoco.sm.entity.Department;
import com.imoco.sm.entity.Staff;
import com.imoco.sm.service.DepartmentService;
import com.imoco.sm.service.StraffService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
@Controller("staffController")
public class StaffController {
	@Autowired
	private StraffService straffService;
	@Autowired
	private DepartmentService departmentService;
	
	public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		List<Staff> list=straffService.getAll();
		request.setAttribute("LIST",list);
		request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
	}
	public void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Department> departments=departmentService.getAll();
		request.setAttribute("DLIST", departments);
		request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
	}
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String account=request.getParameter("account");
		
		String sex=request.getParameter("sex");
		String did=request.getParameter("did");
		String idNumber=request.getParameter("idNumber");
		Date bornDate =null;
		if(request.getParameter("bornDate")!=null&&!"".equals(request.getParameter("bornDate"))){
			try {
				bornDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		String info=request.getParameter("info");
		Staff staff=new Staff();
		staff.setAccount(account);
		staff.setBornDate(bornDate);
		staff.setDid(Integer.parseInt(did));
		staff.setIdNumber(idNumber);
		staff.setInfo(info);
		staff.setName(name);
		staff.setSex(sex);
		straffService.add(staff);
		response.sendRedirect("list.do");
	}
	
	public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		Staff staff=straffService.get(Integer.parseInt(id));
		List<Department> departments=departmentService.getAll();
		request.setAttribute("DLIST", departments);
		request.setAttribute("staff", staff);
		
		request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Integer id =Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String did=request.getParameter("did");
		String idNumber=request.getParameter("idNumber");
		Date bornDate =null;
		if(request.getParameter("bornDate")!=null&&!"".equals(request.getParameter("bornDate"))){
			try {
				bornDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		String info=request.getParameter("info");
		Staff staff=straffService.get(id);
		staff.setBornDate(bornDate);
		staff.setDid(Integer.parseInt(did));
		staff.setIdNumber(idNumber);
		staff.setInfo(info);
		staff.setName(name);
		staff.setSex(sex);
		straffService.edit(staff);
		response.sendRedirect("list.do");
	}
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		Staff staff=straffService.get(Integer.parseInt(id));
		if (staff!=null) {
		straffService.remove(Integer.parseInt(id));
		}
		response.sendRedirect("list.do");
	}
	public void toDetail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		Staff staff=straffService.get(Integer.parseInt(id));
		List<Department> departments=departmentService.getAll();
		request.setAttribute("DLIST", departments);
		request.setAttribute("staff", staff);
		
		request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
	}
}
