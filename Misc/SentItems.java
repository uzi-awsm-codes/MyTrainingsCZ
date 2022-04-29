package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SentItems
 */
@WebServlet("/CSentItems")
public class SentItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SentItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		String username = null;
		String location = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				username = cookie.getValue();
			} else if (cookie.getName().equals("location")) {
				location = cookie.getValue();
			}
		}
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Inbod</title></head><body>");
		out.print("<h1 style='margin-left:40%;'>Sent Items</h1>");
		out.print("<h2> Welcome " + username + "</h2>");
		out.print("<h2> Location " + location + "</h2>");
		out.print("<a href='CInbox'>Inbox</a>");
		out.print("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
