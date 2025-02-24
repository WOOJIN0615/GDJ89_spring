package com.woojin.app.notices;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woojin.app.users.UserDTO;

@Controller
@RequestMapping(value = "/notices/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public void getList(Model model)throws Exception{
		List<NoticeDTO> ar= noticeService.getList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO, Model model, HttpSession session)throws Exception{
		//"board" : set(글번호들,,)
		Object obj = session.getAttribute("board");
		boolean check=false;
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(noticeDTO.getBoardNum())) {
				check=true;
			}else {
				ar.add(noticeDTO.getBoardNum());
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(noticeDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		
		noticeDTO= noticeService.getDetail(noticeDTO, check);
		model.addAttribute("dto", noticeDTO);
	}
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void add()throws Exception{
		
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, HttpSession session)throws Exception{
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		noticeDTO.setUserName(userDTO.getUsername());
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model)throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO, false);
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO)throws Exception{
		int result =  noticeService.update(noticeDTO);
		
		//return "redirect:./list";
		return "redirect:./detail?boardNum="+noticeDTO.getBoardNum();
		
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO, Model model)throws Exception{
		int result = noticeService.delete(noticeDTO);
		String s = "삭제 실패";
		if(result>0) {
			s = "삭제 성공";
		}
		model.addAttribute("result", s);
		model.addAttribute("path", "./list");
		
		return "commons/result";
		
	}

}
