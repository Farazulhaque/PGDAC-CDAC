<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HOME</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />
<link rel="stylesheet" href="/css/mystyleadmin.css" />
<script src="/js/myjScriptadmin.js"></script>
</head>

<body>


	<!-- nav section -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark p-0">
		<div class="container">
			<a href="/homeseller" class="navbar-brand bg-white my-1"> <img
				src="/image/logo.png" alt="@logo" height="40px" width="auto">
			</a> <a href="/homeseller" class="navbar-brand">Seller Pannel</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav">
					<li class="nav-item px-2"><a href="/homeseller"
						class="nav-link active">Dashboard</a></li>
					<li class="nav-item px-2"><a href="/sellerOrderPage"
						class="nav-link">Order</a></li>
					<li class="nav-item px-2"><a href="/sellerMedicineManager"
						class="nav-link">Medicine Manager</a></li>

				</ul>

				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown mr-3"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown">
							<i class="fas fa-user"></i> Welcome ${logedinSeller.fullName}
					</a>
						<div class="dropdown-menu">
							<a href="/sellerProfile" class="dropdown-item"> <i
								class="fas fa-user-circle"></i> Profile
							</a> 
							<a href="/sellerSettings" class="dropdown-item"> 
							<i
								class="fas fa-cog"></i> Settings
							</a>
						</div></li>
					<li class="nav-item"><a href="/logout" class="nav-link"> <i
							class="fas fa-user-times"></i> Logout
					</a></li>
				</ul>
			</div>
		</div>
	</nav>








</body>
</html>