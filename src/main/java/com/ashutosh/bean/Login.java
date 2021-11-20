package com.ashutosh.bean;

import javax.validation.constraints.Size;

public class Login {
	@Size(min=6,message="Username should be greater than 6")
	private String userName;
	private String passWord;	
	
	public Login() {}

	public Login(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", passWord=" + passWord + "]";
	}
}