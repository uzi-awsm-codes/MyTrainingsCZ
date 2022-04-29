package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigDemo
 */
@WebServlet(urlPatterns = { "/ServletConfigDemo" }, initParams = {
		@WebInitParam(name = "citizenship", value = "Indian") })
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String citizen;
	ServletContext context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConfigDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		citizen = config.getInitParameter("citizenship");
		context=config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.print("<h3>Init parameter value ="+citizen+"</h3>");
		out.print("<h3>Context parameter value ="+context.getInitParameter("company")+"</h3>");
	}
	
	
	

}
