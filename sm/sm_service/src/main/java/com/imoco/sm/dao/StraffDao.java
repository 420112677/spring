package com.imoco.sm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imoco.sm.entity.Staff;
@Repository("straffDao")
public interface StraffDao {
	void insert(Staff staff);

	void delete(Integer id);

	void update(Staff staff);

	Staff selectById(Integer id);

	List<Staff> selectAll();
}
