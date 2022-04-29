<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>


   <body>
      <c:set var = "mark" scope = "session" value = "${50}"/>
      <p>Your mark is : <c:out value = "${mark}"/></p>
      <c:choose>
         
         <c:when test = "${mark <80}">
            Grade is B
         </c:when>
         
         <c:when test = "${mark >=80}">
            Grade is A
         </c:when>
         
         <c:otherwise>
           Invalid
         </c:otherwise>
      </c:choose>
   
   </body>
</html> 
