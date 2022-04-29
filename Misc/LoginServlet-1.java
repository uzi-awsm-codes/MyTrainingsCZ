package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher=null;
		response.setContentType("text/html");// MIME type
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		if (uname.equals("admin") && password.equals("admin@123"))
		{
			out.print("<b>Welcome to our site</b>"); //response of LoginServlet
			dispatcher=request.getRequestDispatcher("SuccessServlet");
			//dispatcher.forward(request,response);
			dispatcher.include(request,response);
		}
		else
		{
			out.print("<b>Invalid username/password</b>"); // response of LoginServlet
			dispatcher=request.getRequestDispatcher("Login.html");
			//dispatcher.forward(request,response);
			dispatcher.include(request,response);
		}
	}

}
