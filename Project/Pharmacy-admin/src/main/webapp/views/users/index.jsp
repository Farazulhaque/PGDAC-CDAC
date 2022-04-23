<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<body class="">
	<!-- Header -->
	<%@include file="Header.jsp"%>

	<!-- image banner -->
	<aside class="mt-1" id="banner">
		<!-- SLIDER WITH CAPTIONS -->
		<div id="slider4" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li class="active" data-target="#slider4" data-slide-to="0"></li>
				<li class="active" data-target="#slider4" data-slide-to="1"></li>
				<li class="active" data-target="#slider4" data-slide-to="2"></li>
				<li class="active" data-target="#slider4" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active sizeforimage">
					<img class="d-block" src="./image/custompg.png" alt="First Slide"
						height="350px" width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide One</h3>
						<p></p>
					</div>
				</div>
				<div class="carousel-item sizeforimage">
					<img class="d-block" src="./image/img2.jpg" alt="Second Slide"
						height="350px" width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide Two</h3>
						<p></p>
					</div>
				</div>
				<div class="carousel-item sizeforimage">
					<img class="d-block banerimg" src="./image/img3.jpg"
						alt="Third Slide" height="350px" width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide Three</h3>
						<p></p>
					</div>
				</div>
				<div class="carousel-item sizeforimage">
					<img class="d-block banerimg" src="./image/img1.jpg"
						alt="four Slide" height="350px" width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide four</h3>
						<p></p>
					</div>
				</div>
			</div>

			<!-- CONTROLS -->
			<a href="#slider4" class="carousel-control-prev" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a href="#slider4" class="carousel-control-next" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</aside>

	<!-- dummytext -->

	<div class="container container-fluid" id="dummytext">
		<div class="row">
			<div class="">
				<h1 class="text-primary text-center">What Are You Looking
					for?????</h1>
			</div>
		</div>
	</div>

	<!-- categery -->
	<section class="container-fluid pl-0">
		<div class="row ml-0 categery-outter-div">
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/mask2.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/sen.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/q__2.png" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/medwhit.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/medinhadoran.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/glasswater.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/tablet.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="./categories.html" class=""> <img class="d-block"
					src="./image/imgpng/smp2.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/fruits.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/salad.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/q__3.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class=""> <img class="d-block"
					src="./image/imgpng/wloss.png" alt="First Slide" />
				</a>
			</div>
		</div>
	</section>

	<!-- review section -->

	<section id="review" class="my-5 text-center">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="info-header mb-5">
						<h1 class="text-primary pb-3">Hear what people are saying
							about us.</h1>
						<p class="lead">Lorem ipsum dolor sit amet consectetur
							adipisicing elit. Alias laborum numquam aperiam dolores a porro!
						</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof1.png" alt=""
								class="img-fluid rounded-circle w-50 mb-3" />
							<h3>wali</h3>

							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Sed commodi nostrum, ab libero voluptas officia.</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof1.png" alt=""
								class="img-fluid rounded-circle w-50 mb-3" />
							<h3>naiyer abdullah</h3>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Sed commodi nostrum, ab libero voluptas officia.</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof2.png" alt=""
								class="img-fluid rounded-circle w-50 mb-3" />
							<h3>addel saddam</h3>

							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Sed commodi nostrum, ab libero voluptas officia.</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof3.png" alt=""
								class="img-fluid rounded-circle w-50 mb-3" />
							<h3>Faraz</h3>

							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Sed commodi nostrum, ab libero voluptas officia.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- demo -->
	<div class="container container-fluid" id="salepamplets">
		<div class="row">
			<div class="">
				<img src="/image/salepamplets.png" alt="@demo" />
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@include file="Footer.jsp"%>

</body>

</html>