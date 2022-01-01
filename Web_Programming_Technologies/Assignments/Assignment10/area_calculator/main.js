var circle = require("./circle")
var triangle = require("./triangle")
var rectangle = require("./rectangle")
var http = require("http")
var fs = require("fs")

var server = http.createServer(function (req, res) {
    if (req.url == "/") {
        res.write("Try /circle or /triangle or /rectangle")
        res.end()
    }
    if (req.url == "/circle") {
        fs.readFile("./client/circle.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    if (req.url == "/triangle") {
        fs.readFile("./client/triangle.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    if (req.url == "/rectangle") {
        fs.readFile("./client/rectangle.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    if (req.url.startsWith("/circlearea")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var area = circle.area(parseInt(data.get("radius")))
        res.write("Area is " + area)
        res.end()
    }
    if (req.url.startsWith("/circleperimeter")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var perimeter = circle.perimeter(parseInt(data.get("radius")))
        res.write("Perimeter is " + perimeter)
        res.end()
    }
    if (req.url.startsWith("/circlediameter")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var diameter = circle.diameter(parseInt(data.get("radius")))
        res.write("Diameter is " + diameter)
        res.end()
    }
    if (req.url.startsWith("/triangleperimeter")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var perimeter = triangle.perimeter(parseInt(data.get("side1")), parseInt(data.get("side2")), parseInt(data.get("side3")))
        res.write("Perimeter is " + perimeter)
        res.end()
    }

    if (req.url.startsWith("/triangleisequilteral")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var iseq = triangle.isEquilateral(parseInt(data.get("side1")), parseInt(data.get("side2")), parseInt(data.get("side3")))
        res.write("Is Equilateral?: " + iseq)
        res.end()
    }


    if (req.url.startsWith("/rectanglearea")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var area = rectangle.area(parseInt(data.get("length")), parseInt(data.get("breadth")))
        res.write("Area is: " + area)
        res.end()
    }

    if (req.url.startsWith("/rectangleperimeter")) {
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        var data = new URLSearchParams(qs)

        var perimeter = rectangle.perimeter(parseInt(data.get("length")), parseInt(data.get("breadth")))
        res.write("Perimeter is: " + perimeter)
        res.end()
    }
})

server.listen(8000, function () {
    console.log("Server runnning at 8000")
})