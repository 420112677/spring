package com.imoco.sm.dao;

import org.springframework.stereotype.Repository;

import com.imoco.sm.entity.Staff;
@Repository("selfDao")
public interface SelfDao {
	/**
	 * 通过账户查找对应的员工信息
	 * @param account
	 * @return
	 */
	Staff selectByAccount(String account);
	/**
	 * 修改密码
	 * 在session中获取对象
	 */
	void changPassword(String newPassword);
}
