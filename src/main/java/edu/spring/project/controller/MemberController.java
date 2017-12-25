package edu.spring.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.project.domain.Member;
import edu.spring.project.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Autowired MemberService service;
	// 로그인
	@RequestMapping(value="/memberlogin" , method=RequestMethod.GET)
	public void login(String url, Model model) {
		if(url != null) {
			model.addAttribute("url", url);
		}		
	}
	
	// 로그아웃
	@RequestMapping(value = "/memberlogout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	// 로그인
	@RequestMapping(value="/memberlogin-post", method=RequestMethod.POST)
	public void login(String userid, String password,Model model) {
		Member member = service.login(userid, password);
		model.addAttribute("member",member);
	}
	
	// 회원 가입 화면 보여주기
	@RequestMapping(value="/memberinsert" , method=RequestMethod.GET)
	public void insert(String url, Model model) {
		if(url != null) {
			model.addAttribute("url", url);
		}		
	}
	
	// 회원 가입
	@RequestMapping(value="/memberinsert-post" , method=RequestMethod.POST)
	public void insert(Member m, Model model) {
		int i = service.insert(m);
		if(i > 0) {
			model.addAttribute("member" , m);
		}else {
			model.addAttribute("member" , null);
		}
	}
	
	@RequestMapping(value="/memberdetail" , method=RequestMethod.GET)
	public void memberdetail(String userid, Model model) {
		Member m = service.readDetail(userid);
		model.addAttribute("member", m);
	}
	
	@RequestMapping(value="/memberdetail" , method=RequestMethod.POST)
	public void memberdetail(Member m, Model model) {
		Member member = service.updateDetail(m);
		if(member != null) {
			model.addAttribute("member", member);
			model.addAttribute("bool", 1);
		}else {
			model.addAttribute("bool", 2);
		}
	}
	
	@RequestMapping(value="/memberdelete" , method=RequestMethod.GET)
	public String memberdelete(String userid, Model model, HttpServletRequest request) {
		service.memberdelete(userid);
		request.getSession().removeAttribute("member");
		return "redirect:/";
	}
	

	@RequestMapping(value="/memberfindid" , method=RequestMethod.GET)
	public void memberfindid() {
		System.out.println("memverfindid get 호출");
	}
	
	@RequestMapping(value="/memberfindid" , method=RequestMethod.POST)
	public String memberfindid(Member m, RedirectAttributes redirectAttr) {
		System.out.println("memberfindid post 호출");
		String nickname = m.getNickname();
		String email = m.getEmail();
		System.out.println("별명: " + nickname);
		System.out.println("이메일: " + email);

		Member member = service.findId(m);
		redirectAttr.addFlashAttribute("member", member);
		return "redirect:/member/memberfindid-result";
	}
	

	@RequestMapping(value="/memberfindpw" , method=RequestMethod.GET)
	public void memberfindpw() {
		System.out.println("memberfindpw 호출");
	}
	
	@RequestMapping(value="/memberfindid-result" , method=RequestMethod.GET)
	public void memberfindid_result() {
		System.out.println("memberfindid-result 호출");
	}
	
	
}
