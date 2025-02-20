package com.woojin.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woojin.app.Sample;


public class UserDAOTest extends Sample {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void joinTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("idtyr");
		userDTO.setPassword("test");
		userDTO.setName("name");
		userDTO.setPhone("1111");
		userDTO.setEmail("comkjf");
		
		int result = userDAO.join(userDTO);
		
		//단정문 assert
		assertEquals(1, result);
	}

}
