package com.te.springmvcproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvcproject.beans.EmployeeBean;
import com.te.springmvcproject.service.ServiceEmployee;

@Controller
public class EmployeeController {
	
	@Autowired
	private ServiceEmployee service; 
	
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("YYYY-MM-DD"),true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@GetMapping("/loginform")
	public String getLogin() {
		return "loginForm";
	}//end of getLogin
	
	@PostMapping("/empLogin")
	public String authenticate(int id,String password,HttpServletRequest request,ModelMap map) {
		EmployeeBean bean =service.authenticate(id, password);
		
		if(bean!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("emp",	bean);
			return "homePage";
			
		}else {
			map.addAttribute("errMsg", "invalid credentials");
			return "loginForm";
		} 
	}//end of authenticate
	
	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map,HttpSession session) {
		if(session.getAttribute("emp")!=null) {
			return "searchForm";
		}
		else {
			map.addAttribute("err msg", "please login again");
			return "empLogin";
		}
	}
		
	@GetMapping("/searchForm2")
	public String searchEmp(int id, ModelMap map, 
			@SessionAttribute(name="emp", required=false) EmployeeBean employeeBean) {
		
		if(employeeBean!=null) {
			EmployeeBean employeeBean2=service.getEmployee(id);
			if(employeeBean2 != null) {
				map.addAttribute("data", employeeBean2);
			}
			else {
				map.addAttribute("msg","data not found"+id);
			}
			return "searchForm";
		}else {
			map.addAttribute("err msg","please login first");
			return "empLogin";
		}
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session,ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "empLogin";
	}
	
	@GetMapping("/add")
	public String getAddPage() {
		return "addemployee";
	}
	
	@PostMapping("/add")
	public String addPage(@SessionAttribute(name="emp", required=false)EmployeeBean bean,EmployeeBean data,ModelMap map) {
		if(bean!=null) {
			boolean addData = service.addEmp(data);
			if(addData) {
				map.addAttribute("msg", "successfully added") ;
			}
			else {
				map.addAttribute("msg","data not added");
			}
			return "addemployee";
		}
		else {
			map.addAttribute("errMsg", "something went wrong");
		}
		return "loginForm";
	}
	
	@GetMapping("/update")
	public String getUpdateForm(@SessionAttribute(name="emp", required=false)EmployeeBean bean) {
		if(bean!=null){
			return "updateForm";
		}
		else {
		 return "empLogin";
		}
		
	}
	
//	public String updateForm(@SessionAttribute(name="emp",required = false)EmployeeBean bean,ModelMap map) {
//		if(bean!=null) {
//			if()
//		}
//		return "";
//		
//	}
	
	
}
