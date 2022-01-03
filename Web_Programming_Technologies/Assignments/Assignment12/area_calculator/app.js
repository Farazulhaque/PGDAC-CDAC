var express = require("express")
var bodyParser = require("body-parser"); // parse the request
var app = express()

var circle = require("./shapes/circle")
var triangle = require("./shapes/triangle")
var rectangle = require("./shapes/rectangle")


app.use(express.static("public"))
//Parse the request using body-parser middleware
app.use(bodyParser.urlencoded({
    extended: true
})) // parse the urlencoded format
app.use(bodyParser.json()) //parse the json data

app.post("/circle", function (req, res) {
    var data = req.body
    console.log(data)
    switch (data.choice) {
        case "area":
            var result = circle.area(parseInt(data.radius))
            res.send("Area is  : " + result)
            break;
        case "perimeter":
            var result = circle.perimeter(parseInt(data.radius))
            res.send("Circumference is :" + result)
            break;
        default:
            res.send("Wrong choice")
            break;
    }
})

app.post("/rectangle", function (req, res) {
    var data = req.body
    console.log(data)
    switch (data.choice) {
        case "area":
            var result = rectangle.area(parseInt(data.length), parseInt(data.breadth))
            res.send("Area is  : " + result)
            break;
        case "perimeter":
            var result = rectangle.perimeter(parseInt(data.length), parseInt(data.breadth))
            res.send("Perimeter is :" + result)
            break;
        default:
            res.send("Wrong choice")
            break;
    }
})

app.post("/triangle", function (req, res) {
    var data = req.body
    console.log(data)
    switch (data.choice) {
        case "area":
            var result = triangle.isEquilateral(parseInt(data.side1), parseInt(data.side2), parseInt(data.side3))
            res.send("Is Equilateral?  : " + result)
            break;
        case "perimeter":
            var result = triangle.perimeter(parseInt(data.side1), parseInt(data.side2), parseInt(data.side3))
            res.send("Perimeter is :" + result)
            break;
        default:
            res.send("Wrong choice")
            break;
    }
})

app.listen(8000, function () {
    console.log("Server running at 8000")
})