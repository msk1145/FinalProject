package edu.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.project.service.MemberService;

@RestController
@RequestMapping(value="/member")
public class MemberRestController {
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/idCheck" , method=RequestMethod.POST)
	public boolean logincheck(String userid) {
		boolean bool = false;
		if(userid == null) { // userid 가 널일경우
			return bool;
		}else { // 값을 제대로 가져옴
			bool = service.idCheck(userid);
		}		
		return bool;
	}
}
