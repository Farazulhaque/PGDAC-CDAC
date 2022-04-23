<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>${medicine.medicineName }&nbsp;${medicine.typeOfSell }</title>
	<link rel="stylesheet" href="css/productstyle.css" />
</head>

<body>
	<!-- Header -->
	<%@include file="Header.jsp"%>

	<div class="container product-section">
		<div class="row ml-0     product-details">
			<div class="col-md-6 ">
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
					<div class="carousel-inner ml-0 mt-4">
						
						<div class="carousel-item ml-0">
							<img src="image/imgpng/medicine.png" class="d-block w-100 productpageimage-main"
								alt="First Slide" />
						</div>
						<div class="carousel-item active ml-0">
							<img src="/image/imgpng/medwhit.png" class="d-block w-100 productpageimage-main"
								alt="Second Slide" />
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-5 offset-1 mt-4">
				<input type="hidden" id="medId" value="${medicine.medicineId}">
				<div class="row">
					<h4>${medicine.medicineName }</h4>
				</div>
				<div class="row">
					<h6>By ${medicine.manufacture.manufactureName }</h6>
				</div>
				<div class="row">
					<h6>${medicine.typeOfSell }</h6>
				</div>
				<div class="row">
					<h4>&#x20b9;
						<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
							value="${ medicine.mrp - (medicine.mrp/100)*5 } " />
					</h4>
					&nbsp; &nbsp;
					<h5>
						<del>&#x20b9;${medicine.mrp }</del>
					</h5>
					&nbsp; &nbsp;
					<h4 class="text-success">5% off</h4>
				</div>
				<div class="row">
					<p>Inclusive of all taxes</p>
				</div>

				<!-- ******************** Pincode ********************* -->
				<div class="row mr-2">
					<h3 class="text-success">
						<i class="fa fa-map-marker" aria-hidden="true"></i>
					</h3>
					<input class="pincode ml-2" type="text" placeholder="Enter Delivery Pincode" pattern="^[0-9]{6}$"
						title="Enter valid PinCode" id="pincode"> <button class="btn pincode-btn ml-2"
						onclick="checkPincode()">Check</button>
					<h6>Check the availability of medicine in your area</h6>
					<p id="seller-message" style="font-weight: 500;"></p>
				</div>
				<br><br>
				<!-- ************ Add Quantity Button ************* -->
				<!-- <div class="quantity buttons_added mb-3">
					<select required>
						<option value="">--Select the Quantity--</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div> -->

				<!-- ************ Add to wishlist/cart button ************* -->
				<div class="row">
					<a href="Wishlist.html" class="btn wishlist-btn mr-3"><span>+
							Add to Wish List</span></a> <a href="#" class="btn" id="addToCartbtn"
						onclick="add_to_cart('${medicine.medicineId }','${medicine.medicineName}','${medicine.typeOfSell }' ,'${medicine.manufacture.manufactureName}', '${medicine.mrp }')">
						<i class="fa fa-cart-plus"></i>Add to Cart
					</a>
				</div>
				<!-- ************ Composition ************** -->
				<div class="row mt-4">
					<h6>
						<c:if test="${medicine.salt != null}">
							Composition:- ${medicine.salt }
						</c:if>
					</h6>
				</div>
			</div>
		</div>
	</div>
	<hr>

	<!-- ******** Similar Products ******** -->
	<div class="container container-fluid">
		<div class="row mt-2"></div>
		<h3>Similar Products</h3>
	</div>

	<div class=" row productpage-similar-outerDiv">

		<c:forEach var="item" items="${alternateMedicine}">
			<%-- <c:if test="${item.medicineId } != ${medicine.medicineId }"> --%>
			<div class="productpage-similar">
				<div class="product-image">
					<img src="../image/imgpng/tablet3.png" alt="First Similar Product" />
				</div>
				<br>
				<a href="/product?mid=${item.medicineId}">${item.medicineName }</a>
				
				<br> <span>${item.typeOfSell}</span><br> <span>${item.manufacture.manufactureName}</span><br>
				<strong><span>&#x20b9;${item.mrp}</span></strong><br>
			</div>
			<%-- </c:if> --%>
		</c:forEach>

	</div>
	<hr>

	<!-- *********** Descriptions ************** -->
	<div class="container para mt-2 mb-1">
		<div>
			<h5>How To Use</h5>
			<p>${medicine.howToUse }</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div>
			<h5>Side Effects</h5>
			<p>${medicine.sideEffects }</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div class="ingredients">
			<h5>Salt</h5>
			<p>${medicine.salt }</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div>
			<h5>Chemical Class</h5>
			<p>${medicine.chemicalClass.chemicalName }</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div>
			<h5>Therapeutic Class</h5>
			<p>${medicine.therapeuticClass.tName }</p>
		</div>
	</div>

	<hr>
	<!-- ************ Disclaimer ************ -->
	<div class="container para mt-1 mb-1">
		<div class="directions_for_use">
			<h5>Disclaimer</h5>
			<p>The information provided herein is supplied to the best of our
				abilities to make it accurate and reliable as it is published after
				a review by a team of professionals. This information is solely
				intended to provide a general overview on the product and must be
				used for informational purposes only. You should not use the
				information provided herein to diagnose, prevent, or cure a health
				problem. Nothing contained on this page is intended to create a
				doctor-patient relationship, replace or be a substitute for a
				registered medical practitioner's medical treatment/advice or
				consultation. The absence of any information or warning to any
				medicine shall not be considered and assumed as an implied
				assurance. We highly recommend that you consult your registered
				medical practitioner for all queries or doubts related to your
				medical condition. You hereby agree that you shall not make any
				health or medical-related decision based in whole or in part on
				anything contained in the Site.</p>
		</div>
	</div>
	<hr>

	<!-- ************************** Footer Description ***************************** -->
	<div class="container mt-2 mb-2 ft-dsc">
		<div class="footer-description">
			<div class="center">
				<h2 class="text-primary">
					<i class="fa fa-ribbon"></i>
				</h2>
			</div>
			<h5>1 lakh+ Products</h5>
			<p>We maintain strict quality controls on all our partner
				retailers, so that you always get standard quality products.</p>
		</div>

		<div class="footer-description ml-5">
			<div class="center">
				<h2 class="text-primary">
					<i class="fa fa-money-bill-wave"></i>
				</h2>
				<br>
			</div>
			<h5>COD payment option</h5>
			<p>We are currently providing only Cash On Delivery option for
				the payment</p>
		</div>

		<div class="footer-description ml-5">
			<div class="center">
				<h2 class="text-primary">
					<i class="fa fa-calendar"></i>
				</h2>
				<br>
			</div>
			<h5>Easy Return</h5>
			<p>If you found any mismatch in the medicines you have ordered or
				any expired medicine supplied to you then you can easily return it
				the back within 24 hours from the time of delivery</p>
		</div>
	</div>


	<!-- footer -->
	<%@include file="Footer.jsp"%>
</body>
<script>
	function checkPincode() {
		var pincode = document.getElementById("pincode").value;
		var ajax = new XMLHttpRequest();
		var url = "findSeller?pincode=" + pincode;
		ajax.onreadystatechange = function () {
			if (ajax.readyState == 4) {
				let res = ajax.responseText
				let result = JSON.parse(res);
				if (result["seller"] == null) {
					document.getElementById("seller-message").innerHTML = "Seller not available at this location";
					document.getElementById("seller-message").style.color = "red";
				} else {
					var mid = document.getElementById("medId").value;
					var url2 = "getSellerMedicineData?sid=" + result["seller"]["sellerId"] +
						"&mid=" + mid;
					checkMedicineDataAtSeller(url2, mid);


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
				// check if product is available or not at seller
				if (result2["smm"] == null) {
					document.getElementById("seller-message").innerHTML =
						"Seller available but Medicine out of stock";
					document.getElementById("seller-message").style.color = "red";
				} else {
					document.getElementById("seller-message").innerHTML =
						"Seller and Medicine available at this location";
					document.getElementById("seller-message").style.color = "green";
				}
			}
		}
		ajax2.open("GET", url2, true);
		ajax2.send(null);
	}
</script>

</html>