// Create a Fruit shop billing application
// ->Add fruit (id,name ,rate)
// ->Display fruit
// Add fruit option will take data from prompt
// User can enter fruit name and quantity in input boxes. If fruit is in list find the rate and print the total price on screen.

fruit_details = []
var add_fruit = function () {
    var id = prompt("Enter ID");
    var name = prompt("Enter Name")
    var rate = prompt("Enter Rate")

    fruit_details.push({
        id: id,
        name: name,
        rate: rate
    })
    alert("Fruit Added Successfully!!");

}

function display_fruit() {
    var name = prompt("Enter fruit name");
    var qty = prompt("Enter quantity")

    var found = false;
    for (var i = 0; i < fruit_details.length; i++) {
        if (fruit_details[i].name == name) {
            found = true;
            document.write("Fruit Name: " + name + "<br>");
            document.write("Fruit Price: " + fruit_details[i].rate + "<br>");
            document.write("Total Price: " + (parseFloat(fruit_details[i].rate) * qty));
        }
    }
    if (found == false) {
        alert("Fruit not found!!!!");
    }
}