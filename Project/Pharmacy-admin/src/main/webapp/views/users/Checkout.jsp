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
										value="Submit">
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
									id="address-sel"
									onchange="myfunc('${address.userAddressId}' ,'${address.name}', '${address.localityAreaStreet} ${address.landmark}',' ${address.city} ${address.state} - ${address.pincode}')">
							</div>
							<div class="px-4 py-1 addressprint col-8 " id="${address.userAddressId}">
								<span style="font-weight: 500;">${address.name}</span><br>
								<span class="">${address.mobileNumber}</span><br>
								<span class="">${address.localityAreaStreet} </span>
								<span class="">${address.landmark} </span>
								<br> <span class="">${address.city}, </span>
								<span class="">${address.state} - </span>
								<span class="">${address.pincode}</span>
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

					<div class="row orderrow">
						<div class="col-6">

							<h6 id="customer-name">Reciver Name</h6>
							<p>
								<i class="fas fa-shipping-fast"></i>Delivery Address: <span
									id="delivery-address"></span>
							</p>
							<p style="color: rgba(82, 0, 0, 0.8); font-weight: 500;">Payment Mode: Cash On Delivery
							</p>

						</div>
						<div class="col-6">
							<h6>
								Total Price &emsp;: &#x20b9; <span id="grand-total-price">
									0000<span>
							</h6>
							<span>
								Order Date &emsp;: <span id="order-date">DD-MM-YYYY</span>
							</span>
							<br>
							<span>
								Delivery Date : <span id="delivery-date">DD-MM-YYYY</span>
							</span>


						</div>
						<div class="row collapse" id="order-details" style="font-size: 16px;">

							<c:set var="count" value="1" scope="session" />

							<c:forEach var="medicine" items='${sessionScope["medicines"]}'>

								<div class="container-fluid row ml-1 order-item" id="${medicine.medicineId}">
									<div class="col-6 col-md-6 p-2">
										<input type="hidden" class="mid" value="${medicine.medicineId}">
										<h6 id="product-name" style="font-size: 18px;">${count}.
											${medicine.medicineName}</h6>

										<span id="product-description">${medicine.typeOfSell}</span> <br>
										<span id="product-description">Manufaturer:
											${medicine.manufacture.manufactureName}</span> <br>
										Quantity: <span
											id="quantity${medicine.medicineId}">${sessionScope["quantity"][count-1]}
										</span> <br>
										<span id="controller-message${medicine.medicineId}"></span>
										<c:set var="count" value="${count+1}" scope="session" />
									</div>
									<div class="col-4 offset-1 p-2">
										<br>
										<span> MRP &emsp;&emsp;&emsp; : &#x20b9; <span class="product-mrp"
												style="position: absolute; right: 0;"
												id="product-mrp${medicine.medicineId}">
												${medicine.mrp}</span>
										</span>
										<br>
										<span>Seller Offer &nbsp;: &#x20b9; -<span class="product-discount"
												style="position: absolute; right: 0;"
												id="seller-discount${medicine.medicineId}">0.00
											</span>
										</span>
										<br>
										<span>Our Offer &emsp;: &#x20b9; -<span class="our-discount"
												style="position: absolute; right: 0;"
												id="our-discount${medicine.medicineId}">0.00
											</span>
										</span>

										<hr>
										<span> Total Price&nbsp;&nbsp; : &#x20b9; &nbsp;<span class="product-price"
												style="position: absolute; right: 0;"
												id="product-price${medicine.medicineId}">${medicine.mrp}</span>
										</span>
									</div>
								</div>

								<hr>
							</c:forEach>
							<c:set var="count" value="1" scope="session" />
							<div class="row ml-1">
								<div class="col-12 p-2 seller-details">
									<span id="seller-name"></span> <br> <span id="seller-address"></span>
								</div>

							</div>
						</div>
					</div>
				</div>
			</aside>

		</div>


	</section>
	<div class="row mx-0 deliver-btn my-2 " id="order-btn-section">
		<form method="get" action="placeOrder" class="float-right col-2 offset-8 py-2">
			<input type="hidden" name="uAId" id="uAId">
			<input type="hidden" name="sId" value="" id="sId">
			<input type="hidden" name="mId" value="" id="mid">
			<input type="hidden" name="mQty" value="" id="mQty">
			<input type="hidden" name="mDiscount" id="mDiscount">

			<input type="submit" class="btn btn-outline-primary" id="cash_on_delivery_btn" value="Place Order" />

		</form>
	</div>
	<!-- <div class="row mx-0 deliver-btn my-2  ">
		<button class="btn btn-outline-primary float-right col-2 offset-8 py-2 " id="online_payment_btn">Online
			Payment</button>
	</div> -->


	<!-- footer -->
	<%@include file="Footer.jsp"%>
