package com.woojin.app.users;

import com.woojin.app.files.FileDTO;

public class UserFileDTO extends FileDTO{

	private String userName;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
