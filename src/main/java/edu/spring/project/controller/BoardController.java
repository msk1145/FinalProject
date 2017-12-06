package edu.spring.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.project.service.BoardContentsService;
import edu.spring.project.service.BoardFreeService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	public static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardContentsService boardConService;
	@Autowired
	BoardFreeService boardFreeService;
	
	@RequestMapping(value = "/boarddetail",
			method = RequestMethod.GET)
	public void detail() {
		
	}
	
	
	@RequestMapping(value="/boardinsert",method=RequestMethod.GET)
	public void boardinsert() {
		
	}
}











