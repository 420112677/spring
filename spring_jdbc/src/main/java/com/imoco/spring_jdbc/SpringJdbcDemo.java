package com.imoco.spring_jdbc;

import java.util.Date;

import org.junit.Test;

import com.imoco.spring_jdbc.domain.Student;
import com.imoco.spring_jdbc.imp.StudentImp;

public class SpringJdbcDemo {

	
	@Test
	public void getTest(){
	StudentImp studentImp=new StudentImp();
	Student student=studentImp.findOne(2);
	System.out.println(student);
	}

}
