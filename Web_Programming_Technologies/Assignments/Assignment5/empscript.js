var empdetails = []

function display() {
    // alert("hello")
    console.log("hello");
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    if (id == "" || name == "" || email == "" || phone == "") {
        alert("Please fill all the fields then click display.")
    } else {

        var gender = document.getElementsByClassName("gender");
        for (var i = 0; i < gender.length; i++) {
            if (gender[i].checked) {
                gender = gender[i].value;
            }
        }
        var city = document.getElementById("city").value;
        // console.log(city);
        var date = new Date(document.getElementById("dob").value);
        if (date == "Invalid Date") {
            var dob = "NA";
        } else {
            var dob = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
        }

        var data = {
            id: id,
            name: name,
            email: email,
            phone: phone,
            gender: gender,
            city: city,
            dob: dob,
        }
        empdetails.push(data)
        var tab = "<table>";
        tab +=
            "<tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>PHONE</th><th>GENDER</th><th>CITY</th><th>DATE OF BIRTH</th></tr>";
        for (var i = 0; i < empdetails.length; i++) {
            tab += "<tr><td>" + empdetails[i].id + "</td><td>" + empdetails[i].name + "</td><td>" +
                empdetails[i].email + "</td><td>" + empdetails[i].phone + "</td><td>" +
                empdetails[i].gender + "</td><td>" + empdetails[i].city + "</td><td>" +
                empdetails[i].dob + "</td></tr>";
        }
        tab += "</table>";
        document.getElementById("emptable").innerHTML = tab;

    }
    return false;
}

function validateID() {
    var id = document.getElementById("id").value;
    if (id == "") {
        document.getElementById("idmsg").innerHTML = "ID must not be empty";
        document.getElementById("id").focus();
        document.getElementById("id").style.borderBottom = "2px solid red";
    } else {
        document.getElementById("id").style.borderBottom = "2px solid green";
    }
}

function validateName() {
    var name = document.getElementById("name").value;
    if (name == "") {
        document.getElementById("namemsg").innerHTML = "Name must not be empty";
        document.getElementById("name").focus();
        document.getElementById("name").style.borderBottom = "2px solid red";
    } else if (name.length < 4) {
        document.getElementById("namemsg").innerHTML = "Name must be atleast 4 chars";
        document.getElementById("name").focus();
        document.getElementById("name").style.borderBottom = "2px solid red";
    } else {
        document.getElementById("name").style.borderBottom = "2px solid green";
    }
}

function validateEmail() {
    var email = document.getElementById("email").value;
    if (email == "") {
        document.getElementById("emailmsg").innerHTML = "Email must not be empty";
        document.getElementById("email").focus();
        document.getElementById("email").style.borderBottom = "2px solid red";
    } else {
        document.getElementById("email").style.borderBottom = "2px solid green";
    }
}

function validatePhone() {
    var phone = document.getElementById("phone").value;
    if (phone == "") {
        document.getElementById("phonemsg").innerHTML = "Phone must not be empty";
        document.getElementById("phone").focus();
        document.getElementById("phone").style.borderBottom = "2px solid red";
    } else if (phone.length < 10) {
        document.getElementById("phonemsg").innerHTML = "Phone must have 10 chars";
        document.getElementById("phone").focus();
        document.getElementById("phone").style.borderBottom = "2px solid red";
    } else {
        document.getElementById("phone").style.borderBottom = "2px solid green";
    }
}

function clr() {
    // alert("hello");
    document.getElementById("idmsg").innerHTML = "";
    document.getElementById("namemsg").innerHTML = "";
    document.getElementById("emailmsg").innerHTML = "";
    document.getElementById("phonemsg").innerHTML = "";
}

// function init() {
//     document.getElementById("id").focus();
// }