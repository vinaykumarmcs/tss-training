package com.tss.redirect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardExample")
public class ForwardExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numOne = Integer.parseInt(request.getParameter("x"));
		int numTwo = Integer.parseInt(request.getParameter("y"));
		int add = numOne + numTwo;
		request.setAttribute("sum", add);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("ForwardExampleTwo");
		requestdispatcher.forward(request, response);
	}

}