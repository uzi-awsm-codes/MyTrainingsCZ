package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
    String citizen;
    ServletContext context;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifeCycleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method called count="+count);
		citizen = config.getInitParameter("citizenship");
		context=config.getServletContext();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy method called");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet method called");
		PrintWriter out = response.getWriter();
		count++;
		response.setContentType("text/html");// MIME type
		out.print("<h3>Init parameter value of ServletCofigDemo servlet="+citizen+"</h3>");
		out.print("<body bgcolor='cyan'><b>Request processed "+count+"times </b></body");
		out.print("<h3>Context parameter value ="+context.getInitParameter("company")+"</h3>");
	}

}
