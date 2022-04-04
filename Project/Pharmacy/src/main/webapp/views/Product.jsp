<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/productstyle.css" />
</head>
<body>
	<!-- Header -->
	<%@include file="Header.jsp"%>

	<div class="container product-section">
		<div class="row ml-0     product-details">
			<div class="col-md-6 ">
				<div id="carouselExampleControls" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-inner ml-0 mt-4">
						<div class="carousel-item active ml-0">
							<img src="./image/cildip1.jpg"
								class="d-block w-100 productpageimage-main" alt="First Slide" />
						</div>
						<div class="carousel-item ml-0">
							<img src="./image/cildip2.jpg"
								class="d-block w-100 productpageimage-main" alt="Second Slide" />
						</div>
						<div class="carousel-item ml-0">
							<img src="./image/cildip3.jpg"
								class="d-block w-100 productpageimage-main" alt="Third Slide" />
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-5 offset-1 mt-4">
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
					<h4>₹ 106.60</h4>
					&nbsp; &nbsp;
					<h5>
						<del>&#x20b9;${medicine.mrp }</del>
					</h5>
					&nbsp; &nbsp;
					<h4 class="text-success">15% off</h4>
				</div>
				<div class="row">
					<p>Inclusive of all taxes</p>
				</div>

				<!-- ******************** Pincode ********************* -->
				<div class="row mr-2">
					<h3 class="text-success">
						<i class="fa fa-map-marker" aria-hidden="true"></i>
					</h3>
					<input class="pincode ml-2" type="text"
						placeholder="Enter Delivery Pincode" pattern="^[0-9]{6}$"
						title="Enter valid PinCode"> <a href="#"
						class="btn pincode-btn ml-2"><span>Click here to check</span></a>
					<h6>Enter pincode to check the availability of medicine in
						your area</h6>
				</div>

				<!-- ************ Add Quantity Button ************* -->
				<div class="quantity buttons_added mb-3">
					<select required>
						<option value="">--Select the Quantity--</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>

				<!-- ************ Add to wishlist/cart button ************* -->
				<div class="row">
					<a href="Wishlist.html" class="btn wishlist-btn mr-3"><span>+
							Add to Wish List</span></a> <a href="#" class="btn"> <i
						class="fa fa-cart-plus" aria-hidden="true"></i>Add to Cart
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

	<div class="row productpage-similar-outerDiv">

		<c:forEach var="item" items="${alternateMedicine}">
			<c:if test="${item.medicineId } == ${medicine.medicineId }">
				<div class="productpage-similar">
					<a href="#"> <img src="../image/imgpng/smp1.png" class=""
						alt="First Similar Product" />
						<div>

							<h5 class="">${item.medicineName }</h5>
							<h5>&#x20b9; ${item.mrp}</h5>
						</div>
					</a>
				</div>
			</c:if>
		</c:forEach>

	</div>
	<hr>

	<!-- *********** Descriptions ************** -->
	<div class="container para mt-2 mb-1">
		<div class="description">
			<h5>Description</h5>
			<p>CILDIP T TABLET belongs to the class of anti-hypertensives
				primarily taken for the treatment of hypertension (high blood
				pressure) and heart-related chest pain (angina). It comprises of
				Cilnidipine (calcium channel blocker) and Telmisartan (angiotensin
				receptor blocker). Hypertension is a lifelong or chronic condition
				in which the force exerted by the blood against the artery walls
				becomes so high that it leads to heart diseases. Angina is chest
				pain caused by reduced blood flow to the heart.</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div class="benefits">
			<h5>Benefits</h5>
			<p>CILDIP T TABLET is composed of Cilnidipine and Telmisartan,
				prescribed to treat hypertension. Cilnidipine blocks the activities
				of the calcium channels present in the blood vessels of the heart.
				As a result, the blood vessels widen, and supply to the heart
				increases, lowering the elevated blood pressure and the workload
				placed on the heart. Due to its calcium channel blocking nature it
				may be also prescribed for relieving the heart's workload caused due
				to the heart attack or stroke. Telmisartan works by blocking the
				action of certain substances that are responsible for tightening the
				blood vessels. It allows the blood to flow more smoothly and makes
				the heart more efficient at pumping blood throughout the body. Thus,
				it reduces the chance of having any heart attack or stroke in the
				future. Additionally, it has a protective effect on the kidney, and
				in the condition of diabetes.</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div class="ingredients">
			<h5>Ingredients</h5>
			<p>CILDIP T TABLET is composed of Cilnidipine and Telmisartan,
				prescribed to treat hypertension.</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div class="uses">
			<h5>Uses</h5>
			<p>Hypertension (high blood pressure)</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div class="directions_for_use">
			<h5>Directions for Use</h5>
			<p>CILDIP T TABLET should be taken daily one with food to allow
				its slow absorption and to reduce risk of sudden lowering of blood
				pressure. Swallow the whole tablet with a glass of water. Do not
				crush, chew, or break it.</p>
		</div>
	</div>

	<div class="container para mt-1 mb-1">
		<div class="side_effects">
			<h5>Side Effects</h5>
			<p>Most of the side effects of CILDIP T TABLET do not require
				medical attention and gradually resolve over time. Most of the
				common side effect of CILDIP T TABLET are sore back, diarrhoea,
				congested feeling, spinning sensation, soreness in the sinus. It is
				not necessary for everyone to experience the above side effects.
				However, if these side effects are persistent, reach out to your
				doctor.</p>
		</div>
	</div>
	<hr>
	<!-- ********************** Safety Advice ************************ -->
	<div class="container para mt-2 mb-2">
		<div class="safety_advice">
			<h5>Safety Advice</h5>
			<p>
				<b>ALCOHOL (Consult your Doctor)</b><br> CILDIP T TABLET can
				lower your blood pressure causing dizziness and drowsiness. It can
				also cause orthostatic hypotension (sudden fall in blood pressure
				while standing). So try to avoid intake of CILDIP T TABLET with
				alcoholic beverages.<br> <b>PREGNANCY</b><br> There are no
				clinical data on the safety of CILDIP T TABLET during pregnancy. So,
				it should be taken with caution.<br> <b>BREAST FEEDING</b><br>
				Nursing mother should consult doctor before taking CILDIP T TABLET.<br>
				<b>DRIVING (Consult your Doctor)</b><br> CILDIP T TABLET may
				cause side effects which could affect your ability to drive. Taking
				CILDIP T TABLET may lower your blood pressure<br> <b>LIVER</b><br>
				There is limited information available on the use of CILDIP T TABLET
				in patients with liver disease. So CILDIP T TABLET should be taken
				with caution and with consultation to doctor only.<br> <b>KIDNEY</b><br>
				CILDIP T TABLET is probably safe to use in patients with kidney
				disease. It has shown beneficial and protective effect on the
				kidney.CILDIP T TABLET is probably safe to use in patients with
				kidney disease. It has shown beneficial and protective effect on the
				kidney.<br>
			</p>
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
</html>