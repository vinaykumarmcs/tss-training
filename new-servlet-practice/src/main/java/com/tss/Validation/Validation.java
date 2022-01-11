package com.tss.Validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.util.Utility;

@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		PrintWriter writer = response.getWriter();
		if (Utility.validateEmail(email) && Utility.isValidMobileNo(number)) {
			response.sendRedirect("loginsuccessful.html");
		} else {
			writer.print("<center><h2> Invalid Credentials</h2></center>");
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Validation.html");
			reqDispatcher.include(request, response);
		}
	}
}