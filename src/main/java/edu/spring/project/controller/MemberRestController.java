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
		bool = service.idCheck(userid);
		return bool;
	}
	
	
}
