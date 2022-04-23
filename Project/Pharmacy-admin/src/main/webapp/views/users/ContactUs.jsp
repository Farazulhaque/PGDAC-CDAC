<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<!-- Header -->
	<%@include file="Header.jsp"%>
	<section id="contact" class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-lg-7">
					<h3>Get In Touch</h3>
					<p class="lead">Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Ratione, temporibus!</p>
					<form>
						<div class="input-group input-group-lg mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fas fa-user"></i>
								</span>
							</div>
							<input type="text" class="form-control" placeholder="Name" />
						</div>

						<div class="input-group input-group-lg mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i
									class="fas fa-envelope"></i>
								</span>
							</div>
							<input type="text" class="form-control" placeholder="Email" />
						</div>

						<div class="input-group input-group-lg mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i
									class="fas fa-pencil-alt"></i>
								</span>
							</div>
							<textarea class="form-control" placeholder="Message" rows="5"></textarea>
						</div>

						<input type="submit" value="Submit"
							class="btn btn-primary btn-block btn-lg" />
					</form>
				</div>

				<div class="col-lg-5 align-self-center">
					<div class="contact_address">
						<strong>Address: </strong> <i>Lorem ipsum dolor sit amet. <br />
							Lorem ipsum dolor sit amet. <br /> Pin code: 800014 <br />
						</i> ______________________________________ <br />
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14005.579926372042!2d179.9910578717378!3d28.64788980000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39ed57b8f44ad4e1%3A0x510a40ceb5e2147f!2sAstric%20Centre%20Of%20Excellence!5e0!3m2!1sen!2sin!4v1646331460522!5m2!1sen!2sin"
							width="500" height="450" style="border: 0" allowfullscreen=""
							loading="lazy"></iframe>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<%@include file="Footer.jsp"%>
</body>

</html>