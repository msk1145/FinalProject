package edu.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.project.domain.Member;
import edu.spring.project.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/login", 
			method = RequestMethod.GET)
	public void admin() {
		
	}
	
	@RequestMapping(value = "/login",
			method = RequestMethod.POST)
	public String admin(String userid, String password) {
		System.out.println("찍힘?");
		Member m = adminService.login(userid, password);
		return "redirect:/admin/main";
	}
	
	@RequestMapping(value = "/main",
			method = RequestMethod.GET)
	public void adminMain() {
		
	}
	
	@RequestMapping(value = "/memberList",
			method = RequestMethod.GET)
	public void memberList(Model model) {
		List<Member> memberList =  adminService.memberList();
		model.addAttribute("member", memberList);
		
	}
	
	
}
