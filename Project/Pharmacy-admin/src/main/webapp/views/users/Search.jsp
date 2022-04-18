<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>HOME</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
		integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
	<link rel="stylesheet" href="css/mystyle.css" />
	<script src="js/myscript.js"></script>
</head>

<body class="">

	<!-- Header -->
	<%@include file="Header.jsp"%>

	<!--Search listing page-->
	<section Id="SearchListPage" class="container container-fluid">
		<div class="text-center">
			<h2>
				Showing all results for <em style="color: blue; text-decoration: underline;">
					<c:out value="${query}"></c:out>
				</em>
			</h2>
		</div>
		<c:if test="${isEmpty}">
			<div style="color: red; text-align: center; margin-top: 20px;">
				<h2>No Results Found</h2>
			</div>
		</c:if>
		<c:forEach var="item" items="${medicinesQueryList}">
			<div class=" row searchDetails">
				<div class="productNameandbarnd text-center">
					<a href="/product?mid=${item.medicineId}">
						${item.medicineName}&nbsp;${item.typeOfSell} </a>
					<p>${item.manufacture.manufactureName }</p>
				</div>

				<div class="MrpOPriceDiscount text-center">
					<strong class="ourPrice" style="font-size: 20px;">&#x20b9;<span>
							<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
								value="${ item.mrp - (item.mrp/100)*5 } " />
						</span></strong>
					<strike>&#x20b9;${item.mrp}</strike>
					<strong class=" Discount"><span>5% off</span></strong>
				</div>

				<div class="cartbtn text-center">
					<a href="#" class="btn" id="addToCartbtn"
						onclick="add_to_cart('${item.medicineId }','${item.medicineName}','${item.typeOfSell}' , '${item.manufacture.manufactureName}', '${item.mrp }')">
						<i class="fa fa-cart-plus"></i>Add to Cart
					</a>
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