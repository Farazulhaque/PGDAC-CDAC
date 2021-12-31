var http = require("http")
var fs = require("fs")

var server = http.createServer(function (req, res) {
    if (req.url == "/") {
        // to open main html page
        fs.readFile("./client/calculator.html", function (err, data) {
            res.write(data.toString())
            res.end()
        })
    }
    // because the output of calculator.html is redirected to /calculate (action="/calculate")
    if (req.url.startsWith("/calculate?")) {
        // req.url /calculate?num1=20&num2=10
        var url_arr = req.url.split("?")
        var qs = url_arr[1]
        // console.log(qs)
        var data = new URLSearchParams(qs)
        var result = ""
        var num1 = parseFloat(data.get("num1")); // num1 is value of name attribute of number 1 input in html form
        var num2 = parseFloat(data.get("num2")); // num2 is value of name attribute of number 2 input in html form
        switch (data.get("operation")) { // operation is value of name attribute of radio buttons
            case "add":
                result = num1 + num2
                break;
            case "sub":
                result = num1 - num2
                break;
            case "mul":
                result = num1 * num2
                break;
            case "div":
                result = num1 / num2
                break;
        }

        res.write("<h1>Result:  " + result + "</h1>")
        res.end()
    }

})

server.listen(8000, function () {
    console.log("Server runnning at 8000")
})