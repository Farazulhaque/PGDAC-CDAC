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
<title>Admin-Userdetails</title>
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


	
	<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


	<!-- Profile Page -->
	<div class="container mt-3">
		<div class="row gutters">
			<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
				<div class="card h-100">
					<div class="card-body">
						<div class="account-settings">
							<div class="user-profile">
								<div class="user-avatar">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="@profiepic">
								</div>
								<h5 class="user-name">${currentuser.fullName}</h5>
								<h6 class="user-email">${currentuser.emailId}</h6>
								<h6 class="user-contactno">${currentuser.contactNumber}</h6>
							</div>
							<hr>
							<%-- <div class="manage-address">
								<button type="button" data-toggle="collapse"
									data-target="#address-section">Address</button>
							</div>
							<br>
							<div class="oderdetails">
								<a class="btn btn-secondary" href="/adminUserOdderDetails?uid=${currentuser.userId}"><i class="fas fa-angle-double-right"></i>Order Details</a>					
							</div> --%>
						</div>
					</div>
				</div>
			</div>


			<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
				<div class=" row card h-80">

					<br>

					<c:forEach var="address" items="${currentuser.userAddresses }">
						<div class="user-address-section mt-3 ml-3 mb-3 mr-3 p-3">

							<div class="left">
								<span class="username">${address.name}</span> &nbsp; <span
									class="usercontactno">${address.mobileNumber}</span> <br>
								<span class="useraddress">${address.localityAreaStreet}</span> <br>
								<br> <span class="userlandmark">${address.landmark}</span>
								<br> <span class="usercity">${address.city}</span>, <span
									class="userstate">${address.state}</span> - <span
									class="userpincode">${address.pincode}</span> &nbsp;
							</div>


						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	

		<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">OrderId</th>
				<th scope="col">User Name</th>
				<th scope="col">Order Date</th>
				<th scope="col">order Amount</th>
				<th scope="col">Discount</th>
				<th scope="col">NetAmmount</th>
				<th scope="col">Shiping Date</th>
				<th scope="col">Status</th>
				<th scope="col">Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${totalOrders}">
				<tr>
					<th scope="row">${order.orderId}</th>
					<td>${order.user.fullName}</td>
					<td>${order.orderDate}</td>
					<td>${order.orderAmount}</td>
					<td>${order.discount}</td>
					<td>${order.netAmount}</td>
					<td>${order.shipingDate }</td>
					<td>
						<c:if test="${order.status.isCanceled!=1}">
							<c:if test="${order.status.statusType==0}">Pending</c:if>
							<c:if test="${order.status.statusType==1}">Confirmed</c:if>
							<c:if test="${order.status.statusType==2}">Shipped</c:if>
							<c:if test="${order.status.statusType==3}"><p class="text-success">Delivered<p></c:if>
						</c:if>
						
						<c:if test="${order.status.isCanceled==1}"><p class="text-danger">Cancelled<p></c:if>
					</td>
					<td><a href="/sellerOrderDetails?orderId=${order.orderId}"
						class="btn btn-secondary"> <i
							class="fas fa-angle-double-right"></i> Details
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%@include file="../templates/footer.jsp"%>




</body>
</html>