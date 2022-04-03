<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link href="<c:url value="/resources//bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
</head>
<body class="login-bg">
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Logo -->
					<div class="logo">
						<h1></h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
					<div class="box">
						<div class="content-wrap">
						<label><c:if test="${loginError }">Login is already in use. Try another</c:if></label>
							<form:form modelAttribute="newUser">
							<label>Email*</label>
							<form:input class="form-control" path="email"/>
							<form:errors path="email"></form:errors>
							<label>Password*</label>
							<form:input class="form-control" path="password"/>
							<form:errors path="password"></form:errors>
							<label>Name*</label>
							<form:input class="form-control" path="name"/>
							<form:errors path="name"></form:errors>
							<label>Surname*</label>
							<form:input class="form-control" path="surname"/>
							<form:errors path="surname"></form:errors>
							<label>Middle name</label>
							<form:input class="form-control" path="middlename"/>
							
								
								<div class="action">
									<button type="submit" class="btn btn-primary signup">
										Registration
									</button>
								</div>
							</form:form>
						</div>
					</div>
					<div class="already">
						<p>
							Have account already?
						</p>
						<a href="/">Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/custom.js"></script>
</body>
</html>