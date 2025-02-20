package com.woojin.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public int join(UserDTO userDTO) throws Exception {
		int result = userDAO.join(userDTO);
		
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
	
	public int update(UserDTO userDTO) throws Exception {
		int result = userDAO.update(userDTO);
		
		return result;
	}

}
