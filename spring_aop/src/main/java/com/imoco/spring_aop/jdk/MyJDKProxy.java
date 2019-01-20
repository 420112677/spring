package com.imoco.spring_aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJDKProxy implements InvocationHandler {
	
	private UserDao dao;
	
	
	public MyJDKProxy(UserDao dao) {
		this.dao=dao;
	}

	public Object creatProxy(){
		Object object =Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), this);
		return object;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("save".equals(method.getName())){
			System.err.println("校验数据");
			return method.invoke(dao, args);
		}
		return method.invoke(dao, args);
	}
}
