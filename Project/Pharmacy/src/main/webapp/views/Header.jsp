<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
		integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
	<link rel="stylesheet" href="css/mystyle.css" />
	<script src="js/myscript.js"></script>
</head>

<body class="">
	<!-- header section -->
	<header class="container-fluid row" id="headertop">
		<!-- logo -->
		<div class="col-3">
			<a href="/home"> <img src="./image/logo1.png" alt="@logo" height="auto" width="200px" /></a>
		</div>

		<!-- search -->
		<div class="col-5 mt-3 search-container">
			<form class="d-flex input-group" action="/search">
				<input onkeyup="search()" class="form-control me-2" type="search" id="search-input" name="query"
					placeholder="Search" aria-label="Search" />
				<div class="input-group-append">
					<button class="btn btn-" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</form>
			<div class="search-result">
				<p id="search-item"></p>

			</div>

		</div>

		<!-- accountSec    -->
		<div class="accountSec col-3 mt-3 navbar-expand-lg" id="acctTop">
			<button class="btn dropdown-toggle float-lg-right float-md-right" type="button" data-toggle="dropdown"
				aria-expanded="false">
				<i class="fas fa-user">Account</i>
			</button>
			<ul class="dropdown-menu">
				<li><a href="/UserLogin">LOGIN</a></li>
				<li><a href="/UserSignup">SIGNUP</a></li>

				<li>
					<hr class="dropdown-divider" />
				</li>
				<li><a class="dropdown-item" href="#">SELLER</a></li>
			</ul>
		</div>

		<!-- cart -->
		<div class="container-fluid col-1 mt-3">
			<form>
				<button formaction="/cart" class="btn" onclick="updateCart();"><i class="fas fa-cart-plus"></i>
					<span id="cart-items">
						<sup>

						</sup>
					</span>
				</button>
			</form>
		</div>
	</header>

	<!-- nav bar -->
	<nav class="navbar navbar-expand-lg navbar-light nav-bgcolor CustmPadingMargin" id="top_nav">
		<div class="container-fluid">
			<!-- nav hide on big screen -->
			<div id="navhide" class="container-fluid ml-auto">
				<div class="row container-fluid" id="uperrow">
					<!-- togler button -->
					<div class="col-2" id="navtoglerbtn">
						<button class="navbar-toggler align-self-start border-0 bg-white rounded" type="button">
							<span class="navbar-toggler-icon"></span>
						</button>
					</div>

					<!-- logo nav-->
					<div class="col-4" id="navlogo">
						<div class="mobnavlogobg" id="logonav">
							<a href="/home"> <img src="./image/logo1.png" alt="@logo" height="auto" width="100px" /></a>
						</div>
					</div>

					<!-- cart nav -->
					<div class="col-2 offset-4 justify-content-around" id="navcart">
						<a href="cart.html" class="btn" role="button"><i class="fas fa-cart-plus"></i>
							<sup><span id="item-count"></span></sup>
						</a>
					</div>
				</div>

				<!-- search nav -->
				<div class="container-fluid mt-1 ml-auto row" id="navhide">
					<form class="d-flex input-group" id="searchnav" action="/search">
						<input class="form-control me-2" type="search" name="query" placeholder="Search"
							aria-label="Search" />
						<div class="input-group-append">
							<button class="btn btn-" type="submit">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</form>

					<div class="search-result"></div>
				</div>
			</div>

			<div class="collapse navbar-collapse p-3 p-lg-0 mt-lg-0 d-flex flex-column flex-lg-row flex-xl-row justify-content-lg-end mobileMenu"
				id="navbarSupportedContent">
				<ul class="navbar-nav align-self-stretch navUl">
					<a class="btnclsnav" id="navhide"> <img alt="logo" src="./image/Closeicon.png" height="30px"
							width="30px" />
					</a>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="/home"> <i
								class="fa fa-home"></i>Home
						</a></li>
					<li class="nav-item"><a class="nav-link" href="Adeel/Product.html"><i
								class="fa fa-store"></i>Shop</a></li>
					<li class="nav-item"><a href="./aboutus.html" class="nav-link" role="button">About Us</a></li>
					<li class="nav-item"><a href="contactus.html" class="nav-link" role="button"><i
								class="fa fa-address-book"></i>Contact Us</a></li>
					<!-- accountSec after size decrease -->
					<li class="nav-item" id="accountSec">
						<button class="btn dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
							<i class="fas fa-user"></i>ACCOUNT
						</button>
						<ul class="dropdown-menu">
							<li><a href="./login.html">LOGIN</a></li>
							<li><a href="./signup.html">SIGNUP</a></li>

							<li>
								<hr class="dropdown-divider" />
							</li>
							<li><a class="dropdown-item" href="#">SELLER</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="overlay"></div>

	<!-- <script type="text/javascript">
		function search() {
			let query = $("#search-input").val();
			console.log(query);
			var ajax = new XMLHttpRequest();
			var url = "processAJAX?query=" + query
			ajax.onreadystatechange = function () {
				if (ajax.readyState == 4) {
					document.write(ajax.responseText);
					//document.getElementById("search-item").innerHTML = ajax.responseText;
				}
			};
			ajax.open("GET", url, true);
			ajax.send(null);

		}

		const search = () => {
			// console.log("searching...");
			let query = $("#search-input").val();

			if (query == '') {
				$(".search-result").hide();
			} else {
				console.log(query);
				var opt = {
					url: "http://localhost:8282/processAJAX?query=" + query,
					method: "GET"
				}
				var ajax = new XMLHttpRequest();
				$.ajax(opt).done(function (data) {
					for (var i = 0; i < data.length; i++) {
						document.getElementById("search-item").innerHTML += data[i].medicineName + "<br>";
					}
				})
				var ajax = new XMLHttpRequest();
				var url = "/processAJAX?query=" + query;
				ajax.onreadystatechange = function () {
					if (ajax.readyState == 4) {
						alert(ajax.responseText);
						document.getElementById("search-item").innerHTML = ajax.responseText + "<br>";
					}
				};
				ajax.open("GET", url, true);
				ajax.send(null);

				var request = new XMLHttpRequest();
				request.open("GET", "http://localhost:8282/processAJAX?query=" + query);
				request.onreadystatechange = function () {
					// Check if the request is compete and was successful
					if (this.readyState === 4 && this.status === 200) {
						// Inserting the response from server into an HTML element
						document.getElementById("search-item").innerHTML += this.responseText;
					}
				};

				request.send();
				console.log()
				$(".search-result").show()

			}
		};
	</script> -->
</body>

</html>