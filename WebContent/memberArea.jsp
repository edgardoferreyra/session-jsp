<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>memberArea</title>
</head>
<body>

<%
String username = null, sessionID = null;

if(request.getSession().getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}else{
	username = request.getSession().getAttribute("username").toString();
	sessionID = request.getSession().getId();
}

/* Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("username")){
			username = cookie.getValue();
		}
		if(cookie.getName().equals("JSESSIONID")){
			sessionID = cookie.getValue();
		}
	}
}

if(sessionID == null || username == null){
	response.sendRedirect("login.jsp");
}
*/
%>
Username: <%=username %><br/>
Current session: <%=sessionID %><br/>

<form action="<%= request.getContextPath()%>/MemberAreaController" method="get">
<input type="hidden" name="action" value="destroy">
<input type="submit" value="logout">
</form>

</body>
</html>