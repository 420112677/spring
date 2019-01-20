package com.spring.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspectJAdvisor {
//	@Before(value="execution(* com.spring.demo2.CustomDao.save(..))")
	@Before(value="mypoint1()")
	public void before(JoinPoint jPoint){
		System.out.println("前置拦截========="+jPoint);
	}
	@AfterReturning(value="execution(* com.spring.demo2.CustomDao.update(..))",returning="resault")
	public void afterReturn(Object resault){
		System.out.println("后置通知=============="+resault);
	}
 
	@Around(value="execution(* com.spring.demo2.CustomDao.findOne(..))")
	public Object arrod(ProceedingJoinPoint jpoint) throws Throwable{
		System.out.println("环绕前置通知===========");
		Object object=jpoint.proceed();
		System.out.println("环绕后置通知===========");

		return object;
	}
	@AfterThrowing(value="execution(* com.spring.demo2.CustomDao.findAll(..))",throwing="e")
	public void throwAdvisor(Throwable e){
		System.out.println("异常后通知============="+e.getMessage());
	}
	
	@After(value="execution(* com.spring.demo2.CustomDao.delete(..))")
	public void after(){
		System.out.println("最终后通知=============");
	}
	@Pointcut(value="execution(* com.spring.demo2.CustomDao.save(..))")
	private void mypoint1(){
		
	}
}
