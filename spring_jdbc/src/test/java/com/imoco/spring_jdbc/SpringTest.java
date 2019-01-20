package com.imoco.spring_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imoco.springtrans.domain.Order;
import com.imoco.springtrans.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service6.xml")
public class SpringTest {
	@Autowired
	OrderService orderService;
	
	@Test
	public void getOrder(){
		Order order=new Order("10008","100002",2,2000.2,"123","132012354","12312321");
		orderService.addOrder(order);
	}
}
