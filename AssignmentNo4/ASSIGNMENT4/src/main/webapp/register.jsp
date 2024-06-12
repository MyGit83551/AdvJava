<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.RegistrationBean"/>
	<jsp:setProperty name="lb" property="firstname" param="firstname"/>
	<jsp:setProperty name="lb" property="lastname" param="lastname"/>
	<jsp:setProperty name="lb" property="birth" param="birth"/>
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="passwd"/>
	<% lb.registerUser(); %>
	<% if(lb.getUser() != null) { %>
		Login Successful!
		<jsp:forward page="index.jsp"/>
	<% } else { %>
		Login Failed.Enter Valid Details!
	<% } %>

</body>
</html>