package edu.spring.project.interceptor;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.project.domain.Member;
import edu.spring.project.service.MemberService;

public class FindIdPwInterceptor extends HandlerInterceptorAdapter{
	@Autowired MemberService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("FindIdPwInterceptor::preHandle()");
		String userid = (String) request.getParameter("userid");
		String email = (String) request.getParameter("email");
		String nickname = (String) request.getParameter("nickname");
		
		// 아이디 찾기
		if (nickname != null) {
			return super.preHandle(request, response, handler);
		// 비밀번호 찾기
		} else {
			// 임시비밀번호 생성
			char pwArray[] = new char[] { 
                    '1','2','3','4','5','6','7','8','9','0', 
                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 
                    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', 
                    '!','@','#','$','%','^','&','*','(',')'};
			StringBuffer tempPw = new StringBuffer();
			int idx = 0;
			for (int i = 0; i < 10; i++) {
				idx = (int) (pwArray.length * Math.random());
				tempPw.append(pwArray[idx]);
			}
			
//			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//			uuid = uuid.substring(0, 10);
//			System.out.println("uuid: " + uuid);
			System.out.println("임시비밀번호: " + tempPw.toString());
			Member m = new Member(userid, tempPw.toString(), null, null, null);
			service.setTempPw(m);
			
			tempPwSend(request, email, tempPw.toString());
			
			response.sendRedirect("memberfindpw-result");
			return false;
		}
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FindIdPwInterceptor::postHandle()");
	
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// 임시비밀번호 메일 전송
	public void tempPwSend(HttpServletRequest request,
			 String email, String tempPw)
			throws AddressException, MessagingException {
		System.out.println("메일발송 테스트");
		String host = "smtp.gmail.com";
		
		final String username = "willkoreans";
		final String password = "willkoreans@@";
		int port = 465;
		
		String recipient = email;
		System.out.println("email:" + email);
		String subject = "WILLKOREANS 임시 비밀번호입니다.";
		String body = username + "님으로부터 발송된 메일입니다. \n"
				+ "임시비밀번호는 " + tempPw + " 입니다.";
		
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
