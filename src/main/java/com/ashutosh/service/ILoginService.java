package com.ashutosh.service;

import com.ashutosh.bean.Login;
import com.ashutosh.exception.InvalidMailException;
import com.ashutosh.exception.NameTooShortException;

    public interface ILoginService {
	    boolean validateLogin(Login login) throws NameTooShortException, InvalidMailException;
}