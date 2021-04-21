package com.te.springmvcproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvcproject.customexceptions.EmployeeExp;

@ControllerAdvice
public class EmployeeControllerAdvice {
	
	@ExceptionHandler(EmployeeExp.class)
	public String handleExp(EmployeeExp exp,HttpServletRequest req) {
		req.setAttribute("err", exp.getMessage());
		return "errPage";
	}
}
