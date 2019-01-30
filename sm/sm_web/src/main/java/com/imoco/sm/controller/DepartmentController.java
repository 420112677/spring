package com.imoco.sm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imoco.sm.entity.Department;
import com.imoco.sm.service.DepartmentService;
@Controller("departmentController")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		List<Department> list=departmentService.getAll();
		request.setAttribute("LIST",list.get(0));
		request.getRequestDispatcher("../department_list.jsp").forward(request, response);
		
	}
}
