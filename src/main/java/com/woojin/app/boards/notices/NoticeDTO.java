package com.woojin.app.boards.notices;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.woojin.app.boards.BoardDTO;
import com.woojin.app.boards.BoardFileDTO;

@Component
public class NoticeDTO extends BoardDTO {
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}

	private List<BoardFileDTO> boardFileDTOs;
	
	
}