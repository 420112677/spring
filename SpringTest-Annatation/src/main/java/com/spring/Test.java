package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@org.junit.Test
	public void demo1(){
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		UserService service =(UserService)context.getBean("userService");
			service.sayHello("test");
	}
	@org.junit.Test
	public void demo2(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		UserService service =(UserService)context.getBean("userService");
		UserService service2 =(UserService)context.getBean("userService");
		System.err.println(service==service2);
		
	}

}
