package com.imoco.sm.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imoco.sm.dao.SelfDao;
import com.imoco.sm.dao.StraffDao;
import com.imoco.sm.entity.Staff;
import com.imoco.sm.service.SelfService;
@Service("selfService")
public class SelfServiceImp implements SelfService {
	@Autowired
	private SelfDao selfDao;
	@Autowired
	private StraffDao straffDao;
	@Override
	public Staff getStaffByAccount(String account, String password) {
		Staff staff=selfDao.selectByAccount(account);
		if (staff==null) {
			return null;
		}
		if(password.equals(staff.getPassword())){
			return staff;
		}
		return null;
	}
	@Override
	public void changPassword(String newPassword, Integer id) {
		Staff staff=straffDao.selectById(id);
		staff.setPassword(newPassword);
		straffDao.update(staff);
		
	}



}
