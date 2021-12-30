var http = require("http")
var fs = require("fs")

var server = http.createServer(function (req, res) {
    fs.readFile("./client/forms_dom.html", function (err, data) {
        if (!err) {
            res.write(data.toString())
            res.end()
        } else {
            res.write("File not found")
            res.end()
        }

    })
})

server.listen(8001, function () {
    console.log("Server running at 8000")
})