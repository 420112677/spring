package com.imoco.springtrans.service.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

import com.imoco.springtrans.dao.OrderDao;
import com.imoco.springtrans.dao.ProjectDao;
import com.imoco.springtrans.domain.Order;
import com.imoco.springtrans.domain.Product;
import com.imoco.springtrans.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private TransactionDefinition transactionDefinition;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public void addOrder(Order order) {
		order.setCreateTime(new Date());
		order.setStatus("待付款");
		TransactionStatus transactionStatus=transactionManager.getTransaction(transactionDefinition);
		try{
		orderDao.add(order);
		Product product=projectDao.findOne(order.getProductsId());
		product.setStock(product.getStock()-order.getNumber());
		projectDao.update(product);
		transactionManager.commit(transactionStatus);
		}catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}

}
