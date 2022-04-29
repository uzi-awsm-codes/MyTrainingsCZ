<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
html,body
{
height:100%;
}
td
{
border:2 pxsolid blue;
}
table
{
border:2 px solid red;
}
</style>
</head>
<jsp:useBean id="userBean" class="com.bean.Employee" scope="request" />
<body>
<div>
<%String designation=request.getParameter("designation");
if (designation.equals("1"))
{
%>
<jsp:include page="managerHeading.jsp">
<jsp:param value="<%=userBean.getfName() %>" name="name"/>
</jsp:include>
<%
}
else if(designation.equals("2"))
{
%>
<jsp:include page="traineeHeading.jsp">
<jsp:param value="<%=userBean.getfName()%>" name="name"/>
</jsp:include>
<%}
else
{
%>
	<jsp:include page="developerHeading.jsp">
	<jsp:param value="<%=userBean.getfName()%>" name="name"/>
	</jsp:include>
<%} %>
</div>
<h1 style="color:green;"><%=request.getParameter("message") %></h1>
<h1>Registration Details</h1>
First Name <jsp:getProperty property="fName" name="userBean"/><br>
Last Name <jsp:getProperty property="lName" name="userBean"/><br>
User Name <jsp:getProperty property="uName" name="userBean"/><br>
<%String hobbies[]=userBean.getHobbies();%>
Hobbies
<% for(String s:hobbies)
	{
	out.print(s);
	}%>

</body>
</html>