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
    if (req.url.startsWith("/calculate?")) {
        //req.url /calculate?num1=10&num2=20
        var url_arr = req.url.split("?") //["/calculate","num1=10&num2=20"]
        var qs = url_arr[1] //qs = num1=10&num2=20
        var data = new URLSearchParams(qs) // parses the querystring then use .get function to get data
        var result = ""
        switch (data.get("operation")) {
            case "add":
                result = parseInt(data.get("num1")) + parseInt(data.get("num2"))
                break;
            case "sub":
                result = parseInt(data.get("num1")) - parseInt(data.get("num2"))
                break;
        }

        res.write("Result is" + result)
        res.end()
    }

})

server.listen(8000, function () {
    console.log("Server runnning at 8000")
})