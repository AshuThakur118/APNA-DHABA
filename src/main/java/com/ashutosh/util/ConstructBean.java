package com.ashutosh.util;

import javax.servlet.http.HttpServletRequest;

import com.ashutosh.bean.Login;
import com.ashutosh.bean.Registration;

public class ConstructBean {
	public static Registration makeRegistrationBean(HttpServletRequest request) {
		Registration reg = new Registration();
		reg.setUserName(request.getParameter("usrName"));
		reg.setPassWord(request.getParameter("pasWord"));
		reg.setEmail(request.getParameter("email"));
		reg.setGender(request.getParameter("gender"));
		
		return reg;
	}
	
	public static Login makeLoginBean(HttpServletRequest request) {
		Login login = new Login();
		login.setUserName(request.getParameter("usrName"));
		login.setPassWord(request.getParameter("pasWord"));
		
		return login;	
	}
}