package com.woojin.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// DS -> Controller
		
		Object obj=request.getSession().getAttribute("user");
		
		if (obj!=null) {
			return true;
		}
		//1. redirect
		//response.sendRedirect("/users/login");
		
		//2. forward
		request.setAttribute("result", "로그인이 필요합니다.");
		request.setAttribute("path", "/users/login");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);	
		
		
		//return이 true 라면 Controller로 진행
		//return이 false 라면 Controller로 진행 x(되돌려 보냄)
			return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller -> DS
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// html로 렌더링 후
		System.out.println("afterCompletion");
		
	}
	
	

}
