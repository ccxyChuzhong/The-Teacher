package com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.service.loginserviceimp;

public class insertservlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		loginserviceimp serviceimp = new loginserviceimp();
		List<Map> list = serviceimp.query(id, name);
		if(list.size() == 0) {
			request.getRequestDispatcher("/reg.html").forward(request, response);
			serviceimp.insert(id, name,sex,age);
		}else {
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
