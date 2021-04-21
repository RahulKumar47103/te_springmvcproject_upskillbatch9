package com.te.springmvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvcproject.Dao.EmployeeDAO;
import com.te.springmvcproject.beans.EmployeeBean;

@Service
public class ServiceImpl implements ServiceEmployee{
	
	@Autowired
	EmployeeDAO employee;
	
	@Override
	public EmployeeBean authenticate(int id, String password) {
		
		return employee.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		
		return employee.getEmployee(id);
	}

	@Override
	public boolean getDelete(int id) {
		
		return employee.getDelete(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		
		return employee.getAllEmp();
	}

	@Override
	public boolean addEmp(EmployeeBean bean) {
		
		return employee.addEmp(bean);
	}

	@Override
	public boolean getUpdate(EmployeeBean bean) {
	
		return employee.getUpdate(bean);
	}

}
