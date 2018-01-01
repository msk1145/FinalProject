package edu.spring.project.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="chat")
public class ChatController {
	
	private String sb = "";
	private int count = 0;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET , produces = "application/text; charset=utf8")
	@ResponseBody
	public String insert(String userid, String contents){
		if(count == 20) {
			count = 0;
			sb="";
		}
		if(userid.equals("") || userid == null) {
			userid = "손님";
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		String regdate = sdf1.format(cal.getTime());
		
		System.out.println("123");
		sb += regdate + "<br/> -> " + userid + " : " + contents + "<br/>"; 
		count++;
		return sb;		
	}
}
