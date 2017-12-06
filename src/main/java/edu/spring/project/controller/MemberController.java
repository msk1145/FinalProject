package edu.spring.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.project.domain.Member;
import edu.spring.project.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	// 추가추가추가추가추가
	// 수정가능ㅇㅇㅇ
	@Autowired MemberService service;
	// 로그인
	@RequestMapping(value="/memberlogin" , method=RequestMethod.GET)
	public void login() {}
	
	@RequestMapping(value="/memberlogin", method=RequestMethod.POST)
	public String login(String userid, String password, HttpServletRequest request) {
		
		Member member = service.login(userid, password);
		if(member == null) {// 로그인 실패
			return "redirect:/member/memberlogin";
		}else { // 로그인 성공
			request.getSession().setAttribute("member", member.getUserid());
			return "redirect:/";
		}
		
		
	}
	
	// 회원 가입 화면 보여주기
	@RequestMapping(value="/insert" , method=RequestMethod.GET)
	public void insert() {}
	
	// 회원 가입
	@RequestMapping(value="/insert" , method=RequestMethod.POST)
	public void insert(Member m) {
		int i = service.insert(m);
		if(i == 1) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
	
}
