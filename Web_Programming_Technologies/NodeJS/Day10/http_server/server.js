var http = require("http")

var server = http.createServer(function (req, res) {
    if (req.url == "/") {
        res.write("This is / endpoint")
        res.end()
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