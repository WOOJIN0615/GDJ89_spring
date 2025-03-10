package com.woojin.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDownView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fileDown View");
//		Iterator<String> it=model.keySet().iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
		
//		}
		FileDTO fileDTO=(FileDTO)model.get("file");
		String path = (String)model.get("kind");
		
		path=request.getSession().getServletContext().getRealPath("/resources/images/"+path+"/");
		
		//1. 한글 인코딩 처리(filter에서 했다면 생략가능)
		File file = new File(path, fileDTO.getFileName());
		
		response.setCharacterEncoding("UTF-8");
		
		//2. 파일의 크기
		response.setContentLength((int)file.length());
		
		//3. 다운 시 파일이름 지정
		String name = fileDTO.getOldName();
		name = URLEncoder.encode(name, "UTF-8");
		
		//4. 다운 시 타입을 헤더에 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+name+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		FileInputStream fis = new FileInputStream(file);
		OutputStream os=response.getOutputStream();
		
		FileCopyUtils.copy(fis, os);
		
		//5. 자원 해제
		os.close();
		fis.close();
}
	
}
