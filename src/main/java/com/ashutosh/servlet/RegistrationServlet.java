package com.ashutosh.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashutosh.bean.Registration;
import com.ashutosh.dao.DataProcess;
import com.ashutosh.exception.InvalidMailException;
import com.ashutosh.exception.NameTooShortException;
import com.ashutosh.exception.PasswordException;
import com.ashutosh.service.IRegistrationService;
import com.ashutosh.service.RegistrationService;
import com.ashutosh.util.ConstructBean;

//@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Registration user = (Registration) req.getSession().getAttribute("user");
		if(user!=null) {
			resp.sendRedirect("./dashboard");
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Registration registration = ConstructBean.makeRegistrationBean(request);
		IRegistrationService registrationService = new RegistrationService();
		try {
			if(registrationService.validateRegistration(registration) && DataProcess.Store(registration)) {
				request.getRequestDispatcher("/success").forward(request, response);
			}
			else {
			    System.out.println("Not valid input");
				request.getRequestDispatcher("/WEB-INF/views/register.jsp").include(request, response);
			}
			
		} catch (NameTooShortException | InvalidMailException | PasswordException | SQLException e) {
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").include(request, response);
		}
	}
}