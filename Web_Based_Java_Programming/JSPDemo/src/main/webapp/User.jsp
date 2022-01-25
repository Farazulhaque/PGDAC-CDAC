<%@page import="dao.DbService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	info="This page is created by Faraz" buffer="16kb" language="java"
	isThreadSafe="true" isELIgnored="false" pageEncoding="ISO-8859-1"
	errorPage="MyErrorPage.jsp"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>User JSP</title>
</head>

<body>
	<%@include file="Header.jsp"%>
	<div style="width: 100%; height: 500px; background-color: #8899ff">
		<%
		String uname = request.getParameter("sname");
		String password = request.getParameter("spass");
		int rollno = Integer.parseInt(request.getParameter("sroll"));
		String dept = request.getParameter("sdept");
		int i = DbService.insertData(rollno, uname, password, dept);
		if (i > 0) {
		%>
		<h1><%="SignUp is successfull"%></h1>
		<%
		} else {
		response.sendRedirect("Login.jsp");
		}
		%>
	</div>
	<%@include file="Footer.html"%>

</body>

</html>