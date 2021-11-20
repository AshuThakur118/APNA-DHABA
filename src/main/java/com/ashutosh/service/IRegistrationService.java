package com.ashutosh.service;

import com.ashutosh.bean.Registration;
import com.ashutosh.exception.InvalidMailException;
import com.ashutosh.exception.NameTooShortException;
import com.ashutosh.exception.PasswordException;

public interface IRegistrationService {
	boolean validateRegistration (Registration reg) throws NameTooShortException, 
    InvalidMailException, PasswordException;
}