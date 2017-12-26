package edu.spring.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String admin = (String)request.getSession().getAttribute("admin");
		if(admin == null || admin == "") {
			request.getSession().setAttribute("result", 1);
			response.sendRedirect("/project/admin/login");
		}
		
		return super.preHandle(request, response, handler);
	}

}
