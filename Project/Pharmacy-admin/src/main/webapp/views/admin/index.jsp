<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>










 <%@include file="../templates/header.jsp" %>
 
	
	
	
	
	
	<!-- HEADER -->
    <header id="main-header" class="py-2 bg-primary text-white">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1><i class="fas fa-cog"></i> Dashboard</h1>
          </div>
        </div>
      </div>
    </header>

    <!-- ACTIONS -->
    <section id="actions" class="py-4 mb-4 bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <a href="/collapseADDMedicineData" class="btn btn-primary btn-block">
              <i class="fas fa-plus"></i> ADD Medicine Data
            </a>
          </div>
          <div class="col-md-3">
            <a href="/medicinemaster" class="btn btn-success btn-block">
              <i class="fas fa-plus"></i> Medicine inventery
            </a>
          </div>
          <div class="col-md-3">
            <a href="SellerDetails.jsp" class="btn btn-warning btn-block">
              <i class="fas fa-plus"></i> Seller
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- LATEST ORDER -->
    <section id="LatestOrder">
      <div class="container">
        <div class="row">
          <div class="col-md-9">
            <div class="card">
              <div class="card-header">
                <h4>Pending Seller Request</h4>
              </div>
              <table class="table table-striped">
                <thead class="thead-dark">
                  <tr>
                    <th>SellerID</th>
                    <th>ShopName</th>
                    <th>PinCode</th>
                    <th>Status</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${pendingSeller}">
	                  <tr>
	                    <td>${item.sellerId}</td> 
	                    <td>${item.shopName}</td>
	                    <td>${item.shopPincode}</td>
	                    <td><c:if test="${item.status == 0}">On Hold</c:if>  <c:if test="${item.status == 1}">Active</c:if>               </td>
	                    <td>
	                       <a href="/sellerDetailsFind?sid=${item.sellerId}" class="btn btn-secondary">
	                        <i class="fas fa-angle-double-right"></i> Details
	                      </a> 
	                    </td>
	                  </tr>
                  </c:forEach>
                
                </tbody>
              </table>
            </div>
          </div>
          <div class="col-md-3">
            <div class="card text-center bg-primary text-white mb-3">
              <div class="card-body">
                <h3>Seller</h3>
                <h4 class="display-4"><i class="fas fa-pencil-alt"></i>${sellerCount}</h4>
                <a href="/seller" class="btn btn-outline-light btn-sm"
                  >View</a
                >
              </div>
            </div>

            <div class="card text-center bg-success text-white mb-3">
              <div class="card-body">
                <h3>PendingOrder</h3>
                <h4 class="display-4"><i class="fas fa-folder"></i> 4</h4>
                <a href="categories.html" class="btn btn-outline-light btn-sm"
                  >View</a
                >
              </div>
            </div>

            <div class="card text-center bg-warning text-white mb-3">
              <div class="card-body">
                <h3>Users</h3>
                <h4 class="display-4"><i class="fas fa-users"></i> ${userCount}</h4>
                <a href="/Users" class="btn btn-outline-light btn-sm"
                  >View</a
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
	


 <%@include file="../templates/footer.jsp" %>

</body>
</html>