<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DbFactory"%>
<%@page import="dao.IDbService"%>
<%@page import="dao.DbService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Working with Cascading Dropdown using Ajax</title>
	<style>
		div {
			width: 45%;
			margin: auto;
			line-height: 20px;
			font-size: 20px;
		}

		label {
			float: left;
			width: 40%;
		}

		input[type="text"],
		input[type="password"],
		select {
			font-size: 18px;
			width: 50%;
			height: 1.8em;
			line-height: 2em;
			outline: none;
			border: none;
			border-bottom: 1px solid black;
		}

		#btn {
			width: 150px;
			height: 50px;
			text-align: center;
			display: grid;
			margin: auto;
			margin-top: 20px;
			border: 1px solid rgb(139, 129, 129);
			border-radius: 10px;
			cursor: pointer;
			line-height: 20px;
			font-size: 20px;
		}

		#btn:hover {
			border: 1px solid rgb(70, 34, 34);
			color: rgb(1, 39, 1);
		}

		input[type="checkbox"] {
			width: 20px;
			margin: 0;
		}

		p {
			text-align: center;
			font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
		}
	</style>
</head>
<script type="text/javascript">
	function disappearMsg() {
		document.getElementById("success_msg").innerHTML = "";
		console.log("message appeared");
	}
	setTimeout(disappearMsg, 3000);

	function getCity() {
		var stateid = document.getElementById("ddlState").value;
		var ajax = new XMLHttpRequest();
		var url = "GetCity?s_id=" + stateid;
		ajax.onreadystatechange = function () {
			if (ajax.readyState == 4) {
				document.getElementById("ddlCity").innerHTML = ajax.responseText;
			}
		};
		ajax.open("GET", url, true);
		ajax.send(null);
	}
</script>

<body>
	<h2 style="text-align: center; color: green">Working with
		Cascading Dropdown using Ajax</h2>
	<hr color="red" size="5" />
	<div>
		<form method="post" action="RegisterUser">

			<label for="fname">Full Name:</label> <input type="text" name="fname" id="fname"> <br> <br>

			<label for="txtUser">UserName:</label> <input type="text" name="txtUser" id="txtUser"> <br> <br>

			<label for="txtPass">Password:</label> <input type="password" name="txtPass" id="txtPass"> <br> <br>

			<label for="txtCPass">Confirm Password:</label> <input type="password" name="txtCPass" id="txtCPass"> <br>
			<br>

			<label for="ddlState">State:</label> <select name="ddlState" id="ddlState" onchange="getCity()">
				<option value="-1">----------------SelectState----------------</option>

				<%
				IDbService service = DbFactory.getDbService();
				ResultSet rs = service.fetchData("select * from state_master");
				while (rs.next()) {
				%>

				<option value=<%=rs.getString(1)%>><%=rs.getString(2)%></option>
				<%
				}
				%>
			</select> <br> <br>

			<label for="ddlCity">City:</label> <select name="ddlCity" id="ddlCity">
				<option value="-1">----------------SelectCity-----------------</option>

			</select> <br>

			<p>
				<input type="checkbox"> I accept terms and condition
			</p>
			<input type="submit" name="submitbtn" id="btn" value="Register Me">
			<br> <input type="submit" name="displaybtn" id="btn" value="Display Data" formaction="TableView.jsp"> <br>
		</form>
		<br>


		<p style="color: green;">
			<%
				HttpSession hs = request.getSession(false);
				String msg = (String)hs.getAttribute("msg");
				if(msg!=null){
			%>
			<h2 id="success_msg"><%=msg %></h2>
			<%
				hs.setAttribute("msg", "");
				}
			%>
		</p>

	</div>
</body>

</html>