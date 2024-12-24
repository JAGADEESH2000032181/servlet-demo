package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/processForm")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		response.setContentType("text/html");
		
		response.getWriter().println("<h1>Form Submitted Successfully</h1>");
		response.getWriter().println("<p>Name: " + name +"</p>");
		response.getWriter().println("<p>Name: " + email +"</p>");
		
	}

}
