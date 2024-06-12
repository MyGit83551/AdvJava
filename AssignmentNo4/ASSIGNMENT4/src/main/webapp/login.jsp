<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Beans</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="passwd"/>
	<% lb.authenticate(); %>
	<% if(lb.getUser() != null) { %>
		Welcome, <jsp:getProperty name="lb" property="email" />
		<jsp:forward page="candlist.jsp"/>
	<% } else { %>
		Login Failed.
	<% } %>
</body>
</html>
