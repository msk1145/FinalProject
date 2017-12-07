package edu.spring.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.project.domain.Member;
import edu.spring.project.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

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
	@RequestMapping(value="/memberinsert" , method=RequestMethod.GET)
	public void insert() {}
	
	// 회원 가입
	@RequestMapping(value="/memberinsert" , method=RequestMethod.POST)
	public String insert(Member m, HttpServletRequest request) {
		int i = service.insert(m);
		if(i == 1) {
			System.out.println("회원가입 성공");
			HttpSession session = request.getSession();
			session.setAttribute("member", m.getUserid());
			return "redirect:/";
		}else {
			System.out.println("회원가입 실패");
			return "redirect:/memberinsert";
		}
	}
	
	@RequestMapping(value="/memberdetail" , method=RequestMethod.GET)
	public void memberdetail() {}
	
	@RequestMapping(value="/memberdetail" , method=RequestMethod.POST)
	public void memberdetail(Member m) {
		System.out.println(m.getUserid());
		System.out.println(m.getNickname());
	}
	
}
