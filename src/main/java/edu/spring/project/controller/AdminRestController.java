package edu.spring.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/admin")
public class AdminRestController {
	
	@RequestMapping(value="/boardinsert",method=RequestMethod.GET)
	public void boardinsert(){
		
		System.out.println("sexpower");
		
	}
}