</body>
<script>
	// disable buttons on load
	// window.onload = () => {
	// 	document.getElementById("cash_on_delivery_btn").style.backgroundColor = "#2e9af8";
	// 	document.getElementById("cash_on_delivery_btn").style.color = "white";
	// 	document.getElementById("cash_on_delivery_btn").disabled = true;

	// 	document.getElementById("online_payment_btn").style.backgroundColor = "#2e9af8";
	// 	document.getElementById("online_payment_btn").style.color = "white";
	// 	document.getElementById("online_payment_btn").disabled = true;

	// 	var all_medicines_available = true;
	// }
	var medicineId = "";
	var mQty = "";
	var mDiscount = "";

	function myfunc(uAId, name, address, city_state) {

		document.getElementById("customer-name").innerHTML = name;
		document.getElementById("delivery-address").innerHTML = address + "<br>" + city_state;

		var sellerid;
		var addresses = document.getElementsByClassName("addresses");
		var delivery_pincode;
		for (let i = 0; i < addresses.length; i++) {
			if (addresses[i].checked) {
				delivery_pincode = addresses[i].value;
				// setting value of user address id to send to controller
				document.getElementById("uAId").value = uAId;
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
					sellerid = result["seller"]["sellerId"];

					// setting value of seller id to send to controller
					document.getElementById("sId").value = sellerid;

					document.getElementById("seller-name").innerHTML = "Shop Name: " +
						result["seller"]["shopName"];
					document.getElementById("seller-address").innerHTML = "Shop Address: " +
						result["seller"]["shopAddress"];
					var mids = document.getElementsByClassName("mid");
					document.getElementById("grand-total-price").innerHTML = 0;
					for (let i = 0; i < mids.length; i++) {
						var url2 = "getSellerMedicineData?sid=" + result["seller"]["sellerId"] +
							"&mid=" + mids[i].value;
						checkMedicineDataAtSeller(url2, mids[i].value);

						document.getElementById("grand-total-price").innerHTML =
							(parseFloat(document.getElementById("grand-total-price").innerHTML) +
								parseFloat(document.getElementById("product-price" + mids[i].value).innerHTML)).
						toFixed(0);
					}

				}
			}
		}
		ajax.open("GET", url, true);
		ajax.send(null);
	}

	function checkMedicineDataAtSeller(url2, mid) {

		var ajax2 = new XMLHttpRequest();
		ajax2.onreadystatechange = function () {
			if (ajax2.readyState == 4) {

				let res2 = ajax2.responseText
				let result2 = JSON.parse(res2);
				var qtyy = parseInt(document.getElementById("quantity" + mid).innerHTML);
				// check if product is available or not at seller
				if (result2["smm"] == null) {
					document.getElementById("seller-discount" + mid).innerHTML = "0.00";
					document.getElementById(mid).style.border = "2px solid red";
					document.getElementById("controller-message" + mid).innerHTML =
						"<br>Product Not Available at seller";
					document.getElementById("controller-message" + mid).style.color = "red";
					document.getElementById("controller-message" + mid).style.fontWeight = "500";

				}
				// Check if the sufficient quantity is available or not
				else if (result2["smm"]["qunatity"] < qtyy) {
					document.getElementById(mid).style.border = "2px solid red";
					document.getElementById("controller-message" + mid).innerHTML = "<br>Product Out Of Stock";
					document.getElementById("controller-message" + mid).style.color = "red";
					document.getElementById("controller-message" + mid).style.fontWeight = "500";

				}
				// if product is also available and quantity is also sufficient
				else {

					window.medicineId = window.medicineId + mid + "-";

					mQty = mQty + qtyy + "-";
					document.getElementById("product-mrp" + mid).innerHTML = (parseFloat(document.getElementById(
						"product-mrp" + mid).innerHTML) * qtyy).toFixed(2);

					var product_price = parseFloat(document.getElementById("product-mrp" + mid).innerHTML);

					var discount_percent = parseFloat(result2["smm"]["sellerDiscount"]);
					var discount = (product_price / 100) * discount_percent;
					var our_discount = (product_price / 100) * 5;
					var total_discount = (discount + our_discount).toFixed(2);
					mDiscount = mDiscount + total_discount + "-";

					// setting input field to send data to controller
					document.getElementById("mid").value = window.medicineId;
					document.getElementById("mQty").value = window.mQty;
					document.getElementById("mDiscount").value = window.mDiscount;

					document.getElementById("seller-discount" + mid).innerHTML = discount.toFixed(2);
					document.getElementById("our-discount" + mid).innerHTML = our_discount.toFixed(2);

					var total_price = product_price - discount - our_discount;

					document.getElementById("product-price" + mid).innerHTML = total_price.toFixed(2);

					// document.getElementById("grand-total-price").innerHTML = (parseFloat(document.getElementById(
					// 	"grand-total-price").innerHTML) + total_price).toFixed(0);
				}
			}
		}
		ajax2.open("GET", url2, true);
		ajax2.send(null);

	}
	let currentDate = new Date();
	let cDay = currentDate.getDate();
	let cMonth = currentDate.getMonth() + 1;
	let cYear = currentDate.getFullYear();
	let today = cDay + "-" + cMonth + "-" + cYear;
	document.getElementById("order-date").innerHTML = today;
	currentDate.setDate(new Date().getDate() + 1);
	cDay = currentDate.getDate();
	cMonth = currentDate.getMonth() + 1;
	cYear = currentDate.getFullYear();
	today = cDay + "-" + cMonth + "-" + cYear;
	document.getElementById("delivery-date").innerHTML = today;
</script>

</html>




<!-- 
	userId
sellerId
userAddressId
medicine[medicineId, quantity, discount]
 -->