package com.spring.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspectAdvisor {
	@Before(value="execution(* com.spring.demo1.ProjectDao.save*(..))")
	public void before(JoinPoint joinpoint) {
		System.err.println("前置通知==========="+joinpoint);
	}

}
