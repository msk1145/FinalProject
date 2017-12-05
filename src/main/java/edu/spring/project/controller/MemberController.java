package edu.spring.project.controller;

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
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public void login() {}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String userid, String password, Model m) {
		
		Member member = service.login(userid, password);
		if(member == null) {// 로그인 실패
			
		}else { // 로그인 성공
			m.addAttribute("member", member);
			// model
		}
		
		// TODO: REST에서 로그인 전 화면으로 보내줘야함 
		return "sujung";
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
