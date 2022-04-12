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
    <div class="cart p-4">

        <div class="row">
            <div class="col-sm-8">
                <h3 style="height: 50px; line-height: 50px; background-color: rgb(190, 231, 231); padding-left: 1%;">
                    Your Cart (<span id="your-cart">0</span>)</h3>
                <hr style="height: 5px; box-shadow: inset 0 9px 90px -30px rgba(5, 73, 136, 0.8);">
                <!-- <br> -->
                <div id="empty-cart">
                    <h2>Your Cart is Empty</h2>
                    <a href="/home">Order Now</a>
                </div>

                <div id="cart-item">
                    <!-- this section is filled dynamically using javascript -->
                </div>

            </div>
            <div class="col-sm-4">
                <div class="checkout-section">
                    Total Price: <span id="total">0</span>
                    <br>
                    Delivery Cost:<span id="delivery-fee">0</span>
                    <br>
                    Discount: <span id="discount">0</span>
                    <hr>
                    Grand Total: <span id="grandTotal">0</span>
                    <br>
                    <br>
                    <button id="checkout-btn">Order Now</button>
                    <br>
                    <br>
                    <p class="checkout-msg">
                        Flat 5% discount when total > 500
                        <br>
                        Zero Cost Delivery when total > 500
                    </p>
                </div>
            </div>
        </div>
    </div>
    
    <!-- footer -->
    <%@include file="Footer.jsp"%>
</body>

</html>