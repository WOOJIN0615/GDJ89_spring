package com.woojin.app.boards.qna;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.woojin.app.boards.BoardDTO;

@Component
public class QnaDTO extends BoardDTO{
	private Long boardRef; //그룹으로 작성
	//원본글-자기 자신의 글번호를 ref값으로 지정
	//답글-부모글의 ref값을 ref값으로 지정
	private Long boardStep; //그룹 내에서 순서
	//원본글-0
	//답글	1) update : ref의 값이 부모의 ref와 같고 step의 값이 부모의 step값보다 큰 것들을 찾아서 step을 1씩 증가
	//		2) 부모의 step에 +1한 값을 자신의 step값으로 지정
	private Long boardDepth; //들여쓰기 횟수 
	//원본글-0
	//답글-부모글의 depth+1

	public Long getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(Long boardRef) {
		this.boardRef = boardRef;
	}
	public Long getBoardStep() {
		return boardStep;
	}
	public void setBoardStep(Long boardStep) {
		this.boardStep = boardStep;
	}
	public Long getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(Long boardDepth) {
		this.boardDepth = boardDepth;
	}
}
