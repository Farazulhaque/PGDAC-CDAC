<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
		integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
	<link rel="stylesheet" href="css/mystyle.css" />
	<script src="js/myjScript.js"></script>
</head>

<body class="">
	<!-- header section -->
	<header class="container-fluid row" id="headertop">
		<!-- logo -->
		<div class="col-3">
			<img src="./image/logo1.png" alt="@logo" height="auto" width="200px" />
		</div>

		<!-- search -->
		<div class="col-5 mt-3">
			<form class="d-flex input-group">
				<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
				<div class="input-group-append">
					<button class="btn btn-" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</form>
		</div>

		<!-- accountSec    -->
		<div class="accountSec col-3 mt-3 navbar-expand-lg" id="acctTop">
			<button class="btn dropdown-toggle float-lg-right float-md-right" type="button" data-toggle="dropdown"
				aria-expanded="false">
				<i class="fas fa-user">Account</i>
			</button>
			<ul class="dropdown-menu">
				<li>
					<a href="/UserLogin">LOGIN</a>
				</li>
				<li>
					<a href="/UserSignup">SIGNUP</a>
				</li>

				<li>
					<hr class="dropdown-divider" />
				</li>
				<li><a class="dropdown-item" href="#">SELLER</a></li>
			</ul>
		</div>

		<!-- cart -->
		<div class="container-fluid col-1 mt-3">
			<a href="cart.html" class="btn" role="button"><i class="fas fa-cart-plus">Cart</i>
			</a>
		</div>
	</header>

	<!-- nav bar -->
	<nav class="navbar navbar-expand-lg navbar-light nav-bgcolor CustmPadingMargin" id="top_nav">
		<div class="container-fluid">
			<!-- nav hide on big screen -->
			<div id="navhide" class="container-fluid ml-auto">
				<div class="row container-fluid" id="uperrow">
					<!-- togler button -->
					<div class="col-2" id="navtoglerbtn">
						<button class="navbar-toggler align-self-start border-0 bg-white rounded" type="button">
							<span class="navbar-toggler-icon"></span>
						</button>
					</div>

					<!-- logo nav-->
					<div class="col-4" id="navlogo">
						<div class="mobnavlogobg" id="logonav">
							<img src="./image/logo1.png" alt="@logo" height="auto" width="100px" />
						</div>
					</div>

					<!-- cart nav -->
					<div class="col-2 offset-4 justify-content-around" id="navcart">
						<a href="cart.html" class="btn" role="button"><i class="fas fa-cart-plus">Cart</i>
						</a>
					</div>
				</div>

				<!-- search nav -->
				<div class="container-fluid mt-1 ml-auto row" id="navhide">
					<form class="d-flex input-group" id="searchnav">
						<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
						<div class="input-group-append">
							<button class="btn btn-" type="submit">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</form>
				</div>
			</div>

			<div class="collapse navbar-collapse p-3 p-lg-0 mt-lg-0 d-flex flex-column flex-lg-row flex-xl-row justify-content-lg-end mobileMenu"
				id="navbarSupportedContent">
				<ul class="navbar-nav align-self-stretch navUl">
					<!-- nav close button -->
					<!-- <button type="button" class="btn btnclsnav" id="navhide">
              <span aria-hidden="true">&times;</span>
            </button> -->
					<a class="btnclsnav" id="navhide"><img alt="logo" src="./image/Closeicon.png" height="30px"
							width="30px" </a> <li class="nav-item">
						<a class="nav-link active" aria-current="page" href="./index.html"><i
								class="fa fa-home"></i>Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="Adeel/Product.html"><i class="fa fa-store"></i>Shop</a>
						</li>
						<li class="nav-item">
							<a href="./aboutus.html" class="nav-link" role="button">About Us</a>
						</li>
						<li class="nav-item">
							<a href="contactus.html" class="nav-link" role="button"><i
									class="fa fa-address-book"></i>Contact Us</a>
						</li>
						<!-- accountSec after size decrease -->
						<li class="nav-item" id="accountSec">
							<button class="btn dropdown-toggle" type="button" data-toggle="dropdown"
								aria-expanded="false">
								<i class="fas fa-user"></i>ACCOUNT
							</button>
							<ul class="dropdown-menu">
								<li>
									<a href="./login.html">LOGIN</a>
								</li>
								<li>
									<a href="./signup.html">SIGNUP</a>
								</li>

								<li>
									<hr class="dropdown-divider" />
								</li>
								<li><a class="dropdown-item" href="#">SELLER</a></li>
							</ul>
						</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="overlay"></div>
	<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

	<!-- image banner for  -->
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
					<img class="d-block" src="./image/custompg.png" alt="First Slide" height="350px"
						width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide One</h3>
						<p></p>
					</div>
				</div>
				<div class="carousel-item sizeforimage">
					<img class="d-block" src="./image/img2.jpg" alt="Second Slide" height="350px" width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide Two</h3>
						<p></p>
					</div>
				</div>
				<div class="carousel-item sizeforimage">
					<img class="d-block banerimg" src="./image/img3.jpg" alt="Third Slide" height="350px"
						width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide Three</h3>
						<p></p>
					</div>
				</div>
				<div class="carousel-item sizeforimage">
					<img class="d-block banerimg" src="./image/img1.jpg" alt="four Slide" height="350px"
						width="100% auto" />
					<div class="carousel-caption d-none d-md-block">
						<h3>Slide four</h3>
						<p></p>
					</div>
				</div>
			</div>

			<!-- CONTROLS -->
			<a href="#slider4" class="carousel-control-prev" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a>

			<a href="#slider4" class="carousel-control-next" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</aside>

	<!-- dummytext -->

	<div class="container container-fluid" id="dummytext">
		<div class="row">
			<div class="">
				<h1 class="text-primary text-center">
					What Are You Looking for?????
				</h1>
			</div>
		</div>
	</div>

	<!-- categery -->
	<section class="container-fluid pl-0">
		<div class="row ml-0 categery-outter-div">
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/mask2.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/sen.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/q__2.png" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/medwhit.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/medinhadoran.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/glasswater.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/tablet.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="./categories.html" class="">
					<img class="d-block" src="./image/imgpng/smp2.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/fruits.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/salad.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/q__3.png" alt="First Slide" />
				</a>
			</div>
			<div class="bg-white float-left widthSet">
				<a href="#" class="">
					<img class="d-block" src="./image/imgpng/wloss.png" alt="First Slide" />
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
						<h1 class="text-primary pb-3">
							Hear what people are saying about us.
						</h1>
						<p class="lead">
							Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias
							laborum numquam aperiam dolores a porro!
						</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof1.png" alt="" class="img-fluid rounded-circle w-50 mb-3" />
							<h3>wali</h3>

							<p>
								Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed
								commodi nostrum, ab libero voluptas officia.
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof1.png" alt="" class="img-fluid rounded-circle w-50 mb-3" />
							<h3>naiyer abdullah</h3>
							<p>
								Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed
								commodi nostrum, ab libero voluptas officia.
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof2.png" alt="" class="img-fluid rounded-circle w-50 mb-3" />
							<h3>addel saddam</h3>

							<p>
								Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed
								commodi nostrum, ab libero voluptas officia.
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="card-body">
							<img src="./image/imgpng/prof3.png" alt="" class="img-fluid rounded-circle w-50 mb-3" />
							<h3>Faraz</h3>

							<p>
								Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed
								commodi nostrum, ab libero voluptas officia.
							</p>
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
	<footer id="main-footer" class="container-fluid">
		<div class="row align-items-center">
			<div id="addresssection" class="col">
				<p>
					<b>Visit us at:</b><br />
					mediwalabox.com<br />
					Bailey road<br />
					Patna<br />
					Bihar<br />
					800014
				</p>
			</div>

			<div id="Copyrightsection" class="col">
				<div class="">
					<p>
						<b>Copyright &copy;
							<span id="footeryear"></span>
							'G3'<br />
							All Rights Reserved.</b>
					</p>
				</div>
			</div>

			<div id="footerSocialMedia" class="col">
				<div class="">
					<p><i class="fa fa-mobile"></i> +91 1234567890</p>
					<p><i class="fa fa-mobile"></i> +91 1234567890</p>
				</div>

				<div class="d-flex justify-content-center socialmediatag">
					<div class="p-1">
						<a href="http://facebook.com">
							<img src="./image/imgpng/facebook.png" alt="@fb" width="30px" />
						</a>
					</div>
					<div class="p-1">
						<a href="http://twitter.com">
							<img src="./image/imgpng/twitter.png" alt="@tw" width="35px" />
						</a>
					</div>
					<div class="p-1">
						<a href="http://instagram.com">
							<img src="./image/imgpng/instagram.png" alt="@inst" width="30px" />
						</a>
					</div>
					<div class="p-1">
						<a href="http://www.whatsapp.com">
							<img src="./image/imgpng/WhatsApp-logo.png  " alt="@wapp" width="30px" />
						</a>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>