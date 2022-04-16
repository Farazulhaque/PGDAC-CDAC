<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Checkout</title>
</head>

<body>
	<%@include file="Header.jsp"%>

	<section class="container  mt-3" id="checkout-page">

		<div class="row  ">

			<action class="col-md-5  col-lg-5   col-12   address-div   mt-3 ">
				<div></div>
				<br>

				<div class="card h-80  " id="">
					<div class=" ml-3 mr-3 mb-3 mt-3">
						<button class="btn btn-outline-info" data-toggle="collapse"
							data-target="#input-address-section">
							<i class="fas fa-shipping-fast"> Add new Address</i>
						</button>
					</div>
					<div class="<c:if test=" ${!editAddForm}">collapse</c:if> mx-5 "
						id="input-address-section">

						<form action="saveUserAddressCheckout" method="post">
							<div class="col-10">

								<!-- geting currntuserid for insrting -->
								<input type="text" name="user" value="${userdetails.userId}" class="form-control"
									hidden>

								<!-- geting currntuseraddressid for insrting -->
								<c:if test="${editAddForm}">
									<input type="text" name="userAddressId" value="${editAddFormDetails.userAddressId}"
										class="form-control" hidden>
								</c:if>
								<div class="form-group">
									<label for="fullName">Full Name</label> <input type="text" name="name"
										value="${editAddFormDetails.name}" class="form-control" id="fullName">
								</div>
							</div>
							<div class="col-10">
								<div class="form-group">
									<label for="contactno">Contact Number</label> <input type="text" name="mobileNumber"
										value="${editAddFormDetails.mobileNumber}" class="form-control" id="contactno"
										placeholder="Contact Number">
								</div>
							</div>
							<div class="col-10">
								<div class="form-group">
									<label for="address">Address(Area/Street/Locality)</label>
									<textarea class="form-control" name="localityAreaStreet" id="address" rows="5"
										cols="10">${editAddFormDetails.localityAreaStreet}
                                       </textarea>
								</div>
							</div>

							<div class="col-10">
								<div class="form-group">
									<label for="landmark">Landmark</label> <input type="text"
										value="${editAddFormDetails.landmark}" class="form-control" name="landmark"
										id="landmark">
								</div>
							</div>
							<div class="col-10">
								<div class="form-group">
									<label for="city">City</label> <input type="text" value="${editAddFormDetails.city}"
										class="form-control" name="city" id="city">
								</div>
							</div>
							<div class=" col-10">
								<div class="form-group">
									<label for="state">State</label> <input type="text"
										value="${editAddFormDetails.state}" class="form-control" name="state"
										id="state">
								</div>
							</div>
							<div class="col-10">
								<div class="form-group">
									<label for="pincode">Pincode</label> <input type="text" class="form-control"
										name="pincode" value="${editAddFormDetails.pincode}" id="pincode">
								</div>
							</div>

							<div class="  col-9">
								<c:if test="${!editAddForm}">
									<input type="submit" class="save-address-btn btn btn-primary float-right"
										value="submit">
								</c:if>
								<c:if test="${editAddForm}">
									<button type="submit" formaction="/updateUserAddressCheckout"
										class="save-address-btn btn btn-primary float-right">Update</button>
								</c:if>
							</div>
						</form>
					</div>
					<c:forEach var="address" items="${userdetails.userAddresses }">
						<div class="user-address-section row justify-content-center   mt-3 ml-3 mb-2 mr-3 ">
							<div id=" radio address-radio col-2 ">
								<input type="radio" class="m-1 addresses" value="${address.pincode}" name="address-sel"
									id="address-sel" onchange="myfunc()">
							</div>
							<div class="px-4 py-1 addressprint col-8 ">
								<span class="">${address.name}</span> &nbsp;<br> <span
									class="">${address.mobileNumber}</span> <br> <span
									class="">${address.localityAreaStreet}</span>
								<br> <span class="">${address.landmark}</span> <br> <span
									class="">${address.city}</span>, <span class="">${address.state}</span>
								-<span class="">${address.pincode}</span> &nbsp;

							</div>
							<div class="edit-btn col-3">
								<a class="float-right" href="/editUserAddressCheckout?userAId=${address.userAddressId}">
									<i class='fas fa-pencil-alt'></i>&nbsp;
								</a>
							</div>

							<div class="text-danger font-weight-bold availability_message " id="${address.pincode}">
								<hr>
							</div>
						</div>
					</c:forEach>
				</div>


			</action>






			<aside Id="myorderCheckoutpage-orderlist" class=" col-md-7  col-lg-7  col-12">
				<div class="bg-white p-5 mt-5  orderlist-details" data-toggle="collapse" data-target="#order-details">
					<h3>Order List</h3>
					<div class="row orderrow">
						<div class="col-6">
							<h6>
								Order Id: <span id="orderid">ABC123456</span>
							</h6>
							<h6 id="customer-name" style="display: inline;">Reciver Name</h6>
							<p>
								<i class="fas fa-shipping-fast"></i>Delivery Address: <span id="delivery-address">Lorem
									ipsum dolor sit amet
									consectetur adipisicing elit. Aliquid ea harum debitis,
									pariatur voluptatem illum!</span>
							</p>

						</div>
						<div class="col-6">
							<h6>
								Total Price &emsp;: <span id="grand-total-price">
									&#x20b9;5999</span>
							</h6>
							<p>
								Order Date &emsp;: <span id="order-date">29-03-2022</span>
							</p>
							<p>
								Delivery Date : <span id="order-date">30-03-2022</span>
							</p>


						</div>
						<div class="row collapse" id="order-details" style="font-size: 16px;">

							<c:set var="count" value="1" scope="session" />

							<c:forEach var="medicine" items='${sessionScope["medicines"]}'>

								<div class="container-fluid row ml-1 order-item">
									<div class="col-6 col-md-6 p-2">
										<input type="hidden" class="mid" value="${medicine.medicineId}">
										<h6 id="product-name" style="font-size: 18px;">${count}.
											${medicine.medicineName}</h6>

										<span id="product-description">${medicine.typeOfSell}</span> <br>
										<span id="product-description">Manufaturer:
											${medicine.manufacture.manufactureName}</span> <br> <span>Quantity:
											${sessionScope["quantity"][count-1]} </span> <br>
										<c:set var="count" value="${count+1}" scope="session" />
									</div>
									<div class="col-4 offset-1 p-2">
										<br> <span> MRP &emsp;&emsp;&nbsp; : <span class="product-mrp">&#x20b9;
												${medicine.mrp}</span>
										</span> <br> <span> Discount&emsp;: <span class="product-discount">&#x20b9;
												100</span>
										</span>
										<hr>
										<span> Total Price&nbsp; : <span class="product-price">&#x20b9;
												999</span>
										</span>
									</div>
								</div>

								<hr>
							</c:forEach>
							<c:set var="count" value="1" scope="session" />
							<div class="row ml-1">
								<div class="col-12 p-2 seller-details">
									<span id="seller-name"></span>
									<br>
									<span id="seller-address"></span>
								</div>

							</div>
						</div>
					</div>
				</div>
			</aside>

		</div>


	</section>
	<div class="row mx-0 deliver-btn my-2  ">
		<button class="btn btn-outline-primary float-right col-2 offset-8 py-2 ">Cash
			on delivery</button>

	</div>
	<div class="row mx-0 deliver-btn my-2  ">

		<button class="btn btn-outline-primary float-right col-2 offset-8 py-2 ">Online
			Payment</button>
	</div>




	<!-- footer -->
	<%@include file="Footer.jsp"%>
