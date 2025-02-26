package com.woojin.app.qna;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.woojin.app.pages.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Pager pager) throws Exception{
		List<QnaDTO> ar=qnaService.getList(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetali(Model model, QnaDTO qnaDTO, HttpSession session) throws Exception {
		Object obj = session.getAttribute("board");
		boolean check = false;
		if (obj!=null) {
			HashSet<Long>ar=(HashSet<Long>)obj;
			if (!ar.contains(qnaDTO.getBoardNum())) {
				check=true;
			}else {
				ar.add(qnaDTO.getBoardNum());
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(qnaDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		qnaDTO = qnaService.getDetail(qnaDTO, check);
		model.addAttribute("dto", qnaDTO);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.add(qnaDTO);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("dto", qnaService.getDetail(qnaDTO, false));
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(QnaDTO qnaDTO) throws Exception {
		int result=qnaService.update(qnaDTO);
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO, Model model) throws Exception {
		int result = qnaService.delete(qnaDTO);
		String str = "삭제 실패";
		if (result > 0) {
			str = "삭제 성공";
		}
		model.addAttribute("result", str);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	

}
