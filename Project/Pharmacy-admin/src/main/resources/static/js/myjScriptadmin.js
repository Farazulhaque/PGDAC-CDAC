$(document).ready(function(){
            
  
  
  

  
  // Get the current year for the copyright
  $('#year').text(new Date().getFullYear());
  CKEDITOR.replace('editor1');

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