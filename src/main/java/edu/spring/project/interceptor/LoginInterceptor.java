package edu.spring.project.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.project.domain.Member;


public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return super.preHandle(request, response, handler);
		
	}// end preHandle()
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String target = request.getParameter("url");
		
		Map<String,Object> model = modelAndView.getModel();
		Member m = (Member)model.get("member");
		if(m != null) { 
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			response.sendRedirect(target);
		}else {
			response.sendRedirect("/project/member/memberlogin?url=" + target);
		}
		
		super.postHandle(request, response, handler, modelAndView);
		
	}// end postHandle
	
}// end class LoginInterceptor
