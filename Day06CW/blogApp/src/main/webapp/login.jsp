<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*"/>
	${ lb.authenticate() }
	
			<h3>${initParam.appTitle}</h3>
			Hello, ${lb.email} <br/>
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>		
		
</body>
</html>