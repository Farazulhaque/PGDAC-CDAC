<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Seller- profile</title>
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



	<div class="container mt-3">
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="row card h-80">
					<div class="" style="">
						<img alt="document" src="${currentuser.documentUrl}"
							class="rounded mx-auto d-block" height="200px" width="auto" />
					</div>

					<form >
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
	
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	







	<%@include file="../templates/sellerFooter.jsp"%>
</body>
</html>