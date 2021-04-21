package com.te.springmvcproject.customexceptions;

public class EmployeeExp extends RuntimeException{
	
	public EmployeeExp(String msg) {
		super(msg);
	}

}
