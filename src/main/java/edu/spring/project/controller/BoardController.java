package edu.spring.project.controller;

import java.util.List;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.ReplyContents;
import edu.spring.project.service.BoardContentsService;
import edu.spring.project.service.BoardFreeService;
import edu.spring.project.service.ReplyContentsService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	private static final String UPLOAD_PATH = "C:\\Study\\Fileupload";

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
	public void detail(Model model) {
		logger.info("BoardController::deail() 호출");
		int bno = 3;
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

	// Board Insert
	@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
	public void boardinsert() {

	}

	@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
	public void boardinsert(MultipartFile uploadFile, Model model) {
		logger.info("upload() POST 호출");
		logger.info("파일이름: {}", uploadFile.getOriginalFilename());
		logger.info("파일크기: {}", uploadFile.getSize());

		String result = saveFile(uploadFile);
		logger.info("result :" + result);
		if (result != null) {
			model.addAttribute("result", result);
		} else {

		}

	}

	// 파일 저장객체 생성
	private String saveFile(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		logger.info(uuid + "");
		String saveName = uuid + "_" + file.getOriginalFilename();

		// 저장할 File 객체를 생성
		File saveFile = new File(UPLOAD_PATH, saveName);

		// 생성된 파일 객체를 저장
		try {
			FileCopyUtils.copy(file.getBytes(), saveFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return saveName;
	}
	
	@RequestMapping(value="/boardmain",method=RequestMethod.GET)
	public void boardmain(String category) {
		System.out.println(category);
		
	}
	
}
