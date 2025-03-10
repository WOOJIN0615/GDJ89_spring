package com.woojin.app.files;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	
	public String fileUpload(String path, MultipartFile profile) throws Exception {
	File file = new File(path);
		
		if (!file.exists()) {
			file.mkdirs();
		}		
		
		//2. 어떤 파일을 어떤 이름으로 저장?
		// 1)시간
		Calendar ca = Calendar.getInstance();
		long mil = ca.getTimeInMillis();
		String str = profile.getOriginalFilename();
		str=str.substring(str.lastIndexOf("."));
		str = mil+str;
		// 2) 객체 사용
		str=UUID.randomUUID().toString();
		str = str+"_"+profile.getOriginalFilename();
		
		//3. HDD에 저장
		// 1) transferTo
		file = new File(file, str);
		//profile.transferTo(file);
		
		// 2) FileCopyUtils
		FileCopyUtils.copy(profile.getBytes(), file);
		
		return str;
	}
	
	public boolean fileDelete(String path, String fileName) throws Exception {
		File file = new File(path, fileName);
		
		boolean check=file.delete();
		
		return check;
	}

}
