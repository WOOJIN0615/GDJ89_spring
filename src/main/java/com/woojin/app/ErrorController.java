package com.woojin.app;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//전역 예외 처리 전문 Controller
@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(NullPointerException.class)
	public String error1() {
		return "errors/error_500";
	}
	
	@ExceptionHandler(SQLException.class)
	public String error2() {
		return "errors/error_500";
	}
	
	@ExceptionHandler(Exception.class)
	public String error(Model model, Exception exception) {
		model.addAttribute("result", exception.getMessage());
		
		return "errors/error_500";
	}
	
}
