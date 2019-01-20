package com.imoco.spring_aop.pointcut;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo {
	@Resource(name="customerDaoProxy")
	private CustomerDao customerDao;
	
	@Test
	public void demo() {
		customerDao.find();
		customerDao.save();
	}

}
