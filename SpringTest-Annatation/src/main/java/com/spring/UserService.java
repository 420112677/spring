package com.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xml.internal.security.Init;

//@Component("userService")
@Service("userService")
@Scope("prototype")
public class UserService {
	private String kind;
	


	@Autowired
	private UserDao dao;
	@Resource(name="userDao3")
	private com.spring.spring.UserDao2 dao2;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void sayHello(String name) {
		System.out.println("进入了Spring annation:" + name);
	}

	public void save(){
		System.out.println("执行了service中的save方法");
		dao.save();
		dao2.save();
	}
	
}
