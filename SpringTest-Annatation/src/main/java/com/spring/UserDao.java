package com.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {
	public void save(){
		System.out.println("dao中的save方法");
	}
	@PostConstruct
	public void init(){
		System.err.println("dao的初始化方法");
	}
	@PreDestroy
	public void destroy(){
		System.err.println("dao的销毁方法");
	}
}
