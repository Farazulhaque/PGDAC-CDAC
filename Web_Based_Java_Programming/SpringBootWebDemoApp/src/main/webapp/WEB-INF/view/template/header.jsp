<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<!-- Logo -->
					<div class="logo">
						<h1></h1>
					</div>
				</div>
				<div class="col-md-5">
					<div class="row">
						<div class="col-lg-12"></div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="navbar navbar-inverse" role="banner">
						<nav
							class="collapse navbar-collapse bs-navbar-collapse navbar-right"
							role="navigation">
							<ul class="nav navbar-nav">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Welcome  ${currentUser.login}<b class="caret"></b></a>
									<ul class="dropdown-menu animated fadeInUp">
										<li><a href="/logout">Logout</a></li>
									</ul></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>