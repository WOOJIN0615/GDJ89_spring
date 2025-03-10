package com.woojin.app.boards.qna;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woojin.app.boards.BoardDTO;
import com.woojin.app.boards.BoardFileDTO;
import com.woojin.app.pages.Pager;
import com.woojin.app.users.UserDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("kind")
	public String getKind() {
		return "qna";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception{
		List<BoardDTO> ar=qnaService.getList(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetali(Model model, BoardDTO boardDTO, HttpSession session) throws Exception {
		Object obj = session.getAttribute("board");
		boolean check = false;
		if (obj!=null) {
			HashSet<Long>ar=(HashSet<Long>)obj;
			if (!ar.contains(boardDTO.getBoardNum())) {
				check=true;
			}else {
				ar.add(boardDTO.getBoardNum());
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(boardDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		boardDTO = qnaService.getDetail(boardDTO, check);
		model.addAttribute("dto", boardDTO);
		
		return "board/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BoardDTO boardDTO, HttpSession session, MultipartFile[] attaches) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		boardDTO.setUserName(userDTO.getUsername());
		int result = qnaService.add(boardDTO, session, attaches);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/boardForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(BoardDTO boardDTO, Model model) throws Exception {
		model.addAttribute("dto", qnaService.getDetail(boardDTO, false));
		
		return "board/boardForm";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO) throws Exception {
		int result=qnaService.update(boardDTO);
		
		return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(BoardDTO boardDTO, Model model, HttpSession session) throws Exception {
		int result = qnaService.delete(boardDTO, session);
		String str = "삭제 실패";
		if (result > 0) {
			str = "삭제 성공";
		}
		model.addAttribute("result", str);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	public String fileDelete(BoardFileDTO boardFileDTO, Model model, HttpSession session) throws Exception {
		int result = qnaService.fileDelete(boardFileDTO, session);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(@ModelAttribute("dto") BoardDTO boardDTO) throws Exception {
		
		return "board/boardForm";
	}
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(QnaDTO boardDTO, HttpSession session) throws Exception {
		UserDTO userDTO=(UserDTO)session.getAttribute("user");
		boardDTO.setUserName(userDTO.getUsername());
		int result = qnaService.reply(boardDTO);
		
		return "redirect:./list";
	}
	
	

}
