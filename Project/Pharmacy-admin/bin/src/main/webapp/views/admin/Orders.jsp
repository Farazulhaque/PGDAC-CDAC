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
<title>Admin-orders</title>

</head>

<body>

	<%@include file="../templates/header.jsp"%>


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
					<td><a href="/OrderDetails?orderId=${order.orderId}"
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