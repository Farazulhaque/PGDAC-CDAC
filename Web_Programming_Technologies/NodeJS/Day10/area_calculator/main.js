var circle = require("./circle")
var traingle = require("./traingle")
var http = require("http")
var fs = require("fs")

var server = http.createServer(function (req, res) {
    if (req.url == "/") {
        res.write("Try /circle or /traingle")
        res.end()
    }
    if (req.url == "/circle") {
        fs.readFile("./client/circle.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    if (req.url == "/traingle") {
        fs.readFile("./client/traingle.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    if (req.url.startsWith("/circlearea")) {
        //  var data = new URLSearchParams(req.url.split("?")[1])
        var url_arr = req.url.split("?") //["/calculate","num1=10&num2=20"]
        var qs = url_arr[1] //qs = num1=10&num2=20
        var data = new URLSearchParams(qs) // parses the querystring then use .get function to get data

        var area = circle.area(parseInt(data.get("radius")))
        res.write("Area is " + area)
        res.end()
    }
    if (req.url.startsWith("/traingleperimeter")) {
        //  var data = new URLSearchParams(req.url.split("?")[1])
        var url_arr = req.url.split("?") //["/calculate","num1=10&num2=20"]
        var qs = url_arr[1] //qs = num1=10&num2=20
        var data = new URLSearchParams(qs) // parses the querystring then use .get function to get data

        var perimeter = traingle.perimeter(parseInt(data.get("side1")), parseInt(data.get("side2")), parseInt(data.get("side3")))
        res.write("Perimeter is " + perimeter)
        res.end()
    }

})

server.listen(8000, function () {
    console.log("Server runnning at 8000")
})