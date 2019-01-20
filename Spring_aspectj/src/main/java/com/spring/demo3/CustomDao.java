package com.spring.demo3;

public class CustomDao {
	public String update(){
		System.out.println("更新数据");
		return"12312";
	}
	public void delete(){
		System.out.println("删除数据");
	}
	public void save(){
		System.out.println("保存信息");
	}
	public void findOne(){
		System.out.println("单一查找。。。");
	}
	public void findAll(){
		System.out.println("查找全部");
		
	}
}
