<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Seller-Medi-mgr</title>

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

	

	<!-- Form -->
	<section class="container-fluid" id="UpdateSection">
		<div class="form-group container-fluid">
			<label for="MName">Medicine Name</label>

		</div>

		<!-- form for add quantity of medicine -->

		<form action="addQuant" method="post">
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th scope="col">
							<div class="form-group">
								<label for="Name">Medicine Name</label> <select
									class="form-control" name="medicineMaster" id="MName"
									onchange="MedecineData()">
									<c:if test="${singleMedicine!=null }">
										<option value="${singleMedicine.medicineId}">${singleMedicine.medicineName}</option>
									</c:if>
									<c:if test="${updateMedicine!=null }">
										<option value="${updateMedicine.medicineMaster.medicineId}">${updateMedicine.medicineMaster.medicineName}</option>
									</c:if>


									<c:if test="${singleMedicine==null }">
										<option value="-1">---Select Medicine--</option>
										<c:forEach var="item" items="${listOfMedicine}">
											<option value="${item.medicineId}">${item.medicineName}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</th>
						<th scope="col">
							<div class="form-group">
								<label for="Quantity">Quantity</label> <input type="number"
									class="form-control" name="qunatity"
									value="${updateMedicine.qunatity }" id="Quantity"
									placeholder="10" />
							</div>
						</th>
						<th scope="col">
							<div class="form-group">
								<label for="Discount">Your Extra Discount</label> <input
									type="number" class="form-control" name="sellerDiscount"
									value="${updateMedicine.sellerDiscount}" id="Quantity"
									placeholder="5%" />
							</div>
						</th>
						<th scope="col">
							<div class="form-group">
								<input type="submit" class="btn btn-success" value="Submit" />
							</div>
						</th>
					</tr>
				</thead>
			</table>
		</form>

	</section>

	<!-- list of medicine  -->

	<button class="btn btn-success btn-block my-5" data-toggle="collapse"
		data-target="#medicine-details">Show Medicine List</button>

	<div class="collapse" id="medicine-details">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Medicine Name</th>
					<th scope="col">Salt</th>
					<th scope="col">type Of Sell</th>
					<th scope="col">MRP</th>
					<th scope="col">MediBox Selling Price</th>
					<th scope="col">Seller Shop Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">your extra Discount</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listM" items="${listOfSellerMedicine}">
					<tr>
						<th scope="row">${listM.medicineMaster.medicineName}</th>
						<td>${listM.medicineMaster.salt}</td>
						<td>${listM.medicineMaster.typeOfSell}</td>

						<td>${listM.medicineMaster.mrp}</td>
						<td>${(listM.medicineMaster.mrp)-5-(listM.sellerDiscount)}</td>
						<th>${listM.seller.shopName}</th>
						<td>${listM.qunatity}</td>
						<td>${listM.sellerDiscount}</td>
						<td><a class="btn btn-success float-left"
							href="/updateMfrmLst?medId=${listM.sellerMediManagerId}">Update</a>
							<a class="btn btn-danger float-left"
							href="/deleteMfrmLst?medId=${listM.sellerMediManagerId}">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<%@include file="../templates/sellerFooter.jsp"%>
</body>
</html>
