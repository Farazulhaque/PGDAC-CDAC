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
<title>HOME</title>
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
<link rel="stylesheet" href="css/mystyle.css" />
<script src="js/myscript.js"></script>
</head>

<body class="">

	<!-- Header -->
	<%@include file="Header.jsp"%>

	<!--Search listing page-->
	<section Id="SearchListPage" class="container container-fluid">
		<div class="text-center">Showing all results for..............</div>
		<c:forEach var="item" items="${medicinesQueryList}">
			<div class=" row searchDetails">

				<div class="productNameandbarnd text-center">
					<a href="./Adeel/Product.html">
					${item.medicineName}&nbsp;${item.typeOfSell}
					</a>
					<p>BY SUN PHARMA</p>
				</div>

				<div class="MrpOPriceDiscount text-center">
					<b class="ourPrice"><strong>&#x20b9;99</strong></b> <strike>&#x20b9;${item.mrp}</strike> <b
						class=" Discount"><strong>14% off</strong></b>
				</div>

				<div class="cartbtn text-center">
					<a href="cart.html" class="btn" role="button"><i
						class="fas fa-cart-plus"> Add to Cart</i> </a>
				</div>

			</div>
		</c:forEach>


		<div id="pagingnationbar">
			<ul class="pagination ">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>

	</section>

	<!-- footer -->
	<%@include file="Footer.jsp"%>

</body>

</html>