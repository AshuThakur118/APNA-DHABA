package com.ashutosh.service;

import java.util.regex.Pattern;

import com.ashutosh.bean.Registration;
import com.ashutosh.exception.InvalidMailException;
import com.ashutosh.exception.NameTooShortException;
import com.ashutosh.exception.PasswordException;

public class RegistrationService implements IRegistrationService {
	
	public static boolean emailPatternMatching(String email, String regexPattern) {
	    return Pattern.compile(regexPattern).matcher(email).matches();
	}
	public boolean validateRegistration(Registration registration)
			throws NameTooShortException, InvalidMailException, PasswordException {
		
		if (registration.getUserName().length() >= 6 &&
			emailPatternMatching(registration.getEmail(), "^(.+)@(\\S+)$")) {
			return true;
		} else {
			return false;
		}
	}
}