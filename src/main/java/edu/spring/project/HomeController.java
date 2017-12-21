package edu.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.service.BoardContentsService;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	@Autowired
	BoardContentsService boardConService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		List<BoardContents> movie = boardConService.selectTopMovie();
		List<BoardContents> drama = boardConService.selectTopDrama();
		List<BoardContents> animation = boardConService.selectTopAnimation();
		List<BoardContents> variety = boardConService.selectTopVariety();
		List<BoardFree> freeboard = boardConService.selectTopFree();
		
		
		model.addAttribute("topfreeboard", freeboard);
		model.addAttribute("topMovie", movie);
		model.addAttribute("topDrama", drama);
		model.addAttribute("topAnimation", animation);
		model.addAttribute("topVariety", variety);
		return "main";
	}
	
}
