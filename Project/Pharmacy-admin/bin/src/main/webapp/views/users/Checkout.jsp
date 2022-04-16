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
								<input type="radio" class="m-1" value="current" name="address-sel" id="address-sel"
									checked>
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

								<a class="float-right "
									href="/editUserAddressCheckout?userAId=${address.userAddressId}	"><i
										class='fas fa-pencil-alt'></i>&nbsp;</a>

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
						<div class="row collapse" id="order-details">

							<c:set var="count" value="1" scope="session" />

							<c:forEach var="medicine" items='${sessionScope["arr"]}'>


								<div class="container-fluid row ml-1 order-item">
									<div class="col-6 col-md-6 p-2">
										<h6 id="product-name">${count}.${medicine.medicineName}</h6>

										<c:set var="count" value="${count+1}" scope="session" />

										<p id="product-description">${medicine.typeOfSell}</p>
										<p id="product-description">Salt&emsp;:${medicine.salt}</p>
										<p id="product-description">${medicine.manufacture.manufactureName}</p>
										<br>

									</div>
									<div class="col-4 offset-1 p-2">
										<br>
										<p>
											MRP &emsp;&emsp;&nbsp; : <span class="${medicine.mrp}">&#x20b9;
												1099</span>
										</p>
										<p>
											Discount&emsp;: <span class="product-discount">&#x20b9;
												100</span>
										</p>
										<hr>
										<p>
											Total Price&nbsp; : <span class="product-price">&#x20b9;
												999</span>
										</p>
									</div>
								</div>
								<hr>
							</c:forEach>
							<div class="row ml-1">
								<div class="col-12 p-2 seller-details">
									<span id="seller-name">Seller Name</span>
									<p>
										Seller Address: <span id="seller-address: ">Lorem ipsum
											dolor sit amet consectetur adipisicing elit. Minus, expedita.</span>
									</p>
								</div>

							</div>
						</div>
					</div>
				</div>
			</aside>

		</div>


	</section>
	<div class="row deliver-btn my-2  ">
		<button class="btn btn-outline-primary float-right col-2 offset-8 py-2 ">Cash
			on delivery</button>

	</div>
	<div class="row deliver-btn my-2  ">

		<button class="btn btn-outline-primary float-right col-2 offset-8 py-2 ">Online
			Payment</button>
	</div>




	<!-- footer -->
	<%@include file="Footer.jsp"%>
</body>

</html>