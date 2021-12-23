var emps = [];

//var name = document.getElementById("id").value;


function save_data() {
    var id = document.getElementById("id").value;
    var n = document.getElementById("name").value;
    var e = document.getElementById("email").value;
    var g = ""
    var gender_dom_arr = document.getElementsByClassName("gender");
    if (gender_dom_arr[0].checked) {
        g = gender_dom_arr[0].value
    }
    if (gender_dom_arr[1].checked) {
        g = gender_dom_arr[1].value
    }
    if (gender_dom_arr[2].checked) {
        g = gender_dom_arr[2].value
    }

    var dept = document.getElementById("dept").value;

    emps.push({
        id: id,
        name: n,
        email: e,
        gender: g,
        dept: dept
    })
    console.log(emps)
    return false
}