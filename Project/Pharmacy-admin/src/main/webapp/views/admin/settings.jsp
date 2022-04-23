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
<title>Admin</title>
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

	<%@include file="../templates/header.jsp"%>




	<section id="settings">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header">
							<h4>Edit Settings</h4>
						</div>
						<div class="card-body">
							<form action="" mathod="">
								<fieldset class="form-group">
									<legend>Allow User Registration</legend>
									<div class="form-check">
										<label class="form-check-label"> <input type="radio"
											class="form-check-input" value="Yes" checked> Yes
										</label>
									</div>
									<div class="form-check">
										<label class="form-check-label"> <input type="radio"
											class="form-check-input" value="No"> No
										</label>
									</div>
								</fieldset>

								<fieldset class="form-group">
									<legend>Allow Seller Registration</legend>
									<div class="form-check">
										<label class="form-check-label"> <input type="radio"
											class="form-check-input" value="posts" checked> Yes
										</label>
									</div>
									<div class="form-check">
										<label class="form-check-label"> <input type="radio"
											class="form-check-input" value="page"> No
										</label>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>





	<%@include file="../templates/footer.jsp"%>
</html>