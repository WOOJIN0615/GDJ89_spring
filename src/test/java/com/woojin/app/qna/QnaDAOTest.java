package com.woojin.app.qna;

import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woojin.app.Sample;
import com.woojin.app.boards.qna.QnaDAO;
import com.woojin.app.boards.qna.QnaDTO;

public class QnaDAOTest extends Sample {
	@Autowired
	private QnaDAO qnaDAO;
	
	@BeforeClass
	public static void bf(){
		System.out.println("전체 테스트 시작 전");
	}
	@AfterClass
	public static void af() {
		System.out.println("전체 테스트 종료 후");
	}
	
	@Before
	public void be() {
		System.out.println("개별 테스트 실행 전");
	}
	@After
	public void ae() {
		System.out.println("개별 테스트 실행 후");
	}
	
	@Test
	public void addTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		Calendar ca = Calendar.getInstance();
		
		for (int i=0; i<110; i++) {
			qnaDTO.setBoardDate(new Date(ca.getTimeInMillis()));
			qnaDTO.setUsername("test");
			qnaDTO.setBoardContents("testContents"+i);
			qnaDTO.setBoardHit(i+1L);
			qnaDTO.setBoardTitle("test"+i);
			qnaDAO.add(qnaDTO);
			
			if (i%10==0) {
				Thread.sleep(500);
			}
			
			System.out.println("Finish");
			
		}
	}

}
