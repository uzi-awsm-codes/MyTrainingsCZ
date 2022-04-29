<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page session="true" %>
<%@page buffer="8kb" %>
<%@page errorPage="errorPage.jsp" %>
<%@page import="java.util.Date" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
body,html
{
height:100%;
}
</style>
</head>
<%String name=request.getParameter("name");
if(name==null || "".equals(name))
{throw new Exception("Name is empty");
	}
Date date=new Date();
%>
<body>
<div id="header" style=background-color:blue;height:20%;">
<%@include file="header.html"%>
</div>
Curent Date<%=date%>
<div id="content" style=background-color:gray;height:70%;text-align:center;">
<br/>
<span style="color:green;font-size:100px;">Welcome<%=name %></span>
</div>
<div 
style="height:12%;bottom:0;position:relative;">
<%@include file="footer.html"%></div>
</body>
</html>