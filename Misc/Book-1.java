package com.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Book")
public class Book extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession(true);
		out.print("Session id="+session.getId()+"<br>");
		out.print("Session is new="+session.isNew()+"<br>");
		String uname=(String) session.getAttribute("username");
		out.print(uname);
		String str[] = request.getParameterValues("s1");
		if (str != null) {

			session.setAttribute("bookpurch", str);
			out.println("Thank you for selecting <br>");
			out.println("Visit our sportsshop");
			out.println("<a href = \"Sport.html \">sportshop</a>");
			out.close();
		} else {

			out.println("You have not selected anything");
			out.println("Visit to sports shop");
			out.println("<a href=\"Sport.html \">sportshop</a>");
		}
	}

	
}
