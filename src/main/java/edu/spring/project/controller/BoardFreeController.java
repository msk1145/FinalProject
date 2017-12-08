package edu.spring.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/boardFree")
public class BoardFreeController {
	public static final Logger logger =
			LoggerFactory.getLogger(BoardFreeController.class);
	
	
	@RequestMapping(value = "/boardFreeDetail",
			method = RequestMethod.GET)
	public void boardFreeDatail() {
		
	}
	
}
