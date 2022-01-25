<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>First JSP</title>
</head>

<body>
	<h1>Hello JSP</h1>
	<ul>
		<li>Faster Deployment</li>
		<li>Easy to maintain</li>
		<li>Extension of servlet</li>
		<%!int i = 10;%>

		<%
		for (int j = 0; j < i; j++) {
		%>

		<%=j%>
		<br>

		<%
		}
		%>

		<%
		if (i % 2 == 0) {
		%>

		<%="even"%>

		<%
		} else {
		%>

		<%="odd"%>

		<%
		}
		%>


	</ul>
</body>

</html>