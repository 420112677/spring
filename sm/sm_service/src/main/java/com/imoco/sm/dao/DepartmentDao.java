package com.imoco.sm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imoco.sm.entity.Department;
@Repository("departmentDao")
public interface DepartmentDao {
	void insert(Department department);

	void delete(Integer id);

	void update(Department department);

	Department selectById(Integer id);

	List<Department> selectAll();
}
