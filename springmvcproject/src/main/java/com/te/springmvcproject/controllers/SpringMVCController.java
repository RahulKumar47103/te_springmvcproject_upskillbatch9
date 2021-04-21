package com.te.springmvcproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCController {
	
	@RequestMapping(path="/home" , method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/WEB-INF/view/homePage.jsp");
		return modelAndView;
	}
	
	@RequestMapping(path="/newpage" , method=RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("/WEB-INF/view/page.jsp");
		modelAndView.setViewName("page");
		return modelAndView;
	}
	
	@RequestMapping(path="/search" , method=RequestMethod.GET)
	public ModelAndView getSearch(ModelAndView modelAndView,HttpServletRequest request) {
		String name=request.getParameter("name");
		request.setAttribute("username", name);
		modelAndView.setViewName("newHome");
		
		return modelAndView;
	}
	
	@GetMapping("/form")
	public String getForm() {
		return "loginForm";
		
	}
	
	//1st way
	//@PostMapping("/login")
	public String getFormData(HttpServletRequest request , ModelMap modelMap) {
		String name = request.getParameter("user");
		int password = Integer.parseInt(request.getParameter("pwd"));
		
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("pwd", password);
		
		return "userDetails";
	}
	
	//2nd  way
	@PostMapping("/login1")
	public String getFormData2(ModelMap modelMap,String user, int pwd) {
		
		//binds together
		modelMap.addAttribute("name", user);
		modelMap.addAttribute("pwd", pwd);
		return "userDetails";
	}
	
	//3rd way
	@PostMapping("/login2")
	public String getDataFromBean (ModelMap modelMap,UserBean userBean) {
		
		modelMap.addAttribute("name", userBean.getUser());
		modelMap.addAttribute("pwd", userBean.getPwd());
		return "userDetails";
	}
	
	//4th way
	@PostMapping("/login3")
	public String geusesrDataFromReqParam(ModelMap modelMap,
			@RequestParam(name="") String user,
			@RequestParam(name="pwd") int password ) {
		
		modelMap.addAttribute("name", user);
		modelMap.addAttribute("pwd", password);
		return "userDetails";
	}
}
