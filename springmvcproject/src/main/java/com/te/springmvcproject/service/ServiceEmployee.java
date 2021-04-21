package com.te.springmvcproject.service;

import java.util.List;

import com.te.springmvcproject.beans.EmployeeBean;

public interface ServiceEmployee {

public EmployeeBean authenticate(int id,String password);
	
	public EmployeeBean getEmployee(int id);
	
	public boolean getDelete(int id);
	
	List<EmployeeBean> getAllEmp();
	
	public boolean addEmp(EmployeeBean bean);
	
	public boolean getUpdate(EmployeeBean bean);
}
