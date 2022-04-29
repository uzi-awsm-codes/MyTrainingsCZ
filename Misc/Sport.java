package com.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Sport")
public class Sport extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		pw.print("Session id="+session.getId()+"<br>");
		pw.print("Session is new="+session.isNew()+"<br>");
		String uname=(String) session.getAttribute("username");
		pw.print(uname);
		String str[] = request.getParameterValues("s1");
		session.setAttribute("sportpurch", str);
		pw.println("<a href=\"Bill\">Go For Billing</a>");
		pw.close();

	}

	
}
