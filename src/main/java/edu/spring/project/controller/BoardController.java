package edu.spring.project.controller;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.ReplyContents;
import edu.spring.project.persistence.BoardContentsDao;
import edu.spring.project.service.BoardContentsService;
import edu.spring.project.service.BoardFreeService;
import edu.spring.project.service.ReplyContentsService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardContentsService boardConService;
	@Autowired
	BoardFreeService boardFreeService;
	@Autowired
	ReplyContentsService replyConSevice;

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void list() {
		logger.info("boardList 호출");

	}

	@RequestMapping(value = "/boarddetail", method = RequestMethod.GET)
	public void detail(BoardContents content, Model model) {
		logger.info("BoardController::deail() 호출");
		int bno = content.getBno();
		boardConService.updatecount(bno);
		BoardContents boardContents = boardConService.read(bno);
		List<ReplyContents> list = replyConSevice.read(bno);
		logger.info("list {}", list);
		model.addAttribute("boardContents", boardContents);
		model.addAttribute("replyConList", list);
	}

	@RequestMapping(value = "/boardupdate", method = RequestMethod.GET)
	public void update(Model model) {
		logger.info("BoardController::update() 호출");
		int bno = 3;
		BoardContents boardContents = boardConService.read(bno);
		model.addAttribute("boardContents", boardContents);
	}
	
	@RequestMapping(value="/boardmain",method=RequestMethod.GET)
	public void boardmain(String category, Model model) {
		List<BoardContents> boardlist = boardConService.read(category);
		model.addAttribute("board", boardlist);
	}
	
}
