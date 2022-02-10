<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<style>
	table {
		width: 70%;
		margin: auto;
		margin-top: 5%;
		padding: 10px;
		border: 2px solid black;
		border-collapse: collapse;
	}

	tr,
	td {
		border: 1px solid black;
	}

	input[type="text"],
	td {
		font-size: 18px;
		width: 200px;
		height: 1.6em;
		line-height: 1.6em;
		outline: none;
		border: none;
	}

	th {
		border-bottom: 2px solid black;
		font-weight: bold;
	}

	td {
		padding: 5px;
	}
</style>

<body>
	<h2 style="text-align: center; color: green">Please Enter Details</h2>
	<hr color="red" size="5" />

	<form method="post">
		<table>
			<thead>
				<tr>

					<th><input type="text" placeholder="Full Name" id="fname" name="fname" onkeyup="getData(this.id)"
							autofocus="autofocus"></th>
					<th><input type="text" placeholder="User Name" id="uname" name="uname" onkeyup="getData(this.id)">
					</th>
					<th><input type="text" placeholder="State Name" id="state" name="state" onkeyup="getData(this.id)">
					</th>
					<th><input type="text" placeholder="City Name" id="city" name="city" onkeyup="getData(this.id)">
					</th>

				</tr>
			</thead>
			<tbody id="userData">


			</tbody>

		</table>
	</form>

	<p id="result"></p>

	<script>
		var fullname = "",
			username = "",
			state = "",
			city = "";

		function getData(id) {
			if (id == "fname") {
				fullname = document.getElementById(id).value;
			}
			if (id == "uname") {
				username = document.getElementById(id).value;
			}
			if (id == "state") {
				state = document.getElementById(id).value;
			}
			if (id == "city") {
				city = document.getElementById(id).value;
			}
			var str = "Full Name: " + fullname + "<br>User Name: " + username +
				"<br>State    : " + state + "<br>City     : " + city;
			document.getElementById("result").innerHTML = str;
			var ajax = new XMLHttpRequest();
			var url = "DisplayData?fullname=" + fullname + "&username=" +
				username + "&state=" + state + "&city=" + city;
			// document.getElementById("result").innerHTML += url;
			ajax.onreadystatechange = function () {
				if (ajax.readyState == 4) {
					//alert(ajax.responseText)
					document.getElementById("userData").innerHTML = ajax.responseText;
				}
			};
			ajax.open("GET", url, true);
			ajax.send(null);

		}
	</script>
</body>

</html>