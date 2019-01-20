package com.imoco.springtrans.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.imoco.springtrans.dao.ProjectDao;
import com.imoco.springtrans.domain.Product;
@Repository
public class ProjectDaoImp implements ProjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(Product product) {
		 String sql = "insert into products values(?,?,?,?,?)";
	        jdbcTemplate.update(sql,product.getId(),product.getTitle(),product.getPrice(),product.getStock(),product.getStatus());

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Product product) {
		  String sql = "update products set title=?,price=?,stock=?,status=? where id=?";
	        jdbcTemplate.update(sql,product.getTitle(),product.getPrice(),product.getStock(),product.getStatus(),product.getId());

	}

	public Product findOne(String id) {
		 String sql = "select * from products where id=?";
	        return jdbcTemplate.queryForObject(sql,new ProductRowMapper(),id);

	}
	   private class ProductRowMapper implements RowMapper<Product>{

	        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
	            Product product = new Product();
	            product.setId(resultSet.getString("id"));
	            product.setTitle(resultSet.getString("title"));
	            product.setPrice(resultSet.getDouble("price"));
	            product.setStock(resultSet.getInt("stock"));
	            product.setStatus(resultSet.getString("status"));
	            return product;
	        }
	    }

}
