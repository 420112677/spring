package com.imoco.sm.service;

import com.imoco.sm.entity.Staff;

public interface SelfService {
	Staff getStaffByAccount(String account,String password);
	void changPassword(String newPassword,Integer id);

}
