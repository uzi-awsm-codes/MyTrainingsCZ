package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");// MIME type
		String uname = request.getParameter("username");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String skill[]= request.getParameterValues("skill");
		out.print("<body bgcolor='cyan'><h3>Registration success</h3>");
		out.print("Name :"+uname+"<br>");
		out.print("Address:"+address+"<br>");
		out.print("Country :"+country+"<br>");
		out.print("<ul>");
		for(String s:skill) 
		{
			out.print("<li>"+s+"</li>");
		}
		out.print("</ul>");
		
	}

}






