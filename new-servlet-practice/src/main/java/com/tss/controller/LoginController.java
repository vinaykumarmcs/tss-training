package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
	
	}

	protected void doget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if (email.equals("vinaykumar") && password.equals("vinay")) {
			out.println("<html><body><h1 align ='center'> Welcome <h1></body></html>");
		} else {
			out.println("<html><body><h1 align ='center'> error <h1></body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		if (email.equals("vinaykumar") && password.equals("vinay")) {
			out.println("<html><body><h1 align ='center'> Welcome <h1></body></html>");
		} else {
			out.println("<html><body><h1 align ='center'> error <h1></body></html>");
		}
	}

}