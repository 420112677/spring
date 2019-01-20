package com.spring.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository("userDao3")
public class UserDao2 {
	public void save(){
		System.out.println("dao2中的save方法");
	}
	@PostConstruct
	public void init(){
		System.err.println("dao2的初始化方法");
	}
	@PreDestroy
	public void destroy(){
		System.err.println("dao2的销毁方法");
	}
}
