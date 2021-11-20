package com.ashutosh.exception;

public class InvalidMailException extends Exception {
	private String msg; 
	public InvalidMailException() {
		this.msg = "Invalid email"; 
	}

	public InvalidMailException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidMailException [msg=" + msg + "]";
	}
}