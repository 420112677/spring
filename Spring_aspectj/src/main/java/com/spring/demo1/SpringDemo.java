package com.spring.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo {
	@Resource(name="projectDao")
	private ProjectDao projectDao;

	@Test
	public void Demo1() {
		projectDao.find();
		projectDao.save();
	}
}
