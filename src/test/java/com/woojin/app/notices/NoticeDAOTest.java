package com.woojin.app.notices;

import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woojin.app.Sample;
import com.woojin.app.boards.notices.NoticeDAO;
import com.woojin.app.boards.notices.NoticeDTO;
import com.woojin.app.products.ProductDTO;

public class NoticeDAOTest extends Sample {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
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
	
	@Test()
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		Calendar ca = Calendar.getInstance();
		
		for (int i=0; i<110; i++) {
		
		noticeDTO.setBoardDate(new Date(ca.getTimeInMillis()));
		noticeDTO.setBoardContents("boardcontents"+i);
		noticeDTO.setBoardTitle("boardtitle"+i);
		noticeDTO.setUsername("test");
		noticeDTO.setBoardHit(i+1L);
		
		noticeDAO.add(noticeDTO);
		
		
		
		if (i%10==0) {
			Thread.sleep(500);
		}
		
		System.out.println("Finish");
		
		}
	}

}
