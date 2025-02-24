package com.woojin.app.pages;

import org.springframework.stereotype.Component;

public class Pager {
	


	private Long startNum;
	private Long endNum;
	private Long page;
	private Long start;
	private Long end;
	
	//한 페이지당 조회할 row의 갯수
	private Long perPage;
	//시작 번호, 끝번호를 계산하는 메서드
	
	public void makeNum() {
		startNum = (getPage()-1)*getPerPage()+1;
		endNum = getPage()*getPerPage();
	}
	
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	
	public Long getEndNum() {
		return endNum;
	}
	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}
	
	public Long getPage() {
		if (this.page==null || page<1) {
			this.page=1L;
		}
		return page;
	}
	
	public void setPage(Long page) {
		this.page = page;
	}
	
	public Long getPerPage() {
		if (this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStart() {
		return start;
	}
	
	public void setStart(Long start) {
		this.start = start;
	}
	
	public Long getEnd() {
		return end;
	}
	
	public void setEnd(Long end) {
		this.end = end;
	}
}
