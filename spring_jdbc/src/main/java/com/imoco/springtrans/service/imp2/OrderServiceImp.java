package com.imoco.springtrans.service.imp2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
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
	@Autowired
	private TransactionTemplate template;
	
	public void addOrder(final Order order) {
		order.setCreateTime(new Date());
		order.setStatus("待付款");
		template.execute(new TransactionCallback<Object>() {

			public Order doInTransaction(TransactionStatus status) {

				try{
					orderDao.add(order);
					Product product=projectDao.findOne(order.getProductsId());
					product.setStock(product.getStock()-order.getNumber());
					projectDao.update(product);
					}catch (Exception e) {
						e.printStackTrace();
						status.setRollbackOnly();
					}
				
				return null;
			}
		});
		
	}

}
