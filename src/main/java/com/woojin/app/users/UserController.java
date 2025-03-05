package com.woojin.app.users;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// /users/check
	//Check
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public String check(UserDTO userDTO, Model model) throws Exception{
		System.out.println("아이디 중복 체크");
		System.out.println(userDTO.getUsername());
		userDTO = userService.check(userDTO);
		//userDTO = null 이면 중복 x 가입 가능
		//userDTO != null 이면 중복 o 가입 불가능
		int result=0; //중복 0
		if (userDTO==null) {
			result=1; //중복 x
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "addCart")
	public String addCart() throws Exception{
		return "users/addCart";
	}
	
	@RequestMapping(value = "addCart", method = RequestMethod.POST)
	public String addCart(CartDTO cartDTO, HttpSession session, Model model) throws Exception{
			CartDTO dto =(CartDTO)session.getAttribute("user");
			cartDTO.setUsername(dto.getUsername());
			int result = userService.addCart(cartDTO);
			System.out.println(cartDTO.getUsername());
		
		return "";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		System.out.println("controller join");
		
		return "users/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception {
		System.out.println(profile.getContentType());
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getSize());
		System.out.println(profile.isEmpty());
		System.out.println(session.getServletContext());
		
		int result = userService.join(userDTO, profile, session.getServletContext());
		
		return "redirect:./login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() throws Exception {
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, HttpSession session, Model model) throws Exception {
		userDTO = userService.login(userDTO);
		if (userDTO!=null) {
			System.out.println("성공");
			session.setAttribute("user", userDTO);
			return "redirect:/";
		}
		System.out.println("실패");
		model.addAttribute("result", "로그인 실패");
		model.addAttribute("path", "./login");
		return "users/login";
	}
	
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(UserDTO userDTO, ModelAndView mv) throws Exception {
		userDTO = userService.detail(userDTO);
		mv.setViewName("users/detail");
		mv.addObject("user", userService.login(userDTO));
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(UserDTO userDTO, ModelAndView mv) throws Exception {
		mv.setViewName("users/update");
		mv.addObject("user", userService.detail(userDTO));
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(UserDTO userDTO, HttpSession session, MultipartFile profile) throws Exception {
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		userDTO.setUsername(dto.getUsername());
		int result = userService.update(userDTO, profile, session);
		return "redirect:./detail";
	}
	
}
