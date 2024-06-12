<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Vote</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	<c:choose>
		<c:when test="${lb.user.status==0 }">
			<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"></jsp:useBean>
			<jsp:setProperty name="vb" property="candid" param="candidate"/>
			<jsp:setProperty name="vb" property="userid" value="${lb.user.id }" />
			${vb.setVote() }
			<h2>Thank You for Voting.</h2>
		</c:when>
		<c:otherwise>
			Already Voted.
		</c:otherwise>
	</c:choose>
	<a href="logout.jsp">Sign Out</a>
	
	
	
	

</body>
</html>