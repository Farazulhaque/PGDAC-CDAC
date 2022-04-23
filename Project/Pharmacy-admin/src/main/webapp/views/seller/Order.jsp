<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>seller-order</title>
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










	<%@include file="../templates/sellerFooter.jsp"%>
</body>
</html>