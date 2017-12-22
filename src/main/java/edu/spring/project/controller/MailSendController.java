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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/mailSender")
public class MailSendController {
	
	@RequestMapping(value = "/mailSend",
			method = RequestMethod.GET)
	public void mailSender(HttpServletRequest request, ModelMap mo) throws AddressException, MessagingException {
		System.out.println("메일발송 테스트");
		String host = "smtp.gmail.com";
		
		final String username = "willkoreans";
		final String password = "willkoreans@@";
		int port = 465;
		
		String recipient = "rail_moon@naver.com";
		String subject = "메일발송테스트";
		String body = username + "님으로부터 메일을 받음";
		
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
		
	}
}












