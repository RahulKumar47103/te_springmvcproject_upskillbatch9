package com.te.springmvcproject.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookies")
public class CookieController {
	
	@GetMapping("/cookie")
	public String getCookie() {
		return "cookiesPage";
		
	}
	
	@GetMapping("/createCookie")
	public String name(HttpServletResponse resp,ModelMap map) {
		Cookie cookie=new Cookie("EmpName", "sai");
		resp.addCookie(cookie);
		map.addAttribute("msg", "created cookie");
		return "cookiesPage";
	} 
	
//	public String showCookie(@CookieValue(name="EmpName" required=false) String name) {
//		
//	}

}
