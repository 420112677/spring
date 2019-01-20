package com.imoco.spring_aop.pointcut;

public class CustomerDao {
	public void save() {
		System.out.println("保存数据");
	}

	public void find() {
		System.out.println("查找数据");
	}

}
