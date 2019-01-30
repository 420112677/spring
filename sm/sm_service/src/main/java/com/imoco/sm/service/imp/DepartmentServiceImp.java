package com.imoco.sm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imoco.sm.dao.DepartmentDao;
import com.imoco.sm.entity.Department;
import com.imoco.sm.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImp implements DepartmentService {
@Autowired
 private DepartmentDao dao;	
	public void add(Department department) {
		dao.insert(department);		
	}

	public void remove(Integer id) {
		dao.delete(id);
	}

	public void edit(Department department) {
		dao.update(department);
	}

	public Department get(Integer id) {
		
		return dao.selectById(id);
	}

	public List<Department> getAll() {
		return dao.selectAll();
	}

}
