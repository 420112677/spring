package com.imoco.sm.global;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DispatcherServlet extends GenericServlet {

	ApplicationContext context=null;

	@Override
	public void init() throws ServletException {
		super.init();
		context=new ClassPathXmlApplicationContext("spring.xml");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		/*
		 *  /staff/add.do   /login.do
		 *  staffController
		 *  public void add(HttpServletRequest request,HttpServletResponse response)
		 */
		//获取请求的url ——>staff/add.do
		String path=request.getServletPath().substring(1);
		//加工url获取方法 
		String beanName=null;
		String methodName=null;
		int index=path.indexOf("/");
		if (index!=-1) {
			beanName=path.substring(0,index)+"Controller";
			methodName=path.substring(index+1,path.indexOf(".do"));
		}else{
			beanName="selfController";
			methodName=path.substring(path.indexOf(".do"));

		}
		
		Object object=context.getBean(beanName);
		try {
			Method method=object.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(object,request,response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
