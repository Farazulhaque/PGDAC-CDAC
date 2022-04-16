<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1" />
	<title>Insert title here</title>
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
									<th>OrderID</th>
									<th>ShopName</th>
									<th>Delivery Address</th>
									<th>Estimated Delivery Date</th>
									<th>Status</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>dwa</td>
									<td>800014</td>
									<td>12-10-24</td>
									<td>pending</td>
									<td><a href="orderpage.html" class="btn btn-secondary">
											<i class="fas fa-angle-double-right"></i> Details
										</a></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card text-center bg-success text-white mb-3">
						<div class="card-body">
							<h3>PendingOrder</h3>
							<h4 class="display-4">
								<i class="fas fa-folder"></i> 4
							</h4>
							<a href="./orderpage.html" class="btn btn-outline-light btn-sm">View</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>







	<%@include file="../templates/sellerFooter.jsp"%>
</body>

</html>