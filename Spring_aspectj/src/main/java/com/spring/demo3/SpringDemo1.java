package com.spring.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class SpringDemo1 {
	@Resource(name="customDao")
	private CustomDao customDao;

	@Test
	public void demo(){
		customDao.save();
//		customDao.update();
//		customDao.findOne();
//		customDao.findAll();
//		customDao.delete();
	}
}
