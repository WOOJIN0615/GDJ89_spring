package com.woojin.app.users;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
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
	public String update(UserDTO userDTO, HttpSession session, MultipartFile profile, ServletRequest context) throws Exception {
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		userDTO.setUsername(dto.getUsername());
		int result = userService.update(userDTO, profile, null, session);
		return "redirect:./detail";
	}
	
}
