package com.ashutosh.service;

import com.ashutosh.bean.Login;
import com.ashutosh.exception.InvalidMailException;
import com.ashutosh.exception.NameTooShortException;

public class LoginService implements ILoginService {
	public boolean validateLogin(Login login) 
			throws NameTooShortException, InvalidMailException{

			if(login.getUserName().length() < 6) {
				throw new NameTooShortException("UserName char should > 6!!" + login.getUserName()); 
			}			
			return true; 
		}
}