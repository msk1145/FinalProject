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

	private static final String UPLOAD_PATH_IMAGE = "C:\\Users\\scott\\git\\FinalProject\\src\\main\\webapp\\resources\\images";
	private static final String UPLOAD_PATH_MOVIE = "C:\\Users\\scott\\git\\FinalProject\\src\\main\\webapp\\resources\\video";

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
	public String boardinsert(BoardContents content, MultipartFile imageFile, MultipartFile videoFile) {
		String resultimage = saveImageFile(imageFile);
		String resultmovie = saveMovieFile(videoFile);
		
		String saveImagePath =   "/resources/images/" + resultimage;
		String saveVideoPath = "/resources/video/" + resultmovie;
		System.out.println(saveImagePath);
		System.out.println(saveVideoPath);
		BoardContents boardcontent = new BoardContents(0, content.getTitle(), content.getContent(), null, 0, content.getCategory(),saveVideoPath , saveImagePath);
		int result = boardConService.insert(boardcontent);
		System.out.println("삽입결과: " + result);
		if(result == 1) {
			return "redirect:/admin/main";
		}	
			return "redirect:/board/boardinsert";
		
		

	}

	// 이미지 파일 저장객체 생성
	private String saveImageFile(MultipartFile file) {
		
		String saveName = file.getOriginalFilename();
		

		// 저장할 File 객체를 생성
		File saveFile = new File(UPLOAD_PATH_IMAGE, saveName);

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
	
	// 영화파일 저장객체를 생성
	private String saveMovieFile(MultipartFile file) {

		String saveName = file.getOriginalFilename();

		// 저장할 File 객체를 생성
		File saveFile = new File(UPLOAD_PATH_MOVIE, saveName);

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
