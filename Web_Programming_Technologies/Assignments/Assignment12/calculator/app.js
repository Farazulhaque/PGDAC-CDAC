var express = require("express")
var bodyParser = require("body-parser"); // parse the request
var app = express()


app.use(express.static("public"))
//Parse the request using body-parser middleware
app.use(bodyParser.urlencoded({
    extended: true
})) // parse the urlencoded format
app.use(bodyParser.json()) //parse the json data

app.post("/calculate", function (req, res) {
    var data = req.body
    var num1 = parseInt(data.num1)
    var num2 = parseInt(data.num2)
    switch (data.operation) {
        case "add":
            var result = num1 + num2
            res.send("Result is  : " + result)
            break;
        case "sub":
            var result = num1 - num2
            res.send("Result is  : " + result)
            break;
        case "mul":
            var result = num1 * num2
            res.send("Result is  : " + result)
            break;
        case "div":
            var result = num1 / num2
            res.send("Result is  : " + result)
            break;

        default:
            res.send("Wrong choice")
            break;
    }
})


app.listen(8000, function () {
    console.log("Server runnning at 8000")
})