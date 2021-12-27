var emps = [];

$(document).ready(function () {

    //registering a function on blur event on id=id
    $("#id").blur(function () {
        var id = $("#id").val()
        if (isNaN(id)) { // if input is not number show error
            $("#id_err").text("ID must be number")
        }
    })

    //registering a function on focus event on id=id
    $("#id").focus(function () {
        $("#id_err").text("") // here resetting error by empty string
    })





    //Registering a function on submit event here
    $("#form").submit(function (event) {
        event.preventDefault() // Stop the form default operation(that is to submit data to server)
        //var id = document.getElementById("id").value;
        var id = $("#id").val()
        //var n = document.getElementById("name").value;
        var n = $("#name").val()
        //var e = document.getElementById("email").value;
        var e = $("#email").val()

        var g = $(".gender:checked").val() // Here :checked will only fetch the value of selected radio button
        // var gender_dom_arr = document.getElementsByClassName("gender");
        // if(gender_dom_arr[0].checked){
        //     g = gender_dom_arr[0].value
        // }
        // if(gender_dom_arr[1].checked){
        //     g = gender_dom_arr[1].value
        // }
        // if(gender_dom_arr[2].checked){
        //     g = gender_dom_arr[2].value
        // }

        //  var dept = document.getElementById("dept").value;
        var dept = $("#dept").val()

        emps.push({
            id: id,
            name: n,
            email: e,
            gender: g,
            dept: dept
        })
        console.log(emps)

    })
})