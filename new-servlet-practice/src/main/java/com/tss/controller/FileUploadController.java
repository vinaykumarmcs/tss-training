package com.tss.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tss.util.Utility;
import javax.servlet.annotation.*;

@WebServlet("/fileupLoadController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024
		* 100)
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Part filePart = request.getPart("file");
		if (Utility.fileUpload(filePart)) {
			response.getWriter().print("The file uploaded sucessfully");
		}
	}
}