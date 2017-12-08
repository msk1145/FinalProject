package edu.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(value = "/login", 
			method = RequestMethod.GET)
	public void admin() {
		
	}
	
	@RequestMapping(value = "/login",
			method = RequestMethod.POST)
	public String admin(String userid, String password) {
		System.out.println("찍힘?");
		return "redirect:/admin/main";
	}
	
	@RequestMapping(value = "/main",
			method = RequestMethod.GET)
	public void adminMain() {
		
	}
	
	
}
