package com.tss.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.util.Utility;

@WebServlet("/OtpGenerator")
public class OtpGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (Utility.isValidMobileNo(request.getParameter("number"))) {
			out.print(Utility.otpGenerator(10000));
		} else {
			out.print("<center><h2> Invalid Credentials</h2></center>");
		}
	}
}