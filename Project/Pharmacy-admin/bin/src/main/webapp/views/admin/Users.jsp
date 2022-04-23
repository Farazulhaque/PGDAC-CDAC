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
<title>Admin - user list</title>
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
<link rel="stylesheet" href="css/mystyleadmin.css" />
<script src="js/myjScriptadmin.js"></script>
</head>

<body>

	<%@include file="../templates/header.jsp"%>





	<!-- HEADER -->
	<header id="main-header" class="py-2 bg-warning text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-users"></i> Users
					</h1>
				</div>
			</div>
		</div>
	</header>

	<!-- SEARCH -->
	<section id="search" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-6 ml-auto">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search Users...">
						<div class="input-group-append">
							<button class="btn btn-warning">Search</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- USERS -->
	<c:if test="${Userlist != null}">

		<section id="users">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Latest Users</h4>
							</div>
							<table class="table table-striped">
								<thead class="thead-dark">
									<tr>
										<th>UserID</th>
										<th>Name</th>
										<th>Email</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${Userlist}">
										<tr>
											<td>${user.getUserId()}</td>
											<td>${user.getFullName()}</td>
											<td>${user.getEmailId()}</td>
											<td>
												<%-- <form action="UserDetails/${user.getUserId()}" method="post">
		                    <button type="submit" class="btn btn-secondary">
		                      <i class="fas fa-angle-double-right"></i> Details
		                    </button>
	                     </form>    --%> <a class="btn btn-secondary "
												href="/UserDetailsFind?uid=${user.getUserId()}"><i
													class="fas fa-angle-double-right"></i> Details</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:if>



	${userfind.getUserId()}
















	<%@include file="../templates/footer.jsp"%>




</body>
</html>