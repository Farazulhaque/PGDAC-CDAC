<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<!-- Header -->
	<%@include file="Header.jsp"%>





	<c:if test="${addressSave}">
		<div
			class="w-50  m-auto alert alert-success alert-dismissible fade show"
			role="alert">
			<strong>Success!</strong> Address saved successfully .
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<c:if test="${deletedAdd}">
		<div
			class="w-50 m-auto alert alert-danger alert-dismissible fade show"
			role="alert">
			<strong>Deleted!</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
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
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="@profiepic">
								</div>
								<h5 class="user-name">${userdetails.fullName}</h5>
								<h6 class="user-email">${userdetails.emailId}</h6>
								<h6 class="user-contactno">${userdetails.contactNumber}</h6>
							</div>
							<hr>
							<div class="manage-address">
								<button type="button" data-toggle="collapse"
									data-target="#address-section">Manage Address</button>
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
										value="${userdetails.fullName}" class="form-control"
										id="fullName" placeholder="Full Name" disabled>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="eMail">Email-Id</label> <input type="email"
										value="${userdetails.emailId}" class="form-control" id="eMail"
										placeholder="Email ID" disabled>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="phone">Contact Number</label> <input type="text"
										value="${userdetails.contactNumber}" class="form-control"
										id="phone" placeholder="Contact Number" disabled>
								</div>
							</div>
						</div>
					</div>

					<br>

					<div
						class="card h-80 address-section <c:if test="${!editAddForm}">collapse</c:if> "
						id="address-section">
						<div class="add-address ml-3 mr-3 mb-3 mt-3">
							<button data-toggle="collapse"
								data-target="#input-address-section">
								</i>Add new Address
							</button>
						</div>


						<div class="<c:if test="${!editAddForm}">collapse</c:if>"
							id="input-address-section">


							<form action="saveUserAdd" method="post">
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">

									<!-- geting currntuserid for insrting -->
									<%--  <input type="text" name="user"  value="${userdetails.userId}"    class="form-control" hidden> --%>

									<!-- geting currntuseraddressid for insrting -->
									<c:if test="${editAddForm}">
										<input type="text" name="userAddressId"
											value="${editAddFormDetails.userAddressId}"
											class="form-control" hidden>
									</c:if>
									<div class="form-group">
										<label for="fullName">Full Name</label> <input type="text"
											name="name" value="${editAddFormDetails.name}"
											class="form-control" id="fullName">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="contactno">Contact Number</label> <input
											type="text" name="mobileNumber"
											value="${editAddFormDetails.mobileNumber}"
											class="form-control" id="contactno"
											placeholder="Contact Number">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="address">Address(Area/Street/Locality)</label>
										<textarea class="form-control" name="localityAreaStreet"
											value="${editAddFormDetails.localityAreaStreet}" id="address"
											rows="5" cols="10">
                                                </textarea>
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="landmark">Landmark</label> <input type="text"
											value="${editAddFormDetails.landmark}" class="form-control"
											name="landmark" id="landmark">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="city">City</label> <input type="text"
											value="${editAddFormDetails.city}" class="form-control"
											name="city" id="city">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="state">State</label> <input type="text"
											value="${editAddFormDetails.state}" class="form-control"
											name="state" id="state">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="pincode">Pincode</label> <input type="text"
											class="form-control" name="pincode"
											value="${editAddFormDetails.pincode}" id="pincode">
									</div>
								</div>

								<div class="save-address col-8">
									<c:if test="${!editAddForm}">
										<input type="submit" class="save-address-btn btn btn-primary"
											value="submit">
									</c:if>
									<c:if test="${editAddForm}">
										<button type="submit" formaction="/updateUserAddress"
											class="save-address-btn btn btn-primary">Update</button>
									</c:if>
								</div>
							</form>


						</div>




						<c:forEach var="address" items="${userdetails.userAddresses }">
							<div class="user-address-section mt-3 ml-3 mb-3 mr-3 p-3">

								<div class="left">
									<span class="username">${address.name}</span> &nbsp; <br>
									<span class="usercontactno">${address.mobileNumber}</span> <br>
									<span class="useraddress">${address.localityAreaStreet}</span>
									<br> <br> <span class="userlandmark">${address.landmark}</span>
									<br> <span class="usercity">${address.city}</span>, <span
										class="userstate">${address.state}</span> - <span
										class="userpincode">${address.pincode}</span> &nbsp;
								</div>
								<div class="right mr-5">





									<a class="btn btn-success "
										href="/editUserAddress?userAId=${address.userAddressId}	"><i
										class='fas fa-pencil-alt'></i>&nbsp;</a> <a
										class="btn btn-danger "
										href="/deleteUserAddress?userAId=${address.userAddressId}	">
										<i class="fas fa-trash-alt"></i>
									</a>
								</div>

							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>












	<!-- footer -->
	<%@include file="Footer.jsp"%>



</body>
</html>