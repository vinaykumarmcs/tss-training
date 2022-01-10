package com.tss.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardExampleTwo")
public class ForwardExampleTwo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sum = (int) request.getAttribute("sum");
		float average = (float) (sum / 2.0);
		PrintWriter out = response.getWriter();
		out.println("Sum is: " + sum);
		out.println("Average is: " + average);

	}

}