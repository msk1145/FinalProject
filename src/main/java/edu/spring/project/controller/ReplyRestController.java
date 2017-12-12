package edu.spring.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.project.domain.ReplyContents;
import edu.spring.project.service.ReplyContentsService;

@RestController
@RequestMapping(value = "/replies")
public class ReplyRestController {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyRestController.class);
	
	@Autowired
	private ReplyContentsService replyConService;
	
	@RequestMapping(value = "/all/{bno}",
			method = RequestMethod.GET)
	public ResponseEntity<List<ReplyContents>> readReplies(@PathVariable int bno) {
		logger.info("readReply(bno: {})", bno);
		
		List<ReplyContents> list = replyConService.read(bno);
		System.out.println(list);
		ResponseEntity<List<ReplyContents>> entity = null;
		if (list != null) {
			entity = new ResponseEntity<List<ReplyContents>>(list, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<List<ReplyContents>>(HttpStatus.BAD_REQUEST);
		}
		System.out.println(entity);
		return entity;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createReply(@RequestBody ReplyContents r) {
		logger.info("createReply() 호출");
		
		int result = replyConService.insert(r);
		
		ResponseEntity<String> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.CREATED);
		} else {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
}
