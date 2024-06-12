<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate list Bean</title>
</head>
<body>
	<% out.println("<form method='post' action='vote'>");%>
		<% for(Candidate c:list) {%>
			<%out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n",
					c.getId(),c.getName(),c.getParty());%>
		<% }%>
		<% out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");%>
</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sunbeam.beans.CandidateListBean" %>
<%@ page import="com.sunbeam.pojos.Candidate" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Candidate list Bean</title>
</head>
<body>
    <% 
        CandidateListBean candidateListBean = new CandidateListBean();
        candidateListBean.candidateList();
        List<Candidate> list = candidateListBean.getList();
    %>
    <form method='post' action='vote'>
        <% for(Candidate c : list) { %>
            <input type='radio' name='candidate' value='<%= c.getId() %>'/> <%= c.getName() %> (<%= c.getParty() %>) <br/>
        <% } %>
        <input type='submit' value='Vote'/>
    </form>
</body>
</html>
