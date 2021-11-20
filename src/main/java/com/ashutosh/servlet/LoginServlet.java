package com.ashutosh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashutosh.bean.Login;
import com.ashutosh.dao.DataProcess;
import com.ashutosh.exception.InvalidMailException;
import com.ashutosh.exception.NameTooShortException;
import com.ashutosh.service.ILoginService;
import com.ashutosh.service.LoginService;
import com.ashutosh.util.ConstructBean;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Login login = (Login) req.getSession().getAttribute("user");
		if(login!=null) {
			resp.sendRedirect("./dashboard");
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Login login = ConstructBean.makeLoginBean(request);
			ILoginService loginService = new LoginService();
			if(loginService.validateLogin(login) && DataProcess.Fetch(login)) {
				request.getSession().setAttribute("user", login);
				response.sendRedirect("./dashboard");
			}
			else {		
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response);
			}
		} 
		catch (NameTooShortException | InvalidMailException | ServletException | IOException e) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response);
		}
	}
}