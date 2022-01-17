var express = require("express")
var bodyParser = require("body-parser")

var app = express()


app.use(express.static("public"))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())



app.get("/", function (req, res) {
    res.send("hello")
})

app.get("/register", function (req, res) {
    res.send("Data saved")
})


app.listen(8000, function () {
    console.log("Server running at http://localhost:8000")
})