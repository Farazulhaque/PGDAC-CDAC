<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<%@include file="Header.jsp"%>




	<!-- YOUR SOME ORDER-->



	<section Id="myorderpage" class="container container-fluid py-4"
		data-toggle="collapse" data-target="#order-details">
		<h3>Order List</h3>
		<c:forEach var="orders" items="${orderlist}">
			<div class="row orderrow">
				<div class="col-6">

					<h6>
						Order Id: <span id="orderid">${orders.orderId}</span>
					</h6>

					<c:if test="${orders.status.isCanceled==1}">
						<div id="deliveredCanceledbackground">
							<p id="Canceled-bg-text">Cancelled</p>
						</div>
					</c:if>
					<c:if test="${orders.status.statusType == 3}">
						<div id="deliveredCanceledbackground">
							<p id="delivered-bg-text">Delivered</p>
						</div>
					</c:if>




					<h6 id="customer-name" style="display: inline;">${orders.userAddress.name}</h6>









					<p>
						Delivery Address: <span id="delivery-address">${orders.userAddress.localityAreaStreet},
							${orders.userAddress.landmark}, ${orders.userAddress.city},
							${orders.userAddress.city},<br> ${orders.userAddress.state},
							${orders.userAddress.pincode}, <b>Mobile no
								:${orders.userAddress.mobileNumber} </b>
						</span>
					</p>

				</div>
				<div class="col-6">
					<h6>
						Total Price &emsp;: <span id="grand-total-price">
							&#x20b9;${orders.netAmount}</span>
					</h6>
					<p>
						Order Date &emsp;: <span id="order-date">${orders.orderDate}</span>
					</p>
					<p>
						Delivery Date : <span id="order-date">${orders.shipingDate}</span>
					</p>
					<p>
						Status &nbsp;&emsp;&emsp;&emsp;: <span id="order-status"> <c:if
								test="${orders.status.statusType == 0}">Pending</c:if> <c:if
								test="${orders.status.statusType == 1}">Confirmed</c:if> <c:if
								test="${orders.status.statusType == 2}">Shipped</c:if> <c:if
								test="${orders.status.statusType == 3}">Delivered</c:if>
						</span>
					</p>
					<c:if
						test="${(orders.status.statusType != 2) && (orders.status.statusType !=3) && (orders.status.isCanceled!=1)}">
						<form action="/userorderCancel" method="post" id="cancel-order">
							<input type="hidden" name="orderId"
								value="${orders.orderId}"> <input type="hidden"
								name="statusId" value="${orders.status.statusId}">
							<input type="hidden" name="statusType"
								value="${orders.status.statusType}"> <input
								type="hidden" name="isCanceled" value="1"> <input
								type="submit" class="btn-danger" value="cancel">
						</form>
					</c:if>
				</div>
				<div class="row collapse" id="order-details">

					<c:forEach var="orderMed" items="${orders.orderDetails}">

						<div class="container-fluid row ml-1 order-item">
							<div class="col-6 col-md-6 p-2">
								<h6 id="product-name">${orderMed.medicineMaster.medicineName}</h6>
								<p id="product-description">${orderMed.medicineMaster.salt}
									<br> ${orderMed.medicineMaster.typeOfSell}
								</p>
								<p id="product-description">
									<b>medicine Quantity :</b>${orderMed.medicineQuantity}</p>
							</div>
							<div class="col-4 offset-1 p-2">
								<br>
								<p>
									MRP &emsp;&emsp;&nbsp; : <span class="product-mrp">&#x20b9;
										${orderMed.medicineMaster.mrp}</span>
								</p>
								<p>
									Discount&emsp;: <span class="product-discount">&#x20b9;
										${orderMed.medicineDiscount}</span>
								</p>
								<hr>
								<p>
									Total Price&nbsp; : <span class="product-price">&#x20b9;${orderMed.medicineMaster.mrp  -  orderMed.medicineDiscount}</span>
								</p>
							</div>
						</div>
						<hr>
					</c:forEach>
					<div class="row ml-1">
						<div class="col-12 p-2 seller-details">
							<span id="seller-name">${orders.seller.fullName}</span>
							<p>
								Seller Address: <span id="seller-address: ">${orders.seller.shopName}${orders.seller.shopAddress}</span>
							</p>
						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</section>
</body>


<script>
	if (document.getElementById("order-status").innerHTML == "Delivered") {
		document.getElementById("cancel-order").style.display = "none";
	}
</script>













<!-- footer -->
<%@include file="Footer.jsp"%>

</body>
</html>
>
