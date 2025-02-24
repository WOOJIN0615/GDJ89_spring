package com.woojin.app.notices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woojin.app.pages.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		
		Long total = noticeDAO.count();
		
		pager.make(total);
		
		pager.makeNum();
		List<NoticeDTO> ar = noticeDAO.getList(pager);
		return ar;
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO, boolean check) throws Exception {
		
		if (check) {
			noticeDAO.updateHit(noticeDTO);
		}
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeDAO.update(noticeDTO);
		
		return result;
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeDAO.delete(noticeDTO);
		
		return result;
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

}
