package com.imoco.spring_aop.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.err.println("环绕前增强============");
		//执行目标对象的方法
		Object object =invocation.proceed();
		System.err.println("环绕后增强============");

 		return object;
	}

}
