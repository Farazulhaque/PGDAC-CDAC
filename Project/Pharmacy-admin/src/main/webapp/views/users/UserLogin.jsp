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
<link rel="stylesheet" href="css/mystyle.css" />
<script src="js/myscript.js"></script>
</head>

<body class="">
	<!-- ================================================================================================================= -->



	<%
			String username="",password="";
			Cookie[] cookies = request.getCookies(); 
	
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals("username")) {
					username = c.getValue();
				}
				if (c.getName().equals("password")) {
					password = c.getValue();
				}
			}
	%>







	<c:if test="${invaliduser}">
		<div
			class="w-50  m-auto alert alert-danger text-center alert-dismissible fade show"
			role="alert">
			<strong>Invalid!!!!!!!</strong> Username and Password
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
								<a href="/"> <img src="./image/logo.png" alt="@logo"
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
								<h3>Sign IN</h3>
								<p>Please fill out this form to Sign IN</p>
								<form method="post" action="/userlogin-process">

									<div class="form-group">
										<input type="text" class="form-control form-control-lg"
											name="uname" placeholder="Mobile/Email" value="<%=username %>" />
									</div>


									<div class="form-group">
										<input type="password" class="form-control form-control-lg"
											name="upass" placeholder="password" value="<%=password%>"  />
									</div>
									
									<div >
										<input type="checkbox"   name="remember"> Remember me<br>
									</div>
	
									<input type="submit" value="Sign IN "
										class="btn btn-outline-light btn-block" />

									<p class="signuplink">
										Don't have an account <a href="/UserSignup">Sign Up</a>
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