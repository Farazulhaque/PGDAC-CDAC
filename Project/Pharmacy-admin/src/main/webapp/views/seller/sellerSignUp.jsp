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
<title>Seller-SignUp</title>
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

	<c:if test="${sellerReg}">
		<div
			class="w-50  m-auto alert alert-success text-center alert-dismissible fade show"
			role="alert">
			<strong>Success!</strong> You have been successfully
			registered.Please wait for the admin approval .
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<c:if test="${sellerexist}">
		<div
			class="w-50  m-auto alert alert-danger text-center alert-dismissible fade show"
			role="alert">
			<strong>Invalid!</strong> email id already exist
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>



	<!-- SignUpSeller -->
	<section id="SignUpSeller">
		<div class="container-fulid">
			<div class="row text-center">
				<div class="col-md-6 mx-auto">
					<div class="card">
						<div class="card-header">
							<h4>Seller Registration</h4>
						</div>
						<div class="card-body">


							<form method="post" action="/addSeller"
								enctype="multipart/form-data">

								<div class="form-group">
									<label for="fullname"><b>Full Name</b></label> <input
										type="text" name="fullName" class="form-control"
										placeholder="Enter Name" name="fullname" id="fullName"
										onblur="checkFullName()" required /> <span
										id="fullname-error" class="text-danger"></span>
								</div>

								<div class="form-group">
									<label for="email"><b>Email</b></label> <input type="text"
										name="emailId" class="form-control" placeholder="Enter Email"
										name="email" id="email" required />
								</div>

								<div class="form-group">
									<label for="psw"><b>Password</b></label> <input type="password"
										name="password" class="form-control"
										placeholder="Enter Password" name="psw" id="password"
										onblur="checkPasswordMatch()" required /> <span
										id="password-error" class="text-danger"></span>
								</div>

								<div class="form-group">
									<label for="psw-reEnter"><b>ReEnter Password</b></label> <input
										type="password" name="repassword" class="form-control"
										placeholder="ReEnter Password" name="psw-reEnter"
										id="RePassword" onblur="checkPasswordMatch()" required /> <span
										id="password-error" class="text-danger"></span>

								</div>

								<div class="form-group">
									<label for="ShopName"><b>ShopName</b></label> <input
										type="text" name="shopName" class="form-control"
										placeholder="Enter ShopName" name="ShopName" id="ShopName"
										required />
								</div>

								<div class="form-group">
									<label for="ShopRegNo"><b>ShopRegNo</b></label> <input
										type="text" name="shopeRegNo" class="form-control"
										placeholder="EnterShopRegNo " name="ShopRegNo" id="ShopRegNo"
										required />
								</div>

								<div class="form-group">
									<label for="ShopContactNo"><b>Shop Contact No</b></label> <input
										type="text" class="form-control" placeholder="ShopContactNo "
										name="ShopContactNo" id="contactNumber"
										onblur="checkContactNo()" required /> <span
										id="contact-error" class="text-danger"></span>

								</div>

								<div class="form-group">
									<label for="ShopAddress"><b>ShopAddress</b></label> <input
										type="text" name="shopAddress" class="form-control"
										placeholder=" ShopAddress" name="ShopAddress" id="ShopAddress"
										required />
								</div>

								<div class="form-group">
									<label for="ShopPincode"><b>Enter a ShopPincode:</b></label> <input
										type="text" name="shopPincode" class="form-control"
										placeholder="Shop Pin code" id="ShopPincode" name="pincode"
										minlength="6" maxlength="6" />

								</div>

								<div class="form-group">
									<label for="myfile"><b>Select a file:</b></label> <input
										type="file" name="myfilesdoc" accept="image/*,.pdf"
										class="form-control" id="myfile" />
								</div>

								<input type="submit" value="Sign Up"
									class="btn btn-primary btn-block" />

								<p class="signinlink">
									I already have an account <a href="/sellerlogin">Sign In</a>
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








</body>
</html>