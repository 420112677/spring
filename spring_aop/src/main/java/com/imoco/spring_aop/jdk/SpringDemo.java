package com.imoco.spring_aop.jdk;

import org.junit.Test;

public class SpringDemo {

	@Test
	/**
	 * JDK AOP的底层实现
	 */
	public void demo(){
		UserDao userDao=new UserDaoImp();
		UserDao proxy=(UserDao)new MyJDKProxy(userDao).creatProxy();
		proxy.save();
		proxy.find();
	}
}
