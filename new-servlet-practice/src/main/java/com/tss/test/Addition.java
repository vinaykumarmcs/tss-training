package com.tss.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Addition")
public class Addition extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int numOne = Integer.parseInt(request.getParameter("numOne"));
		int numTwo = Integer.parseInt(request.getParameter("numTwo"));
		int sum = numOne + numTwo;
		PrintWriter output = response.getWriter();
		output.println("The Answer :" + sum);
	}
}