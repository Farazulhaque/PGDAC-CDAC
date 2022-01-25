<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login JSP</title>
</head>

<body align="center" bgcolor="#b3ffd9">
	<%@include file="Header.jsp"%>
	<%
	String user = "";
	String pass = "";
	Cookie mycookie = null;
	Cookie[] mycookies = null;
	mycookies = request.getCookies();
	for (int i = 0; i < mycookies.length; i++) {
		if (mycookies[i].getName().equals("username")) {
			user = mycookies[i].getValue();
		} else if (mycookies[i].getName().equals("password")) {
			pass = mycookies[i].getValue();
		}
	}
	%>
	<form method="post" action="ValidateServlet">
		Username <input type="text" name="user" value=<%=user%>> <br>
		Password <input type="password" name="pass" value=<%=pass%>><br>
		<input type="checkbox" name="rememberme">Remember me<br>
		<input type="submit" value="login">
	</form>

	<%
	String message = (String) request.getAttribute("msg");

	if (message != null) {
	%>

	<h3 style="color: red"><%=message%></h3>

	<%
	}
	%>
	<%@include file="Footer.html"%>
</body>

</html>