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
<title>Seller-details</title>
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

	<div class="container mt-3">
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="row card h-80">
					<div class="" style="">
						<img alt="document" src="${currentuser.documentUrl}"
							class="rounded mx-auto d-block" height="200px" width="auto" />
					</div>

					<form method="post" action="/sellerStatusupdate"
						enctype="multipart/form-data">
						<div class="card-body" id="add">
							<div class="row gutters">
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
									<h6 class="mb-2 text-primary">Seller Details</h6>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="sellerId">sellerId</label> <input type="text"
											name="sellerId" class="form-control" id="sellerId"
											value="${currentuser.sellerId}" placeholder="Email-Id"
											readonly />
									</div>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="fullName">Full Name</label> <input type="text"
											name="fullName" class="form-control" id="fullName"
											value="${currentuser.fullName}" placeholder="Email-Id"
											readonly />
									</div>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="shopeName">Shop Name</label> <input type="text"
											name="shopName" class="form-control" id="shopName"
											value="${currentuser.shopName}" placeholder="Shop Name"
											readonly />
									</div>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="shopRegNo">Shop Registration Number</label> <input
											type="text" name="shopeRegNo" class="form-control"
											id="shopRegNo" value="${currentuser.shopeRegNo}"
											placeholder="Shop Registration Number" readonly />
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="shopContact">Contact Number</label> <input
											type="text" name="shopContactNo" class="form-control"
											id="phone" value="${currentuser.shopContactNo}"
											placeholder="Contact Number" readonly />
									</div>
								</div>
								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="Email">Email</label> <input type="text"
											name="emailId" class="form-control" id="Email"
											value="${currentuser.emailId}" readonly />
									</div>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="shopeDocumentUrl">Document Url</label> <input
											type="text" name="documentUrl"
											value="${currentuser.documentUrl}" class="form-control"
											id="shopeDocumentUrl" placeholder="Document Url" readonly />
									</div>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="ShopAddress">Shop Address</label>
										<textarea class="form-control" name="shopAddress"
											 id="ShopAddress" rows="3"
											cols="10" readonly>${currentuser.shopAddress}
                      			</textarea>
									</div>
								</div>

								<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="ShopPincode">Shop Pincode</label> <input
											type="number" name="shopPincode"
											value="${currentuser.shopPincode}" class="form-control"
											id="ShopAddress" placeholder="Pincode" readonly />
									</div>
								</div>

								<div class="form-group">
									<label for="status">status</label> <select class="form-control"
										name="status" id="status">
										<option value="${currentuser.status}">
											<c:if test="${currentuser.status == 0}">On Hold</c:if>
											<c:if test="${currentuser.status == 1}"> Active</c:if>
										</option>
										<option value="1">Active</option>
										<option value="0">On Hold</option>
									</select>
								</div>

								<div class="col-2 offset-8">
									<div class="form-group">
										<input type="submit" class="btn btn-success"
											value="Update Status" />
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<br />

	<!-- list of medicine available at that Seller -->

	<button class="btn btn-success btn-block" data-toggle="collapse"
		data-target="#medicine-details">Show Medicine List</button>

	<div class="collapse" id="medicine-details">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Medicine Name</th>
					<th scope="col">Salt</th>
					<th scope="col">type Of Sell</th>
					<th scope="col">Ur extra Discount</th>
					<th scope="col">MRP</th>
					<th scope="col">Quantity</th>
					<th scope="col">MediBox Selling Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listM" items="${currentuser.sellerMedicneManager}">
					<tr>
						<th scope="row">${listM.medicineMaster.medicineName}</th>
						<td>${listM.medicineMaster.salt}</td>
						<td>${listM.medicineMaster.typeOfSell}</td>
						<td>${listM.sellerDiscount}</td>
						<td>${listM.medicineMaster.mrp}</td>
						<td>${listM.qunatity}</td>
						<td>${(listM.medicineMaster.mrp) - 10 - (listM.sellerDiscount) }
						</td>

						<td><a href="#">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<%@include file="../templates/footer.jsp"%>
</body>
</html>
