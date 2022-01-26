<%@page import="dao.DbService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>View Student</title>
</head>
<style>
	tr:nth-child(even) {
		background-color: orange;
	}

	tr:nth-child(odd) {
		background-color: aqua;
	}

	table {
		text-align: center;
		width: 100%;
	}
</style>

<body align="center" bgcolor="#b3ffd9">
	<%@include file="Header.jsp"%>
	<div style="width: 50%; margin: auto;">
		<table border=1 cellspacing=0 cellpadding=5>
			<tr>
				<th>Roll No</th>
				<th>Student Name</th>
				<th>Student Password</th>
				<th>Student Department</th>
				<th></th>
				<th></th>
			</tr>
			<%
			ResultSet rs = DbService.fetchStudent();
			while (rs.next()) {
				int rno = rs.getInt(1);
				String n = rs.getString(2);
				String p = rs.getString(3);
				String d = rs.getString(4);
			%>
			<tr>
				<td><%=rno%></td>
				<td><%=n%></td>
				<td><%=p%></td>
				<td><%=d%></td>
				<td><a href="DeleteStudent?id=<%=rno%>">Delete</a></td>
				<td><a href="UpdateForm.jsp?id=<%=rno%>">Update</a></td>
			</tr>

			<%
			}
			%>
		</table>
		<%
		String message = (String) request.getAttribute("msg");
		if (message != null) {
		%>

		<h3 style="color: green; text-align: center"><%=message%></h3>

		<%
		}
		%>

	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>

</html>