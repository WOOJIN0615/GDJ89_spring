package com.woojin.app.products;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentsDAOTest2 {

	@Autowired
	private ProductDAO productDAO;
	
	@BeforeClass
	public static void bf() {
		System.out.println("전체 테스트 시작 전");
	}
	
	@AfterClass
	public static void af() {
		System.out.println("전체 테스트 종료 후");
	}
	
	@Before
	public void fe() {
		System.out.println("개별 테스트 실행 전");
	}
	
	@After
	public void ae() {
		System.out.println("개별 테스트 실행 후");
	}
	
	public void addCommentsTest() throws Exception{
		CommentsDTO commentsDTO = new CommentsDTO();
		Calendar ca = Calendar.getInstance();
		
		for (int i=0; i<50; i++) {
			commentsDTO.setBoardDate(new Date(ca.getTimeInMillis()));
			commentsDTO.setBoardContents("BoardContents" + i);
			commentsDTO.setProductNum(1l);
			commentsDTO.setUsername("test");
			commentsDTO.setBoardNum(i*1l);
			
			productDAO.addComments(commentsDTO);
			
			if (i%10==0) {
				Thread.sleep(100);
			}
			
			System.out.println("Finish");
		}
	}

}
