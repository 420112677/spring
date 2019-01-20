package com.imoco.springtrans.dao;

import com.imoco.springtrans.domain.Order;

public interface OrderDao {
	
	public void add(Order order);
	public void delete(int id);
	public void update(Order order);
	public Order findOne(int id);
	

}
