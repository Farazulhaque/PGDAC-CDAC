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
<title>Seller-Login</title>
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
<body>
	<!-- nav section -->
	<!--  <nav class="navbar navbar-expand-sm navbar-dark bg-dark p-0">
    <div class="container">
    	<div class="bg-white my-1"> 
     		<a href="/sellerSignUp" class="navbar-brand"> <img src="/image/logo.png" alt="@logo" height="40px" width="auto"> </a>
    	</div>
    </div>
  </nav> -->

	<!-- HEADER -->
	<header id="main-header" class="py-2 bg-primary text-white">
		<div class="container">
			<div class="row ">
				<div class="col-md-6 ">
					<a href="/sellerSignUp" class="navbar-brand bg-white my-1"> <img
						src="/image/logo.png" alt="@logo" height="40px" width="auto">
					</a>
				</div>
				<div class="col-md-6">
					<h1>
						<i class="fas fa-user"></i> MediBox Seller
					</h1>
				</div>
			</div>
		</div>
	</header>

	<!-- ACTIONS -->
	<section id="actions" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row"></div>
		</div>
	</section>

	<c:if test="${ invalid }">
		<div
			class="w-50  m-auto alert alert-danger text-center alert-dismissible fade show"
			role="alert">
			<strong>Invalid!!!!!!!</strong>Email and Password
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<c:if test="${notactive}">
		<div
			class="w-50  m-auto alert alert-success text-center alert-dismissible fade show"
			role="alert">
			<strong> Please wait for the admin approval .</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>









	<!-- LOGIN -->
	<section id="login">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mx-auto">
					<div class="card">
						<div class="card-header">
							<h4>Account Login</h4>
						</div>
						<div class="card-body">
							<form action="sellerlogin" method="post">
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										name="uemail" class="form-control" />
								</div>
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										name="upass" class="form-control" />
								</div>
								<input type="submit" value="Login"
									class="btn btn-primary btn-block" />
								<p class="signuplink">
									Don't have an account <a href="/sellerSignUp">Sign up</a>
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<!-- FOOTER -->
	<footer id="main-footer" class="bg-dark text-white mt-5 p-5">
		<div class="container">
			<div class="row">
				<div class="col">
					<p class="lead text-center">
						Copyright &copy; <span id="year"></span> MediBox
					</p>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>
