package com.woojin.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.pages.Pager;

public interface BoardService {
	
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	
	//detail
	public abstract BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception;
	
	//add
	public abstract int add(BoardDTO boardDTO, HttpSession session, MultipartFile[] attaches) throws Exception;
	
	//update
	public abstract int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public abstract int delete(BoardDTO boardDTO) throws Exception;

}
