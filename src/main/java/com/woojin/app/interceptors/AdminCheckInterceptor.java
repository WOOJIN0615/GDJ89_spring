package com.woojin.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.woojin.app.users.UserDTO;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserDTO userDTO=(UserDTO)request.getSession().getAttribute("user");
		userDTO.setUsername(userDTO.getUsername());
		
		if (userDTO.getUsername().equals("test")) {
			return true;
		}
		request.setAttribute("path", "/");
		request.setAttribute("result", "관리자만 접근할 수 있습니다.");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result");
		view.forward(request, response);
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
