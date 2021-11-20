package com.ashutosh.bean;

public class Registration {
	private String userName;
	private String email;
	private String passWord;
	private String gender;
	
	public Registration() {}

	public Registration(String userName, String email, String passWord, String gender) {
		super();
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", email=" + email + ", passWord=" + passWord + ", gender="
				+ gender + "]";
	}
}