package edu.spring.project.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.project.domain.Menu;

public class MenuInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired SqlSession session;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		List<Menu> menulist = session.selectList("edu.spring.project.mappers.AdminMapper.showMenu");
		request.getSession().setAttribute("menu", menulist);
		super.postHandle(request, response, handler, modelAndView);
	}

}
