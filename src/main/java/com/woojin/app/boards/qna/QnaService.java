package com.woojin.app.boards.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.boards.BoardDTO;
import com.woojin.app.boards.BoardFileDTO;
import com.woojin.app.boards.BoardService;
import com.woojin.app.files.FileUpload;
import com.woojin.app.pages.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileUpload filemanager;
	
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
	
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile[] attaches) throws Exception {
		//1. DB에 qna 정보를 Insert
		int result = qnaDAO.add(boardDTO);
		
		//2. HDD에 File을 저장, 그 정보들을 DB에 저장
		for (MultipartFile attach: attaches) {
			if (attach.isEmpty()) {
				continue;
			}
			//DB에 저장
			BoardFileDTO boardFileDTO = this.fileSave(session.getServletContext(), attach);
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			
			result = qnaDAO.addFile(boardFileDTO);
		}
		return result;
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
	
	private BoardFileDTO fileSave(ServletContext context, MultipartFile attach) throws Exception {
		//1. 어디에 저장할 것인가
		String path = "/resources/images/qna/";
		File file = new File(path);
		
		if (file.exists()) {
			file.mkdirs();
		}
		
		//2. HDD에 파일을 저장하고 저장된 파일명을 리턴
		String fileName = filemanager.fileUpload(path, attach);
		
		//3. 파일의 정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}

}
