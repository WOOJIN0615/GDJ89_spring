package com.woojin.app.boards.qna;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woojin.app.boards.BoardDTO;
import com.woojin.app.boards.BoardService;
import com.woojin.app.pages.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long total = qnaDAO.count(pager);
		pager.make(total);
		pager.makeNum();
		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		return ar;
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception {
		if (check) {
			qnaDAO.updateHit(boardDTO);
		}
		return qnaDAO.getDetail(boardDTO);
	}
	
	public int add(BoardDTO boardDTO) throws Exception {
		return qnaDAO.add(boardDTO);
	}
	
	public int update(BoardDTO boardDTO)throws Exception {
		return qnaDAO.update(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO boardDTO) throws Exception {
		//boardDTO 답글 : 이름, 제목, 내용, 부모글 : 글번호
		QnaDTO parent=(QnaDTO)qnaDAO.getDetail(boardDTO);
		
		//부모의 ref
		boardDTO.setBoardRef(parent.getBoardRef());
		boardDTO.setBoardStep(parent.getBoardStep()+1);
		boardDTO.setBoardDepth(parent.getBoardDepth()+1);
		
		int result=qnaDAO.updateStep(parent);
		result=qnaDAO.reply(boardDTO);
		return result;
	}

}
