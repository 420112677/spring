package com.imoco.springtrans.service.imp4;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
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

	@Transactional(propagation=Propagation.REQUIRED)
	public void addOrder(Order order) {
		order.setCreateTime(new Date());
		order.setStatus("待付款");
		orderDao.add(order);
		Product product = projectDao.findOne(order.getProductsId());
		product.setStock(product.getStock() - order.getNumber());
		projectDao.update(product);
	}

}
