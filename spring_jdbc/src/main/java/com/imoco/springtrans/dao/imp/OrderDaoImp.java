package com.imoco.springtrans.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.imoco.springtrans.dao.OrderDao;
import com.imoco.springtrans.domain.Order;
@Repository
public class OrderDaoImp implements OrderDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(Order order) {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,order.getId(),order.getProductsId(),order.getNumber(),order.getPrice(),order.getCreateTime(),order.getSendTime(),order.getConfirmTime(),order.getConsignee(),order.getConsigneePhone(),order.getConsigneeAddress(),order.getStatus());
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Order order) {
		// TODO Auto-generated method stub
		
	}

	public Order findOne(int id) {
		 String sql = "select form orders where id=?";
	        return jdbcTemplate.queryForObject(sql,new OrderRowMapper(),id);

		
	}
	 private class OrderRowMapper implements RowMapper<Order>{
	        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
	            Order order=new Order();
	            order.setId(resultSet.getString("id"));
	            order.setProductsId(resultSet.getString("product_id"));
	            order.setNumber(resultSet.getInt("number"));
	            order.setPrice(resultSet.getDouble("price"));
	            order.setCreateTime(resultSet.getTimestamp("create_time"));
	            order.setSendTime(resultSet.getTimestamp("send_time"));
	            order.setConfirmTime(resultSet.getTimestamp("confirm_time"));
	            order.setConsignee(resultSet.getString("consignee"));
	            order.setConsigneePhone(resultSet.getString("consignee_phone"));
	            order.setConsigneeAddress(resultSet.getString("consignee_address"));
	            order.setStatus(resultSet.getString("status"));
	            return order;
	        }
	    }

}
