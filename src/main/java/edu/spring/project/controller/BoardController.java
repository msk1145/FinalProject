package edu.spring.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.ReplyContents;
import edu.spring.project.service.BoardContentsService;
import edu.spring.project.service.BoardFreeService;
import edu.spring.project.service.ReplyContentsService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	public static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardContentsService boardConService;
	@Autowired
	BoardFreeService boardFreeService;
	@Autowired
	ReplyContentsService replyConSevice;
	
	@RequestMapping(value = "/boarddetail",
			method = RequestMethod.GET)
	public void detail(Model model) {
		logger.info("BoardController::deail() 호출"); 
		int bno = 3;
		BoardContents boardContents = boardConService.read(bno);
		List<ReplyContents> list = replyConSevice.read(bno);
		logger.info("list {}", list);
		model.addAttribute("boardContents", boardContents);
		model.addAttribute("replyConList", list);
	}
	
	@RequestMapping(value = "/boardupdate",
			method = RequestMethod.GET)
	public void update(Model model) {
		logger.info("BoardController::update() 호출");
		int bno = 3;
		BoardContents boardContents = boardConService.read(bno);
		model.addAttribute("boardContents", boardContents);
	}
	
	
	@RequestMapping(value="/boardinsert",method=RequestMethod.GET)
	public void boardinsert() {
		
	}
}











