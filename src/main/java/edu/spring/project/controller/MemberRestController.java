package edu.spring.project.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.project.domain.Member;
import edu.spring.project.service.MemberService;

@RestController
@RequestMapping(value="/member")
public class MemberRestController {
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/idCheck" , method=RequestMethod.POST)
	public boolean logincheck(String userid) {		
		boolean bool = false;
		bool = service.idCheck(userid);
		return bool;
	}
	
	@RequestMapping(value="/findInfo", method=RequestMethod.POST)
	public ResponseEntity<String> findInfo(@RequestBody Member m) {
		System.out.println("MemberRestController::findInfo 호출");
		System.out.println("이메일:" + m.getEmail());
		System.out.println("아이디:" + m.getUserid());
		System.out.println("별명:" + m.getNickname());
		Member member = service.findInfo(m);
		System.out.println("member:" + member);
		
		ResponseEntity<String> entity = null;
		if (member != null) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		return entity;
	}
	
	@RequestMapping(value = "/authNumberSend",
			method = RequestMethod.POST)
	public int authNumberSend(HttpServletRequest request,
			ModelMap mo, @RequestBody String email)
			throws AddressException, MessagingException {
		System.out.println("메일발송 테스트");
		String host = "smtp.gmail.com";
		
		final String username = "willkoreans";
		final String password = "willkoreans@@";
		int port = 465;
		
		// 인증번호 생성
		int authNumber = (int) (Math.random() * 1000000);
		System.out.println("authNumber:" + authNumber);
		
		String recipient = email;
		System.out.println("email:" + email);
		String subject = "WILLKOREANS 인증번호입니다.";
		String body = username + "님으로부터 발송된 메일입니다. \n"
				+ "인증번호는 " + authNumber + " 입니다.";
		
		Properties props = System.getProperties(); // 정보를 담기위한 객체
		
		// smtp 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		
		// session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);
		
		Message mimeMessage = new MimeMessage(session); // MimeMessage 생성
		// 발신자 셋팅(풀주소 입력)
		mimeMessage.setFrom(new InternetAddress("willkoreans@gmail.com"));
		// 수신자 셋팅 // TO 외에 .CC(참조) .BCC(숨은참조)도 있음
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		
		mimeMessage.setSubject(subject); // 제목 셋팅
		mimeMessage.setText(body); // 내용 셋팅
		Transport.send(mimeMessage); // javax.mail.Transport.send() 이용
		
		return authNumber;
	}
	
	
}
