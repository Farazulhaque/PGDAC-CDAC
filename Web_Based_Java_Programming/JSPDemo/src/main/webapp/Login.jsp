<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login JSP</title>
</head>

<body align="center">
	<%@include file="Header.jsp"%>
	<form method="post" action="ValidateServlet">
		Username <input type="text" name="user"> <br>
		Password <input type="password" name="pass"><br>
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