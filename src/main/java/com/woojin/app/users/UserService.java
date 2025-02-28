package com.woojin.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.files.FileUpload;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FileUpload fileUpload;
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception {
		int result=userDAO.join(userDTO);
		
		if (profile.isEmpty()) {
			return result;
		}
		
		//1. 어디에 저장할 것인가
		UserFileDTO userFileDTO = save(context, profile, userDTO);
		result=userDAO.upload(userFileDTO);
		
		return result;
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		UserDTO result = userDAO.detail(userDTO);
		
		if (result!=null) {
			if (result.getPassword().equals(userDTO.getPassword())) {
				return result;
			}
		}
		
		return null;
	}
	
	public UserDTO detail(UserDTO userDTO) throws Exception {
		userDTO = userDAO.detail(userDTO);
		
		return userDTO;
	}
	
	public int update(UserDTO userDTO, MultipartFile profile, ServletContext context, HttpSession session) throws Exception {
		int result = userDAO.update(userDTO);
		if (!profile.isEmpty()) {
			UserFileDTO userFileDTO = save(context, profile, userDTO);
		}
		
		if (result==0) {
			result = userDAO.update(userDTO);
		}
		
		userDTO = userDAO.detail(userDTO);
		session.setAttribute("user", userDTO);
		
		return result;
	}
	
	private UserFileDTO save(ServletContext context, MultipartFile profile, UserDTO userDTO) throws Exception {
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
		String str = fileUpload.fileUpload(path, profile);
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUserName(userDTO.getUsername());
		userFileDTO.setFileName(str);
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		return userFileDTO;
	}

}
