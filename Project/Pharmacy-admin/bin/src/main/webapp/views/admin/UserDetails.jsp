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
	<title>Admin-Userdetails</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
		integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
	<link rel="stylesheet" href="/css/mystyleadmin.css" />
	<script src="/js/myjScriptadmin.js"></script>
</head>

<body>

	<%@include file="../templates/header.jsp"%>




	<c:if test="${addressSave}">
		<div class="w-50  m-auto alert alert-success alert-dismissible fade show" role="alert">
			<strong>Success!</strong> Address saved successfully .
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<c:if test="${deletedAdd}">
		<div class="w-50 m-auto alert alert-danger alert-dismissible fade show" role="alert">
			<strong>Deleted!</strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


	<!-- Profile Page -->
	<div class="container mt-3">
		<div class="row gutters">
			<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
				<div class="card h-100">
					<div class="card-body">
						<div class="account-settings">
							<div class="user-profile">
								<div class="user-avatar">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="@profiepic">
								</div>
								<h5 class="user-name">${currentuser.fullName}</h5>
								<h6 class="user-email">${currentuser.emailId}</h6>
								<h6 class="user-contactno">${currentuser.contactNumber}</h6>
							</div>
							<hr>
							<div class="manage-address">
								<button type="button" data-toggle="collapse" data-target="#address-section">Manage
									Address</button>
							</div>
							<br>
							<div class="logout">
								<button>logout</button>
							</div>
						</div>
					</div>
				</div>
			</div>


			<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
				<div class=" row card h-80">
					<div class="card-body" id="add">
						<div class="row gutters">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
								<h6 class="mb-2 text-primary">Personal Details</h6>
							</div>

							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="fullName">Full Name</label> <input type="text"
										value="${currentuser.fullName}" class="form-control" id="fullName"
										placeholder="Full Name" disabled>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="eMail">Email-Id</label> <input type="email"
										value="${currentuser.emailId}" class="form-control" id="eMail"
										placeholder="Email ID" disabled>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="phone">Contact Number</label> <input type="text"
										value="${currentuser.contactNumber}" class="form-control" id="phone"
										placeholder="Contact Number" disabled>
								</div>
							</div>
						</div>
					</div>

					<br>

					<div class="card h-80 address-section <c:if test=" ${!editAddForm}">collapse</c:if> "
						id="address-section">
						<div class="add-address ml-3 mr-3 mb-3 mt-3">
							<button data-toggle="collapse" data-target="#input-address-section">
								</i>Add new Address
							</button>
						</div>


						<div class="<c:if test=" ${!editAddForm}">collapse</c:if>"
							id="input-address-section">


							<form action="addaddress" method="post">
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">

									<!-- geting currntuserid for insrting -->
									<input type="text" name="user" value="${currentuser.userId}" class="form-control"
										hidden>

									<!-- geting currntuseraddressid for insrting -->
									<c:if test="${editAddForm}">
										<input type="text" name="userAddressId"
											value="${editAddFormDetails.userAddressId}" class="form-control" hidden>
									</c:if>
									<div class="form-group">
										<label for="fullName">Full Name</label> <input type="text" name="name"
											value="${editAddFormDetails.name}" class="form-control" id="fullName">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="contactno">Contact Number</label> <input type="text"
											name="mobileNumber" value="${editAddFormDetails.mobileNumber}"
											class="form-control" id="contactno" placeholder="Contact Number">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="address">Address(Area/Street/Locality)</label>
										<textarea class="form-control" name="localityAreaStreet"
											value="${editAddFormDetails.localityAreaStreet}" id="address" rows="5"
											cols="10">
                                                </textarea>
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="landmark">Landmark</label> <input type="text"
											value="${editAddFormDetails.landmark}" class="form-control" name="landmark"
											id="landmark">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="city">City</label> <input type="text"
											value="${editAddFormDetails.city}" class="form-control" name="city"
											id="city">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="state">State</label> <input type="text"
											value="${editAddFormDetails.state}" class="form-control" name="state"
											id="state">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="pincode">Pincode</label> <input type="text" class="form-control"
											name="pincode" value="${editAddFormDetails.pincode}" id="pincode">
									</div>
								</div>

								<div class="save-address col-8">
									<c:if test="${!editAddForm}">
										<input type="submit" class="save-address-btn btn btn-primary" value="submit">
									</c:if>
									<c:if test="${editAddForm}">
										<button type="submit" formaction="/updateAddress"
											class="save-address-btn btn btn-primary">Update</button>
									</c:if>
								</div>
							</form>


						</div>




						<c:forEach var="address" items="${currentuser.userAddresses }">
							<div class="user-address-section mt-3 ml-3 mb-3 mr-3 p-3">

								<div class="left">
									<span class="username">${address.name}</span> &nbsp; <span
										class="usercontactno">${address.mobileNumber}</span> <br>
									<span class="useraddress">${address.localityAreaStreet}</span>
									<br> <br> <span class="userlandmark">${address.landmark}</span>
									<br> <span class="usercity">${address.city}</span>, <span
										class="userstate">${address.state}</span> - <span
										class="userpincode">${address.pincode}</span> &nbsp;
								</div>
								<div class="right mr-5">




									<%--  <form  method="post" action="editAddress/${address.userAddressId}"  >
			                                <button type="submit" class="edit-address">
			                                    <i class='fas fa-pencil-alt'></i>&nbsp;
			                                </button>
		                               	</form> 
		                                
		                                <form method="post" action="deleteAddress/${address.userAddressId}"  >
			                                <button class="delete-address">
			                                    <i class="fas fa-trash-alt"></i>
			                               </button>
		                                </form>
		                                 --%>

									<a class="btn btn-success " href="/editAddress?userAId=${address.userAddressId}	"><i
											class='fas fa-pencil-alt'></i>&nbsp;</a> <a class="btn btn-danger "
										href="/deleteAddress?userAId=${address.userAddressId}	"> <i
											class="fas fa-trash-alt"></i></a>
								</div>

							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>







	<%@include file="../templates/footer.jsp"%>




</body>

</html>