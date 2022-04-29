package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.LoginDao;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		response.setContentType("text/html");// MIME type
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao loginDao = new LoginDao();
		boolean result = loginDao.validateUser(uname, password);
		if (result) {
			out.print("<b>Login Success!</b><br>"); // response of LoginServlet
			dispatcher = request.getRequestDispatcher("SuccessServlet");

			request.setAttribute("username", uname);
			dispatcher.include(request, response);

		} else {
			out.print("<b>Invalid username/password</b>");
			dispatcher = request.getRequestDispatcher("Login.html");

			dispatcher.include(request, response);

		}
	}

}
