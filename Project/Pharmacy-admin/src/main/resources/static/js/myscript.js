$(document).ready(function () {
	//for nav on mobile view
	var fixHeight = function () {
		$('.navbar-nav').css(
			'max-height',
			document.documentElement.clientHeight - 150
		);
	};
	fixHeight();

	$(window).resize(function () {
		fixHeight();
	});

	$('.navbar .navbar-toggler').on('click', function () {
		fixHeight();
	});


	$('.navbar-toggler,.overlay,.btnclsnav').on('click', function () {
		$('.mobileMenu,.overlay,.btnclsnav').toggleClass('open');
	});

	//for banner portion
	$('.carousel').carousel({
		interval: 3000,
		keyboard: true,
		pause: 'hover',
		wrap: true
	});

	$('#slider4').on('slide.bs.carousel', function () {
		console.log('SLIDE!');
	});

	$('#slider4').on('slid.bs.carousel', function () {
		console.log('SLID!');
	});

	//current year for copyright
	document.getElementById("footeryear").innerHTML = new Date().getFullYear();
});

//usersignup page 
function checkFullName() {
	var name = document.getElementById("fullName").value;
	var alphExp = /^[a-zA-Z ]+$/;
	if ((name.length < 4) || (!name.match(alphExp))) {
		document.getElementById("fullname-error").innerText = "Name must have more than 4 chars and not numric value";
	} else {
		document.getElementById("fullname-error").innerText = "";
	}
}
//usersignup page
function checkContactNo() {
	var contactno = document.getElementById("contactNumber").value;
	var contact_regex = /^[0-9]{10}$/
	if (!contactno.match(contact_regex)) {
		document.getElementById("contact-error").innerText = "Contact Number Must be 10 digits";
		//document.getElementsByClassName("").style.color ="red";
	} else {
		document.getElementById("contact-error").innerText = "";
	}
}

//usersignup page
function checkPasswordMatch() {
	var Password = document.getElementById("password").value;
	var RePassword = document.getElementById("RePassword").value;
	//var alphExp = /^[0-9]+$/;
	if (Password != RePassword) {
		document.getElementById("repassword-error").innerText = "Password not matched";
	} else {
		document.getElementById("repassword-error").innerText = "";
	}
}



// cart functionality using pure javascript
function add_to_cart(pid, pname, ptypeofselll, pmanufacturer, price) {

	let cart = localStorage.getItem("cart");
	if (cart == null) {
		// no cart yet
		let products = []
		let product = {
			productId: pid,
			productName: pname,
			productTypeOfSell: ptypeofselll,
			productManufacturer: pmanufacturer,
			productQuantity: 1,
			productPrice: price
		}
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("product is added for the first time")
	} else {
		// cart already present
		let pcart = JSON.parse(cart)
		let oldproduct = pcart.find((item) => item.productId == pid)
		if (oldproduct) {
			// we have to increase the quantity
			oldproduct.productQuantity = oldproduct.productQuantity + 1;
			pcart.map((item) => {
				if (item.productId == oldproduct.productId) {
					item.productQuantity = oldproduct.productQuantity;
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product quantity is updated")
		} else {
			// we have to add the product
			let product = {
				productId: pid,
				productName: pname,
				productTypeOfSell: ptypeofselll,
				productManufacturer: pmanufacturer,
				productQuantity: 1,
				productPrice: price
			}
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart))
			console.log("product is added ")
		}
	}

	// update cart
	updateCart();
	location.reload();
}

let total = {
	price: 0
}
window.onload = function updateCart() {
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if (cart == null || cart.length == 0) {
		console.log("cart is empty");
		$("#cart-items").html("0");
		$("#cart-item").css("display", "none");

		$("#mobile-cart-items").html("0");

	} else {
		// there is something in cart
		$("#cart-items").html(`${cart.length}`);
		$("#mobile-cart-items").html(`${cart.length}`);
		$("#your-cart").html(`${cart.length}`);
		$("#empty-cart").css("display", "none");


		//console.log(cartString);

		let parentDiv = document.getElementById("cart-item")
		let totalPrice = 0;
		// create a separate div for all items
		cart.map((item) => {
			productPrice = parseFloat(item.productPrice);
			totalPrice += productPrice;
			let itemdiv =
				`
				<div class="item-info">
					<div class="medicine-image">
						<img src="image/medicine.png" width="80%" />
					</div>
					<div class="medicine-details">
						<input type="hidden" class="mid" value="${item.productId}">
						<a href="/product?mid=${item.productId}"><span id="product-name">${item.productName}</span></a>
						<br>
						<span id="product-details">${item.productTypeOfSell}</span>
						<br>
						<span id="product-details">Manufacturer: ${item.productManufacturer}</span>
						<br>
						<span class="font-style">
							Price/Unit: &#x20b9; <span id="item1price">${item.productPrice}</span>
						</span>
					</div>
					<div class="medicine-right">
						<span class="font-style">
							Enter Quantity: <input type="number" name="" id="${item.productId}" value="1" min="1" max="5"
								onchange="updateItemPrice(this.id,${item.productPrice})">
						</span>
						<br>
						<span class="font-style">Total Price: &#x20b9;
							<span id="item${item.productId}">${item.productPrice}</span> </span>

						<button class="delete-item" onclick="deleteItemFromCart(${item.productId})">Delete</button>
					</div>
				</div>
				`;


			parentDiv.innerHTML += itemdiv;

		})


		total.price = totalPrice
		document.getElementById("total").innerHTML = "&#x20b9; " + totalPrice.toFixed(2);

		let discount;
		let delivery_cost;
		if (total.price > 500) {
			discount = total.price * 0.05;
			delivery_cost = 0;
		} else {
			discount = 0;
			delivery_cost = total.price * 0.05;
		}
		document.getElementById("delivery-fee").innerHTML = delivery_cost.toFixed(2);
		document.getElementById("discount").innerHTML = discount.toFixed(2);
		document.getElementById("grandTotal").innerHTML = (total.price + delivery_cost - discount).toFixed(2);
	}
}

// updating total price on change of quantity
function updateItemPrice(pid, price) {
	let itemId = "item" + pid;
	pid = String(pid)
	let old_price = document.getElementById(itemId).innerHTML;
	let itemQty = parseInt(document.getElementById(pid).value);
	let item_totalprice = price * itemQty;
	document.getElementById(itemId).innerHTML = item_totalprice.toFixed(2);
	let new_price = document.getElementById(itemId).innerHTML;

	total.price = (total.price + (new_price - old_price));

	document.getElementById("total").innerHTML = "&#x20b9; " + total.price.toFixed(2);
	let discount;
	let delivery_cost;
	if (total.price > 500) {
		discount = total.price * 0.05;
		delivery_cost = 0;
	} else {
		discount = 0;
		delivery_cost = total.price * 0.05;
	}
	document.getElementById("delivery-fee").innerHTML = delivery_cost.toFixed(2);
	document.getElementById("discount").innerHTML = discount.toFixed(2);
	document.getElementById("grandTotal").innerHTML = (total.price + delivery_cost - discount).toFixed(2);
}

function deleteItemFromCart(pid) {
	let cart = JSON.parse(localStorage.getItem("cart"));
	let newcart = cart.filter((item) => item.productId != pid);
	localStorage.setItem("cart", JSON.stringify(newcart));

	location.reload();
	updateCart();
}