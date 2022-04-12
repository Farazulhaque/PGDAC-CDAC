<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>
    <%@include file="Header.jsp" %>

    <div class="container mt-3">
        <div class="row">
            <div class="col-md-8 col-lg-6">

                <div class="address-div mt-3">
                    <div>
                        <h5><i class='fas fa-shipping-fast'></i>Shipping Address</h5>
                    </div>
                    <br>

                    <div class="card h-80 address-section " id="address-section">
                        <div class="add-address ml-3 mr-3 mb-3 mt-3">
                            <button class="btn btn-outline-info" data-toggle="collapse"
                                data-target="#input-address-section"></i>Add new Address</button>
                        </div>
                        <div class="<c:if test="${!editAddForm}">collapse</c:if>" id="input-address-section">
                            <form action="saveUserAddressCheckout" method="post">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">

                                    <!-- geting currntuserid for insrting -->
                                    <input type="text" name="user" value="${userdetails.userId}" class="form-control"
                                        hidden>

                                    <!-- geting currntuseraddressid for insrting -->
                                    <c:if test="${editAddForm}">
                                        <input type="text" name="userAddressId"
                                            value="${editAddFormDetails.userAddressId}" class="form-control" hidden>
                                    </c:if>
                                    <div class="form-group">
                                        <label for="fullName">Full Name</label>
                                        <input type="text" name="name" value="${editAddFormDetails.name}"
                                            class="form-control" id="fullName">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="contactno">Contact Number</label>
                                        <input type="text" name="mobileNumber"
                                            value="${editAddFormDetails.mobileNumber}" class="form-control"
                                            id="contactno" placeholder="Contact Number">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="address">Address(Area/Street/Locality)</label>
                                        <textarea class="form-control" name="localityAreaStreet"
                                            id="address" rows="5" cols="10">${editAddFormDetails.localityAreaStreet}
                                       </textarea>
                                    </div>
                                </div>

                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="landmark">Landmark</label>
                                        <input type="text" value="${editAddFormDetails.landmark}" class="form-control"
                                            name="landmark" id="landmark">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="city">City</label>
                                        <input type="text" value="${editAddFormDetails.city}" class="form-control"
                                            name="city" id="city">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="state">State</label>
                                        <input type="text" value="${editAddFormDetails.state}" class="form-control"
                                            name="state" id="state">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="pincode">Pincode</label>
                                        <input type="text" class="form-control" name="pincode"
                                            value="${editAddFormDetails.pincode}" id="pincode">
                                    </div>
                                </div>

                                <div class="save-address col-8">
                                    <c:if test="${!editAddForm}">
                                        <input type="submit" class="save-address-btn btn btn-primary" value="submit">
                                    </c:if>
                                    <c:if test="${editAddForm}">
                                        <button type="submit" formaction="/updateUserAddressCheckout"
                                            class="save-address-btn btn btn-primary">Update</button>
                                    </c:if>
                                </div>
                            </form>
                        </div>
                        <c:forEach var="address" items="${userdetails.userAddresses }">
                            <div class="user-address-section mt-3 ml-3 mb-2 mr-3 ">
                                <div id="radio">
                                    <input type="radio" value="current" name="address-sel" id="address-sel" checked>
                                </div>
                                <div class="left">
                                    <span class="username">${address.name}</span> &nbsp;
                                    <span class="usercontactno">${address.mobileNumber}</span>
                                    <br>
                                    <span class="useraddress">${address.localityAreaStreet}</span>
                                    <br>
                                    <span class="userlandmark">${address.landmark}</span>
                                    <br>
                                    <span class="usercity">${address.city}</span>,
                                    <span class="userstate">${address.state}</span> -
                                    <span class="userpincode">${address.pincode}</span> &nbsp;
                                </div>
                                <div class="right mr-5">

                                    <a class="btn btn-success " href="/editUserAddressCheckout?userAId=${address.userAddressId}	"><i
                                            class='fas fa-pencil-alt'></i>&nbsp;</a>
                                   
                                </div>

                            </div>
                        </c:forEach>
                    </div>
                    <button class="btn btn-outline-primary">Deliver Here</button>

                </div>
            </div>
            <div class="col-md-4 col-lg-5">

                <section id="myorderpage">
                    <h3>Price Details </h3>
                    <div class="row orderrow">
                        <div class="col-6">
                            <p>Price(1 itmes) &emsp;: <span id="order-date">29-03-2022</span></p>
                            <p>Delivery charge : <span id="order-date">&#x20b9; 50</span></p>
                            <h6>Total Price &emsp;: <span id="grand-total-price"> &#x20b9; 5999</span></h6>
                        </div>
                    </div>
                </section>
            </div>
             <div class="col-md-7 offset-md-0">
        <div  id="order-details">
            <div class="container-fluid row ml-1 order-item">
                <div class="col-6 col-md-6 p-2">
                    <h6 id="product-name">Product Name1</h6>
                    <p id="product-description">Product Description1</p>
                    <!-- <br>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Hic nulla fugiat eius corrupti
                        nostrum quasi esse optio provident quis nemo!</p> -->
                </div>
                <div class="col-4 offset-1 p-2">
                    <br>
                    <p>MRP &emsp;&emsp;&nbsp; : <span class="product-mrp">&#x20b9; 99</span></p>
                    <p>Discount&emsp;: <span class="product-discount">&#x20b9; 00</span></p>
                    <hr>
                    <p>Total Price&nbsp; : <span class="product-price">&#x20b9; 99</span> </p>
                </div>
            </div>
            <hr>
            
            <div class="row ml-1">
                <div class="col-12 p-2 seller-details">
                    <span id="seller-name">Seller Name</span>
                    <p>Seller Address: <span id="seller-address: ">Lorem ipsum dolor sit amet consectetur
                            adipisicing</span></p>
                </div>
    
            </div>
        </div>
        <div class="mt-2">
        <button class="btn btn-outline-primary">Proceed to Payment</button>
    </div>
    
    </div>
        </div>
    </div>
    <!-- footer -->
    <%@include file="Footer.jsp"%>
</body>

</html>