</body>
<script>
	function myfunc() {
		var addresses = document.getElementsByClassName("addresses");
		var delivery_pincode;
		for (let i = 0; i < addresses.length; i++) {
			if (addresses[i].checked) {
				delivery_pincode = addresses[i].value;
			}
		}

		// removing message
		var availability_message = document
			.getElementsByClassName("availability_message");
		for (let i = 0; i < availability_message.length; i++) {
			availability_message[i].innerHTML = "";
		}

		var ajax = new XMLHttpRequest();
		var url = "findSeller?pincode=" + delivery_pincode;
		ajax.onreadystatechange = function () {
			if (ajax.readyState == 4) {
				let res = ajax.responseText
				let result = JSON.parse(res);
				if (result["seller"] == null) {
					document.getElementById(delivery_pincode).innerHTML = "Seller not available at this location";
				} else {
					document.getElementById("seller-name").innerHTML = "Shop Name: " +
						result["seller"]["shopName"];
					document.getElementById("seller-address").innerHTML = "Shop Address: " +
						result["seller"]["shopAddress"];
					// for (let i = 0; i < mids.length; i++) {
					// 	var ajax = new XMLHttpRequest();
					// 	var mids = document.getElementByClassName("mid");

					// 	var url = "findDiscount?sid=" + result["seller"]["sellerId"] + "&mid=" + mids[i];
					// 	ajax.open("GET", url, true);
					// 	ajax.send(null);
					// }
				}
			}
		}
		ajax.open("GET", url, true);
		ajax.send(null);

		console.log(delivery_pincode);
	}
</script>

</html>