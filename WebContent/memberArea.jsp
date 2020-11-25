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
Cookie[] cookies = request.getCookies();
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
%>
Username: <%=username %><br/>
Current session: <%=sessionID %><br/>
memberArea!!

</body>
</html>