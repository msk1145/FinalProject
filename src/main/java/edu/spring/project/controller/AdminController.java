package edu.spring.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	// 관리자 페이지 
	@RequestMapping(value = "/login", 
			method = RequestMethod.GET)
	public void admin() {
		
	}
	
	
	// 관리자 페이지 로그인
	@RequestMapping(value = "/login",
			method = RequestMethod.POST)
	public String admin(String userid, String password) {
		Member m = adminService.login(userid, password);
		return "redirect:/admin/main";
	}
	
	// 관리자 페이지 메인
	@RequestMapping(value = "/main",
			method = RequestMethod.GET)
	public void adminMain() {
		
	}
	
	// 회원 리스트
	@RequestMapping(value = "/memberList",
			method = RequestMethod.GET)
	public void memberList(Model model) {
		List<Member> memberList =  adminService.memberList();
		model.addAttribute("member", memberList);
		
	}
	
	// 회원 상세 정보
	@RequestMapping(value = "/memberdetail",
			method = RequestMethod.GET)
	public void memberDetail(String userid, Model model) {
		System.out.println("memberDetail");
		Member m = adminService.memberDetail(userid);
		model.addAttribute("member", m);
	}
	
	// 회원 정보 수정 
	@RequestMapping(value = "/memberUpdate",
			method = RequestMethod.POST)
	public String memberUpdate(Member m) {
		System.out.println("memberUpdate()");
		System.out.println(m.getGrade()+ m.getNickname());
		adminService.memberUpdate(m);
		return "redirect:main";
	}
	
	@RequestMapping(value = "/memberGradeUpdate",
			method = RequestMethod.POST)
	public String memberGradeUpdate(String userid, String grade) {
		System.out.println("memberGradeUpdate()");
		System.out.println(userid + grade);
		adminService.memberGradeUpdate(userid, grade);
		return "redirect:main";
	}
	
	@RequestMapping(value = "/memberdelete", method = RequestMethod.GET)
	public String memberDelete(String userid, Model model) {
		int i = adminService.memberDelete(userid);
		model.addAttribute("result",i);
		return "redirect:/admin/memberList";
	}
	
	
	// 로그 아웃
	@RequestMapping(value = "/logout",
			method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		
		return "redirect:../";
	}
	
	
}
