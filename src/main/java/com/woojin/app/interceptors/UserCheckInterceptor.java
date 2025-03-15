package com.woojin.app.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.woojin.app.boards.BoardDTO;
import com.woojin.app.boards.notices.NoticeDAO;
import com.woojin.app.users.UserDTO;

public class UserCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		String kind = (String)modelAndView.getModel().get("kind");
		
		if (kind.equals("product")) {
			
		}
		
		BoardDTO boardDTO=(BoardDTO)modelAndView.getModel().get("dto");
		if (!userDTO.getUsername().equals(boardDTO.getUsername())) {
			modelAndView.setViewName("commons/result");
			modelAndView.getModel().put("result", "작성자만 수정할 수 있습니다.");
			modelAndView.getModel().put("path", "./list");
		}
		
	}
	
	
	
}
