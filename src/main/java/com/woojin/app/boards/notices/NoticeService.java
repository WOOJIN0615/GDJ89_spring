package com.woojin.app.boards.notices;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileUpload filemanager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long total = noticeDAO.count(pager);
		pager.make(total);
		pager.makeNum();
		
		List<BoardDTO> ar = noticeDAO.getList(pager);
		return ar;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception {
		// TODO Auto-generated method stub
		if(check) {
			noticeDAO.updateHit(boardDTO);
		}
		return noticeDAO.getDetail(boardDTO);
	}

	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile[] attaches) throws Exception {
		//1. DB에 Notice 정보를 Insert
		int result = noticeDAO.add(boardDTO);
		//2. HDD에 File을 저장, 그 정보들을 DB에 저장
		for (MultipartFile attach: attaches) {
			if (attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(session.getServletContext(), attach);
			//DB에 저장
			//
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = noticeDAO.addFile(boardFileDTO);
		}
		return result;
	}

	
	public int update(BoardDTO boardDTO, MultipartFile[] attaches, HttpSession session) throws Exception {
		int result = noticeDAO.update(boardDTO);
		
		for (MultipartFile attach: attaches) {
			if (attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(session.getServletContext(), attach);
			//DB에 저장
			//
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = noticeDAO.addFile(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		boardDTO = noticeDAO.getDetail(boardDTO);
		int result=noticeDAO.fileDeleteAll(boardDTO);
		result=noticeDAO.delete(boardDTO);
		
		if (result>0) {
			String path=session.getServletContext().getRealPath("/resources/images/notice");
			for(BoardFileDTO boardFileDTO : ((NoticeDTO)boardDTO).getBoardFileDTOs()) {
				
				filemanager.fileDelete(path, boardFileDTO.getFileName());
			}
		}
		
		return result;
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO, HttpSession session) throws Exception{
		//1. 정보 조회
		boardFileDTO=noticeDAO.getFileDetail(boardFileDTO);
		//2. DB 삭제 > HDD 삭제
		int result=noticeDAO.fileDelete(boardFileDTO);
		if (result>0) {
			String path=session.getServletContext().getRealPath("/resources/images/notice");
			filemanager.fileDelete(path, boardFileDTO.getFileName());
		}
		
		return result;
	}
	
	private BoardFileDTO fileSave(ServletContext context, MultipartFile attach) throws Exception {
		//1. 어디에 저장할 것인가
		String path = context.getRealPath("/resources/images/notice/");
		System.out.println(path);
		File file = new File(path);
		
		if (file.exists()) {
			file.mkdirs();
		}
		
		//2. HDD에 파일을 저장하고 저장된 파일명을 return
		String fileName=filemanager.fileUpload(path, attach);
		
		//3. 파일의 정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
		
		
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
