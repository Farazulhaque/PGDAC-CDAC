<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Seller-Dashboard</title>

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
	<%@include file="../templates/sellerHeader.jsp"%>




	<!-- HEADER -->
	<header id="main-header" class="py-2 bg-primary text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-cog"></i> Dashboard
					</h1>
				</div>
			</div>
		</div>
	</header>

	<!-- ACTIONS -->
	<section id="actions" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3 my-1">
					<a href="/medicineRegsReq" class="btn btn-primary btn-block">
						<i class="fas fa-plus"></i> ADD Medicine Data Request to admin
					</a>
				</div>
				<div class="col-md-3 my-1">
					<a href="/medicineInventory" class="btn btn-success btn-block">
						Medicine list available Medi Box </a>
				</div>
				<div class="col-md-3 my-1">
					<a href="/sellerMedicineManager" class="btn btn-warning btn-block">
						<i class="fas fa-plus"></i> Manage medicine Quantity available
					</a>
				</div>
			</div>
		</div>
	</section>

	<!-- LATEST ORDER -->
	<section id="LatestOrder ">
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<div class="card overflow-auto">
						<div class="card-header">
							<h4>latest Order</h4>
						</div>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>Order ID</th>
									<th>Order Date</th>
									<th>Delivery Address</th>
									<th>Estimated Delivery Date</th>
									<th>Status</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${pendingOrderList}">
								<tr>
									<td>${list.orderId}</td>
									<td>${list.orderDate}</td>
									<td><b>${list.userAddress.name}</b>,
										${list.userAddress.localityAreaStreet},
										${list.userAddress.landmark},
										${list.userAddress.city},
										${list.userAddress.city},
										${list.userAddress.state},
										${list.userAddress.pincode}, 
										<b>Mobile no:${list.userAddress.mobileNumber} </b>	
									</td>
									<td>${list.shipingDate}</td>
									<td>pending</td>
									<td><a href="/sellerpendingOrderDetails" class="btn btn-secondary">
											<i class="fas fa-angle-double-right"></i> Details
									</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card text-center bg-success text-white mb-3">
						<div class="card-body">
							<h3>PendingOrder</h3>
							<h4 class="display-4">
								<i class="fas fa-folder"></i>${pendingOrdercount}
							</h4>
							<a href="/sellerpendingOrderDetails" class="btn btn-outline-light btn-sm">View</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>







	<%@include file="../templates/sellerFooter.jsp"%>
</body>
</html>