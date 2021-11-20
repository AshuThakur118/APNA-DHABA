package com.ashutosh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashutosh.bean.Menu;
import com.ashutosh.dao.FetchCart;

//@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> restMenu = new FetchCart().ReadData();	
		String path ="/WEB-INF/views/menu.jsp"; 
		
		request.setAttribute("RESTAURANTS", restMenu);	
		request.getRequestDispatcher(path).forward(request, response);
	}
}