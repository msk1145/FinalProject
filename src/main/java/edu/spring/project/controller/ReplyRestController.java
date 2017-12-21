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
		ResponseEntity<List<ReplyContents>> entity = null;
		if (list != null) {
			entity = new ResponseEntity<List<ReplyContents>>(list, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<List<ReplyContents>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/rereplies/{rrno}",
			method = RequestMethod.GET)
	public ResponseEntity<List<ReplyContents>> readReReplies(@PathVariable int rrno) {
		logger.info("readReReplies(rrno: {})", rrno);
		
		List<ReplyContents> list = replyConService.readReReplies(rrno);
		logger.info("list::" + list);
		ResponseEntity<List<ReplyContents>> entity = null;
		if (list != null) {
			entity = new ResponseEntity<List<ReplyContents>>(list, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<List<ReplyContents>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createReply(@RequestBody ReplyContents r) {
		logger.info("createReply() 호출");
		
		
		int	result = replyConService.insert(r);
		
		
		ResponseEntity<String> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.CREATED);
		} else {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	@RequestMapping(value = "{rno}",
			method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable int rno, @RequestBody ReplyContents r) {
		logger.info("updateReply() 호출");
		r.setRno(rno);
		logger.info(r.getContent() + ",");
		int result = replyConService.update(r);
		
		ResponseEntity<String> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "{rno}",
			method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply(@PathVariable int rno, @RequestBody ReplyContents r) {
		logger.info("deleteReply() 호출");
		logger.info("deleteReply::" + r.getRrno());
		int rrno = r.getRrno();
		int result = replyConService.delete(rno, rrno);
		ResponseEntity<String> entity = null;
		if (result > 0) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}







