<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<link href="<c:url value="/resources//bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
</head>
<body class="login-bg">
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-12"></div>
			</div>
		</div>
	</div>

	<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
					<div class="box">
						<div class="content-wrap">
							<h6>
								Sign in
							</h6>
							<form action="/login" method="POST">
							<label><c:if test="${loginError}">Entered login or password not found</c:if></label>
								 <input
									class="form-control" name="login" type="email"
									placeholder="Email" value="${loginValue}"> 
									<input class="form-control"
									name="password" type="password" placeholder="Password">
								<div class="action">
									<input class="btn btn-primary signup" type="submit"
										value="Submit">
								</div>
							</form>
						</div>
					</div>
					 <div class="already">
			            <p>Haven't account already?</p>
			            <a href="/registration">Registration</a>
			        </div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
</body>
</html>