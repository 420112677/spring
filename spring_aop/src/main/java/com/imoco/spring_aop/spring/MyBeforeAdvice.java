package com.imoco.spring_aop.spring;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.err.println("前置增强==================");
	}

}
