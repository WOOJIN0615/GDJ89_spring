package com.woojin.app.users;

import org.springframework.stereotype.Component;

@Component
public class CartDTO {
	
	private String username;
	private Long productNum;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
}
