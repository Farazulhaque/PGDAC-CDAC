$(document).ready(function() {
	//for nav on mobile view
	var fixHeight = function() {
		$('.navbar-nav').css(
			'max-height',
			document.documentElement.clientHeight - 150
		);
	};
	fixHeight();

	$(window).resize(function() {
		fixHeight();
	});

	$('.navbar .navbar-toggler').on('click', function() {
		fixHeight();
	});


	$('.navbar-toggler,.overlay,.btnclsnav').on('click', function() {
		$('.mobileMenu,.overlay,.btnclsnav').toggleClass('open');
	});

	//for banner portion
	$('.carousel').carousel({
		interval: 3000,
		keyboard: true,
		pause: 'hover',
		wrap: true
	});

	$('#slider4').on('slide.bs.carousel', function() {
		console.log('SLIDE!');
	});

	$('#slider4').on('slid.bs.carousel', function() {
		console.log('SLID!');
	});

	//current year for copyright
	document.getElementById("footeryear").innerHTML = new Date().getFullYear();
});

function checkFullName() {
	var name = document.getElementById("FullName").value;
	var alphExp = /^[a-zA-Z]+$/;
	if ((name.length < 8) && (name.match(alphExp))) {
		document.getElementById("fullname-error").innerText = "Name must have more than 4 chars and not numric value";
	} else {
		document.getElementById("fullname-error").innerText = "";
	}
}

function checkContactNo() {
	var contactno = document.getElementById("ContactNumber").value
	var contact_regex = /^[0-9]{10}$/
	if (!contactno.match(contact_regex)) {
		document.getElementById("contact-error").innerText = "Contact Number must be of 10 digits number";
	} else {
		document.getElementById("contact-error").innerText = "";
	}
}


const search = () => {
	// console.log("searching...");
	let query = $("#search-input").val();

	if (query == '') {
		$(".search-result").hide();
	} else {
		console.log(query);
		//var opt = {
		//	url: "http://localhost:8282/processAJAX?query=" + query,
		//	method: "GET"
		//}
		//var ajax = new XMLHttpRequest();
		//$.ajax(opt).done(function(data) {
		//	for (var i = 0; i < data.length; i++) {
		//		document.getElementById("search-item").innerHTML += data[i].medicineName + "<br>";
		//	}
		//})
		// var ajax = new XMLHttpRequest();
		// var url = "/processAJAX?query=" + query;
		// ajax.onreadystatechange = function() {
		// 	if (ajax.readyState == 4) {
		// 		alert(ajax.responseText);
		// 		document.getElementById("search-item").innerHTML = ajax.responseText + "<br>";
		// 	}
		// };
		// ajax.open("GET", url, true);
		// ajax.send(null);

		var request = new XMLHttpRequest();
		request.open("GET", "http://localhost:8282/processAJAX?query=" + query);
		request.onreadystatechange = function() {
        // Check if the request is compete and was successful
        if(this.readyState === 4 && this.status === 200) {
            // Inserting the response from server into an HTML element
            document.getElementById("search-item").innerHTML += this.responseText;
        }
    };
		
		request.send();
		console.log()
		$(".search-result").show()

	}
};