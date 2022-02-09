<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="con" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/cdac" user="root" password="mysql" />
	<%-- 	<c:if test="${con!=null }">
		<c:out value="connection done"/>
		<sql:update dataSource="${con }"
			sql="insert into student values(108, 'Parwez', 'parwez', 'CSE', 0)"
			var="i"></sql:update>
		<c:if test="${i>0 }">
			<c:out value="Data is inserted"/>
		</c:if>
	</c:if> --%>
	<sql:query var="rs" dataSource="${con }" sql="select * from student">
	</sql:query>
	<c:forEach var="row" items="${rs.rows }">
		<c:out value="${row}" /><br>
	</c:forEach>

</body>
</html>