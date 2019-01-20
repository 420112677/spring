package com.spring.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


public class MyAspectJAdvisor {
	public void before(JoinPoint jPoint){
		System.out.println("前置拦截========="+jPoint);
	}
	public void afterReturn(Object resault){
		System.out.println("后置通知=============="+resault);
	}
 
	public Object arrod(ProceedingJoinPoint jpoint) throws Throwable{
		System.out.println("环绕前置通知===========");
		Object object=jpoint.proceed();
		System.out.println("环绕后置通知===========");

		return object;
	}
	public void throwAdvisor(Throwable e){
		System.out.println("异常后通知============="+e.getMessage());
	}
	
	public void after(){
		System.out.println("最终后通知=============");
	}

}
