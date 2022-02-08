<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Contact Us</title>
</head>

<body>
	Address :
	<%
String addr = (String) request.getAttribute("address");
%>
	<%=addr%>
	<br>
	Mobile :
	<%
	String mobile = (String) request.getAttribute("mobile");
	%>
	<%=mobile%>
	<br>
	Email:
	<%
	String email = (String) request.getAttribute("email");
	%>
	<%=email%>


</body>

</html>