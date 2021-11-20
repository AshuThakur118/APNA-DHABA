package com.ashutosh.exception;

public class PasswordException extends Exception {
	private String msg; 	
	public PasswordException() {
		this.msg = "Invalid Password"; 
	}

	public PasswordException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "PasswordException [msg=" + msg + "]";
	}
}