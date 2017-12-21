package edu.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu.spring.project.domain.BoardContentsVO;


import edu.spring.project.service.BoardContentsService;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	@Autowired
	BoardContentsService boardConService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home(Model model) {
		List<List<BoardContentsVO>> list = boardConService.selectmenu();
		model.addAttribute("board", list);
		return "main";
	}
	
}
