<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Delete Candidate</title>
</head>
<body>
	<h3>${initParam.appTitle }</h3>
	<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandidateBean"/>
	<jsp:setProperty property="*" name="dcb"/>
	${dcb.deleteCandidate() }
	<c:redirect url="result.jsp"/>
	

</body>
</html>