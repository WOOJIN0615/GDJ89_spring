package com.woojin.app.robots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.woojin.app.parts.Arm;
import com.woojin.app.parts.LeftArm;
import com.woojin.app.parts.RightArm;


public class Robot {



	private LeftArm la;
	private RightArm ra;
	private String name;
	private Integer age;
	
	public Robot(LeftArm la, RightArm ra, String name, Integer age) {
		this.la = la;
		this.ra = ra;
		this.name = name;
		this.age = age;
	}
	
	public LeftArm getLa() {
		return la;
	}
	
	public void setLa(LeftArm la) {
		this.la = la;
	}
	
	public RightArm getRa() {
		return ra;
	}
	
	public void setRa(RightArm ra) {
		this.ra = ra;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void attack() {
		this.la.punch();
		this.ra.punch();
	}
	
}
