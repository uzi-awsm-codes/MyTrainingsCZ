<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head></head>
   <body>
      <c:set var = "salary" scope = "session" value = "${1000}"/>
      <c:if test = "${salary > 2000}">
         <p>My salary is:  <c:out value = "${salary}"/><p>
      </c:if>
       <c:if test = "${salary < 2000}">
         <p>My salary is less than 2000 </p>
      </c:if>
   </body>
</html>
