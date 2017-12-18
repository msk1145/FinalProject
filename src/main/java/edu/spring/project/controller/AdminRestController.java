package edu.spring.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/admin")
public class AdminRestController {
	
	@RequestMapping(value="/boardinsert",method=RequestMethod.GET)
	@ResponseBody
	public String boardinsert(){
		
		
		System.out.println("sexpower");
		
		return null;
	}
}
