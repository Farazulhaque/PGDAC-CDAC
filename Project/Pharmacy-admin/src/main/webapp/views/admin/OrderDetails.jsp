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
<title> Admin - order details</title>

</head>

<body>

	<%@include file="../templates/header.jsp"%>






	<!-- YOUR SOME ORDER-->




	<section Id="myorderpage" class="container container-fluid py-4"
		data-toggle="collapse" data-target="#order-details">
		<h3>Order List</h3>
		<div id="orderpagedetails" class="row orderrow">





			<div class="col-6">

				<h6>
					 Order Id: <span id="orderid">${OrdersDetails.orderId}</span> 
				</h6>
				<h6 id="customer-name" style="display: inline;">${OrdersDetails.userAddress.name}</h6>
				<c:if test="${OrdersDetails.status.isCanceled==1}">
					<div id="deliveredCanceledbackground">
						<p id="Canceled-bg-text">Cancelled</p>
					</div>
				</c:if>
				<c:if test="${OrdersDetails.status.statusType == 3}">
					<div id="deliveredCanceledbackground">
						<p id="delivered-bg-text">Delivered</p>
					</div>
				</c:if>
				<p>
					Delivery Address: <span id="delivery-address">
						${OrdersDetails.userAddress.localityAreaStreet},
						${OrdersDetails.userAddress.landmark},
						${OrdersDetails.userAddress.city},
						${OrdersDetails.userAddress.city},<br>
						${OrdersDetails.userAddress.state},
						${OrdersDetails.userAddress.pincode}, <b>Mobile no
							:${OrdersDetails.userAddress.mobileNumber} </b>
					</span>
				</p>

			</div>
			<div class="col-6">

				<h6>
					Total Price &emsp;: <span id="grand-total-price"> &#x20b9;
						${OrdersDetails.netAmount}</span>
				</h6>
				<p>
					Order Date &emsp;: <span id="order-date">${OrdersDetails.orderDate}</span>
				</p>
				<p>
					Delivery Date : <span id="order-date">${OrdersDetails.shipingDate}</span>
				</p>
				<p>
					Status &nbsp;&emsp;&emsp;&emsp;: <span id="order-status"> 
						<c:if test="${OrdersDetails.status.isCanceled==1}">${OrdersDetails.status.statusDescription}</c:if>
						
						<c:if test="${OrdersDetails.status.isCanceled!=1}">
						<form action="/updateStatus" method="post">

							<input type="text" name="orderId"
								value="${OrdersDetails.orderId}" hidden> <input
								type="text" name="statusId"
								value="${OrdersDetails.status.statusId}" hidden> <select
								id="delivStatus" name="statusType">
								<option value="${OrdersDetails.status.statusType}">
									<c:if test="${OrdersDetails.status.statusType == 0}">Pending</c:if>
									<c:if test="${OrdersDetails.status.statusType == 1}">Confirmed</c:if>
									<c:if test="${OrdersDetails.status.statusType == 2}">Shipped</c:if>
									<c:if test="${OrdersDetails.status.statusType == 3}">Delivered</c:if>
								</option>
								<c:if test="${OrdersDetails.status.statusType !=3}">
									<option value="0">Pending</option>
									<option value="1">Confirmed</option>
									<option value="2">Shipped</option>
									<option value="3">Delivered</option>
								</c:if>
							</select> <input type="submit" class="btn-success" value="Update">
						</form>
						

					</span>
				</p>
				<!-- cancel form -->
				<c:if test="${OrdersDetails.status.statusType !=3}">
					<form action="/orderCancel" method="post">
						<input type="text" name="orderId" value="${OrdersDetails.orderId}"
							hidden> <input type="text" name="statusId"
							value="${OrdersDetails.status.statusId}" hidden> <input
							type="text" name="statusType"
							value="${OrdersDetails.status.statusType}" hidden> <input
							type="text" name="isCanceled" value="1" hidden> <input
							type="submit" class="btn-danger" value="cancel">
					</form>
				</c:if>
				</c:if>
			</div>
			<div class="row collapse" id="order-details">
				<div class="container-fluid row ml-1 order-item">

					<c:forEach var="orderMed" items="${OrdersDetails.orderDetails}">

						<div class="col-6 col-md-6 p-2">
							<h6 id="product-name">${orderMed.medicineMaster.medicineName}</h6>
							<p id="product-description">${orderMed.medicineMaster.salt}</p>
							<p id="product-description">${orderMed.medicineMaster.typeOfSell}</p>
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
								Total Price&nbsp; : <span class="product-price">&#x20b9;
									${orderMed.medicineMaster.mrp  -  orderMed.medicineDiscount}</span>
							</p>
						</div>
				</div>
				<hr>
				</c:forEach>
				<div class="row ml-1">
					<div class="col-12 p-2 seller-details">
						<span id="seller-name">${OrdersDetails.seller.fullName}</span>
						<p>
							Seller Address: <span id="seller-address: ">Lorem ipsum
								${OrdersDetails.seller.shopName},${OrdersDetails.seller.shopAddress}</span>
						</p>
					</div>

				</div>
			</div>
		</div>

	</section>















	<%@include file="../templates/footer.jsp"%>




</body>
</html>