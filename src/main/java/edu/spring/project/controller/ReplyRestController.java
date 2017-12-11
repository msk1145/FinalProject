package edu.spring.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value = "/all/{bno}")
	public ResponseEntity<List<ReplyContents>> readReplies(@PathVariable int bno) {
		logger.info("readReply(bno: {})", bno);
		
		List<ReplyContents> list = replyConService.read(bno);
		
		ResponseEntity<List<ReplyContents>> entity = null;
		if (list != null) {
			entity = new ResponseEntity<List<ReplyContents>>(list, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<List<ReplyContents>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
