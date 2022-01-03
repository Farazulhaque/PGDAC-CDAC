var express = require("express")
var bodyParser = require("body-parser"); // parse the request
var app = express()

var circle = require("./shapes/circle")

var users = [] //global array to store data

app.use(express.static("public"))
//Parse the request using body-parser middleware
app.use(bodyParser.urlencoded({
    extended: true
})) // parse the urlencoded format
app.use(bodyParser.json()) //parse the json data

app.post("/calccircle", function (req, res) {
    var data = req.body
    console.log(data)
    switch (data.choice) {
        case "area":
            var result = circle.circleArea(parseInt(data.radius))
            res.send("Area is  : " + result)
            break;
        case "circumference":
            var result = circle.circleCircumference(parseInt(data.radius))
            res.send("Circumference is :" + result)
            break;
        default:
            res.send("Wrong choice")
            break;
    }
})

app.get("/traingleperimeter", function (req, res) {
    var data = req.query;
    console.log(data)
    var result = parseInt(data.side1) + parseInt(data.side2) + parseInt(data.side3);
    res.send("Perimeter is " + result)
})

app.post("/registeruser", function (req, res) {
    var data = req.body;
    users.push(data)
    console.log(users)
    //res.send("Working on it");
    res.redirect("/register.html") // redirect response to given url
})

app.post("/users", function (req, res) { //http://localhost:8000/users
    res.send(users) // automatically converts objects or array to JSON
})


app.listen(8000, function () {
    console.log("Server running at 8000")
})