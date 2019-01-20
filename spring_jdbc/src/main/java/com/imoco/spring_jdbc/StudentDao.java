package com.imoco.spring_jdbc;



import java.util.List;

import com.imoco.spring_jdbc.domain.Student;

public interface StudentDao {
	public void add(Student stu);
	public void update(Student stu);
	public Student findOne(int id);
	public List findList();

}
