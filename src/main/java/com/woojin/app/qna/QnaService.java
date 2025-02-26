package com.woojin.app.qna;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woojin.app.pages.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> getList(Pager pager) throws Exception{
		Long total = qnaDAO.count();
		pager.make(total);
		pager.makeNum();
		
		List<QnaDTO> ar = qnaDAO.getList(pager);
		
		return ar;
	}
	
	public QnaDTO getDetail(QnaDTO qnaDTO, boolean check) throws Exception {
		if (check) {
			qnaDAO.updateHit(qnaDTO);
		}
		return qnaDAO.getDetail(qnaDTO);
	}
	
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}
	
	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}

}
