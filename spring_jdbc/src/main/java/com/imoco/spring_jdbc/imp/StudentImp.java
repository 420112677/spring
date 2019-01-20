package com.imoco.spring_jdbc.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.imoco.spring_jdbc.StudentDao;
import com.imoco.spring_jdbc.domain.Student;

public class StudentImp implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
	}
	
	public void add(Student stu) {
		String sql=" insert into student(name,sex,born) values(?,?,?)";
		List<Object[]> list=new ArrayList<Object[]>();
		Object[] object={stu.getName(),stu.getSex(),stu.getBorn()};
		list.add(object);
		jdbcTemplate.batchUpdate(sql,list);
		
		
	}


	public void update(Student stu) {
		// TODO Auto-generated method stub
		
	}

	public Student findOne(int id) {
		String sql="select * from student where id=?";
		Student student=jdbcTemplate.queryForObject(sql,new StudentMapper(),id);
		return student;
	}

	private class StudentMapper implements RowMapper<Student>{

		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student=new Student();
			student.setId(rs.getInt("id"));
			student.setBorn(rs.getDate("born"));
			student.setSex(rs.getString("sex"));
			student.setName(rs.getString("name"));
			return student;
		}
		
	}

	public List findList() {
		// TODO Auto-generated method stub
		return null;
	}


	


}
