// 1. Write code to create fruit shop page.
// ->Add fruits(Fields: id,name,rate)
// ->Display fruits in table

var fruit_details = []

function add_fruits() {
    for (var i = 0; i < 3; i++) {
        var fruit_id = prompt("Enter Fruit ID");
        var fruit_name = prompt("Enter Fruit Name");
        var fruit_rate = prompt("Enter Fruit Rate");
        var obj = {
            id: fruit_id,
            name: fruit_name,
            rate: fruit_rate
        }
        fruit_details.push(obj)
    }
}

add_fruits();
console.log(fruit_details);

function display() {
    var str = "<table border = 1>"
    str += "<tr><th>ID</th><th>NAME</th><th>RATE</th></tr>";
    for (var i = 0; i < fruit_details.length; i++) {
        str += "<tr><td>" + fruit_details[i].id + "</td><td>" + fruit_details[i].name + "</td><td>" +
            fruit_details[i].rate + "</td></tr>"
    }
    str += "</table>"
    document.write(str);
}
display()