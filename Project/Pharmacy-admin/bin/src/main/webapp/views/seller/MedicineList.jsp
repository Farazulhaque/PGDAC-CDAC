<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Seller-medi-list</title>

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



	<div id="medicine-details">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Medicine Name</th>
					<th scope="col">Salt</th>
					<th scope="col">type Of Sell</th>
					<th scope="col">Manufacture</th>
					<th scope="col">MRP</th>
					<th scope="col">MediBox Selling Price</th>
					<th scope="col">Manage Your stock</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listM" items="${listOfMedicine}">
					<tr>
						<th scope="row">${listM.medicineName}</th>
						<td>${listM.salt}</td>
						<td>${listM.typeOfSell}</td>
						<td>${listM.manufacture.manufactureName}</td>
						<td>${listM.mrp}</td>
						<td>${(listM.mrp)-10}</td>
						<td><a class="btn btn-success "
							href="/AddinurStock?mid=${listM.medicineId}"><i
								class="fas fa-plus"></i>Add Your stock</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>







	<%@include file="../templates/sellerFooter.jsp"%>
</body>
</html>