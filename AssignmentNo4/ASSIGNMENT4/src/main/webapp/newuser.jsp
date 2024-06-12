<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register New User</title>
</head>
<body>
	<h3>Registering New User</h3>
	<form method="post" action="register.jsp">
		First Name: <input type="text" name="firstname"/><br/><br/>
		Last Name: <input type="text" name="lastname"/><br/><br/>
		Date of Birth: <input type="date" name="birth"/><br/><br/>
		Email: <input type="text" name="email"/><br/><br/>
		Password:<input type="password" name="passwd"/><br/><br/>
		<input type="submit" value="Register"/>
		<a href="index.jsp">Sign In</a>
	</form>

</body>
</html>