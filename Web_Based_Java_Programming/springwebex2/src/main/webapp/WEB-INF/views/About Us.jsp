<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
</head>
<body>
	<%-- 
		<%
		String uname = (String) request.getAttribute("name");
		String umail = (String) request.getAttribute("email");
		%>
	--%>

	User Name: ${name}
	<br> Email: ${email}
	<br>${name eq email }
	<c:set var="x" value="10" />
	<br>
	<c:if test="${x>=10 }">
		<c:out value="value of x is ${x} " />
	</c:if>
	<br>
	<c:forEach begin="1" end="10" step="2" var="i">
		<c:out value="${i}"></c:out>
	</c:forEach>
	<br>
	<c:set value="12" var="age" />
	<c:choose>
		<c:when test="${age>=18}">
			<c:out value="valid age to cast vote"></c:out>
		</c:when>
		<c:when test="${age<18 }">
			<c:out value="Invalid age to cast vote"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="you are in other universe"></c:out>
		</c:otherwise>
	</c:choose>
	<c:set var="name" value="Faraz" />
	<c:set var="lname" value="Haque" />
	<br>
	<c:if test="${fn:endsWith(name, 'az') }">
		<c:out value="ends with az"></c:out>
		<c:out value="length is = ${fn:length(name)}"></c:out>
	</c:if>
	<br>
	<c:set var="tax" value="30000.6789" />
	<fmt:parseNumber integerOnly="true" type="number" value="${tax}"
		var="t"></fmt:parseNumber>
	Tax is ${t}
	<br>
	<c:set var="tdate" value="02-09-2022"></c:set>
	<fmt:parseDate value="${tdate}" var="parseddate" pattern="dd-MM-yyyy" />
	Date is ${parseddate }
	<br>
	<c:set var="today" value="<%=new Date()%>"></c:set>
	<fmt:formatDate value="${today}" type="time" var="tt" />
	<fmt:formatDate value="${today}" type="date" var="dt" />
	<fmt:formatDate value="${today}" type="time" var="stt"
		timeStyle="short" />
	<fmt:formatDate value="${today}" type="date" var="mtt"
		dateStyle="medium" />
	<fmt:formatDate value="${today}" type="both" var="ndt"
		dateStyle="short" timeStyle="medium" />
	<br> Time is ${tt }
	<br> Date is ${dt }
	<br> Short time is ${stt }
	<br> Medium date is ${mtt }
	<br> Date and time both is ${ndt }

</body>
</html>