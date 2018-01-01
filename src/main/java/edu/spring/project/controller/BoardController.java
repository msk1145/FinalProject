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
import edu.spring.project.pageutil.PageNumberMaker;
import edu.spring.project.pageutil.PaginationCriteria;
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
		int replyCount = replyConSevice.totalCountBybno(bno);
		
		model.addAttribute("boardContents", boardContents);
		model.addAttribute("replyCount", replyCount);
		
	}

	// Board Insert
	@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
	public void boardinsert() {

	}
	
	@RequestMapping(value="/boardmain",method=RequestMethod.GET)
	public void boardmain(String category, Integer page, Integer perPage, Model model) {
		logger.info("page {}, perPage {}", page, perPage);
		PaginationCriteria c = null;
		if(page != null && perPage != null) {
			c = new PaginationCriteria(page, perPage);
		} else {
			c = new PaginationCriteria();
		}
		
		PageNumberMaker maker = new PageNumberMaker();
		maker.setCriteria(c);
		int count = boardConService.totalCount(category);
		maker.setTotalCount(count);
		maker.setPageMakerData();
		model.addAttribute("pageMaker", maker);
		
		List<BoardContents> boardlist = boardConService.readPaging(category, c);
		model.addAttribute("board", boardlist);
		model.addAttribute("category", category);

//		List<BoardContents> boardlist = boardConService.read(category);
//		model.addAttribute("board", boardlist);
	}
	
	@RequestMapping(value = "/boardsearch",
			method = RequestMethod.GET)
	public void boardsearch(String category, Integer page, Integer perPage,
			Integer searchType, String keyword, Model model) {
		logger.info("BoardController:: category" + category);
		logger.info("BoardController:: keyword" + keyword);
		PaginationCriteria c = null;
		if (page != null || perPage != null) {
			c = new PaginationCriteria(page, perPage);
		} else {
			c = new PaginationCriteria();
		}
		
		PageNumberMaker maker = new PageNumberMaker();
		maker.setCriteria(c);
		int count = boardConService.searchedTotalCount(category, keyword, searchType);
		maker.setTotalCount(count);
		maker.setPageMakerData();
		model.addAttribute("pageMaker", maker);
		
		List<BoardContents> boardlist = boardConService.readSearchedPaging(category, c, keyword, searchType);
		model.addAttribute("board", boardlist);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("category", category);
	}
	
	
	
	
}
