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
<title>User Sign Up</title>
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
<link rel="stylesheet" href="css/mystyle.css" />
<script src="js/myscript.js"></script>
</head>

<body class="">
	<!-- ================================================================================================================= -->
	<c:if test="${userexist}">
		<div
			class="w-50  m-auto alert alert-danger text-center alert-dismissible fade show"
			role="alert">
			<strong>Invalid!</strong> Email or Mobile Number already exist
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<section id="home-section">
		<div class="dark-overlay">
			<div class="home-inner container">
				<div class="row">
					<div class="col-lg-4 d-none d-lg-block">
						<div class="d-flex">
							<div class="p-4 align-self-start">
								<a href="/"><img src="./image/logo.png" alt="@logo"
									height="auto" width="200px" class="logosignup" /></a>
							</div>
						</div>

						<div class="d-flex">
							<div class="p-4 align-self-start">
								<i class="fas fa-check fa-2x"></i>
							</div>
							<div class="p-4 align-self-end">in 24hr delivery</div>
						</div>

						<div class="d-flex">
							<div class="p-4 align-self-start">
								<i class="fas fa-check fa-2x"></i>
							</div>
							<div class="p-4 align-self-end">From Local Seller</div>
						</div>

						<div class="d-flex">
							<div class="p-4 align-self-start">
								<i class="fas fa-check fa-2x"></i>
							</div>
							<div class="p-4 align-self-end">Trusted Brand</div>
						</div>
					</div>





					<div class="col-lg-8">
						<div class="card text-center card-form formSection">
							<div class="card-body">
								<h3>Sign Up Today</h3>
								<p>Please fill out this form to register</p>
								<form method="post" action="process_userSignup" class="needs-validation">
									<div class="form-group">
										<input type="text" class="form-control form-control-lg"
											id="fullName" name="fullName" placeholder="Full Name"
											onblur="checkFullName()" required="required" /> <span
											id="fullname-error" class="text-danger"></span>
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-lg"
											id="contactNumber" name="contactNumber" placeholder="Mobile"
											onblur="checkContactNo()" required="required" /> <span
											id="contact-error" class="text-danger"></span>
									</div>
									<div class="form-group">
										<input type="email" class="form-control form-control-lg"
											id="emailId" name="emailId" placeholder="Email"
											onblur="checkEmail()" required="required" /> <span
											id="email-error" class="text-danger"></span>
									</div>
									<div class="form-group">
										<input type="password" class="form-control form-control-lg"
											id="password" name="password" placeholder="password"
											onblur="checkPassword()" required="required" /> <span
											id="password-error" class="text-danger"></span>
									</div>
									<div class="form-group">
										<input type="password" class="form-control form-control-lg"
											id="RePassword" name="RePassword"
											placeholder="Confirm password" onblur="checkPasswordMatch()"
											required="required" /> <span id="repassword-error"
											class="text-danger"></span>
									</div>
									<input type="submit" value="Sign Up"
										class="btn btn-outline-light btn-block" />

									<p class="signinlink">
										I already have an account <a href="/userloginpage">Sign In</a>
									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

</html>