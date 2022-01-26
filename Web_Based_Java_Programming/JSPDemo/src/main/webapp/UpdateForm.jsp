<%@page import="dao.DbService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>

<body align="center" bgcolor="#b3ffd9">
	<%@include file="Header.jsp"%>
	<div style="width: 100%; height: 500px">

		<%--Sir's Solution --%>
		<%
		String rollno = request.getParameter("id");
		session.setAttribute("id", rollno);
		%>
		<form action="Update.jsp" method="post">
			Name: <input type="text" name="uname"><br>
			Password: <input type="text" name="upass"><br>
			Student Dept <select name="udept">
				<option value="CS"> CS </option>
				<option value="IT"> IT </option>
				<option value="ECE"> ECE </option>
				<option value="ME"> ME </option>
			</select>
			<input type="submit" value="Update">
		</form>

		<%--My Solution --%>
		<%--
		<%
		int id = Integer.parseInt(request.getParameter("id"));
		ResultSet rs = DbService.fetchStudent(id);
		while (rs.next()) {
			int rno = rs.getInt(1);
			String n = rs.getString(2);
			String p = rs.getString(3);
			String d = rs.getString(4);
		%>
		<form action="UpdateServlet" method="post">
			<input type="text" name=uid value=<%=rno%> hidden><br>
			Name: <input type="text" name="uname" value=<%=n%>><br>
			Password: <input type="text" name="upass" value=<%=p%>><br>
			Department: <input type="text" name="udept" value=<%=d%>><br>
			<input type="submit" value="Update">
		</form>
		<%
		}
		%>
		--%>


	</div>
	<%@include file="Footer.html"%>

</body>

</html>