package com.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Bill")
public class Bill extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<a href='LogoutServlet'>Logout</a>");
		HttpSession ses = req.getSession(true);
		String book[] = (String[]) ses.getAttribute("bookpurch");
		String sport[] = (String[]) ses.getAttribute("sportpurch");
		pw.println("<html><body bgcolor=#aa12cc>");
		pw.println("<br>");
		pw.println("You have bought " + book.length + " books. They are<ol>");
		for (int i = 0; i < book.length; i++) {

			pw.println("<li>" + book[i]);

		}

		pw.println("</ol>");
		pw.println("<br>");
		pw.println("You have bought " + sport.length + " sports. they are<ol>");

		for (int i = 0; i < sport.length; i++) {

			pw.println("<li>" + sport[i]);
		}
		pw.println("</ol></body></html>");
		pw.close();

	}



}
