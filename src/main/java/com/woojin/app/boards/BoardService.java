package com.woojin.app.boards;

import java.util.List;

import com.woojin.app.pages.Pager;

public interface BoardService {
	
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	
	//detail
	public abstract BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception;
	
	//add
	public abstract int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public abstract int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public abstract int delete(BoardDTO boardDTO) throws Exception;

}
