package edu.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/footerContents")
public class FooterController {

	@RequestMapping(value = "/accessTerms", method = RequestMethod.GET)
	public void accessTerms() {
		System.out.println("FooterContoller::accessTerms() 호출");
	}

	@RequestMapping(value = "/privacyStatements", method = RequestMethod.GET)
	public void privacyStatements() {
		System.out.println("FooterContoller::privacyStatements() 호출");
	}

}
