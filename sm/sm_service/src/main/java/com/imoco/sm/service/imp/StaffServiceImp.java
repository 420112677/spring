package com.imoco.sm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imoco.sm.dao.DepartmentDao;
import com.imoco.sm.dao.StraffDao;
import com.imoco.sm.entity.Department;
import com.imoco.sm.entity.Staff;
import com.imoco.sm.service.DepartmentService;
import com.imoco.sm.service.StraffService;
@Service("straffService")
public class StaffServiceImp implements StraffService {
	@Autowired
	private StraffDao straffDao;
	@Override
	public void add(Staff staff) {
		straffDao.insert(staff);
	}

	@Override
	public void remove(Integer id) {
		straffDao.delete(id);
	}

	@Override
	public void edit(Staff staff) {
		straffDao.update(staff);
	}

	@Override
	public Staff get(Integer id) {
		return straffDao.selectById(id);
	}

	@Override
	public List<Staff> getAll() {
		return straffDao.selectAll();
	}


}
