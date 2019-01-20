package com.imoco.springtrans.dao;

import com.imoco.springtrans.domain.Product;

public interface ProjectDao {
	
	public void add(Product product);
	public void delete(int id);
	public void update(Product product);
	public Product findOne(String string);
	

}
