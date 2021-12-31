var http = require("http")
var fs = require("fs")

var server = http.createServer(function (req, res) {
    if (req.url == "/") {
        fs.readFile("./client/calc.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    if (req.url == "/data") {
        res.write("This is data endpoint")
        res.end()
    }
    if (req.url == "/xyz") {
        res.write("This is xyz endpoint")
        res.end()
    }
})

server.listen(8000, function () {
    console.log("Server runnning at 8000")
})