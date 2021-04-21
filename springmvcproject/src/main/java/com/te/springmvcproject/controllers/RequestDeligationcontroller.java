package com.te.springmvcproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligationcontroller {
	
	@GetMapping("/redirect")
	public String redirectRequest() {
		
		return "redirect:https://www.youtube.com";
		
	}
	
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:homePage";
		
	}
}
