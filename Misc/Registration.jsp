<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<jsp:useBean id="userBean" class="com.bean.Employee" scope="request"/>
<jsp:setProperty property="*" name="userBean"/>
<% if (request.getParameter("register")!=null)
	{
%>
<jsp:forward page="success.jsp">
<jsp:param value="Registration successful" name="message"/>
</jsp:forward>	
<%}	%>
<body>
<h2 style="font-size; 20 px;">Enter Details</h2>
<form method="post">
First Name <input type="text" name="fName"/><br>
Last Name <input type="text" name="lName"/><br>
User Name <input type="text" name="uName"/><br>
Gender
<input type="radio" name="gender" value="Male"/>Male<br>
<input type="radio" name="gender" value="Female"/>Female<br>
Hobbies
<input type="checkbox" name="hobbies" value="Reading books"/>Reading Books
<input type="checkbox" name="hobbies" value="Music"/>Music
<input type="checkbox" name="hobbies" value="Painting"/>Painting<br>
Designation
<select name="designation">
<option selected="selected">---Select---</option>
<option value="1">Manager</option>
<option value="2">Trainee</option>
<option value="3">Developer</option>
</select><br>
<input type="submit" value="Register" name="register"/>

</form>
</body>
</html>