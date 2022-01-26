<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Beans Example 2</title>
</head>

<body>
	<jsp:useBean id="studentobj" class="mybeans.Student" scope="request"></jsp:useBean>
	<jsp:getProperty property="name" name="studentobj" />
	<jsp:getProperty property="id" name="studentobj" />
	<jsp:getProperty property="password" name="studentobj" />
	<jsp:getProperty property="dept" name="studentobj" />
</body>

</html>