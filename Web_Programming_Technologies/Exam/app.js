var express = require("express")
var bodyParser = require("body-parser")

var app = express()


app.use(express.static("public"))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())



app.get("/", function (req, res) {
    res.send("hello")
})

app.post("/register", function (req, res) {
    var data = req.body
    var name = data.name;
    var password = data.pwd;
    var email = data.email;
    var gender = data.gender;
    res.send("Data saved")
    console.log(name, password, email, gender)
})


app.listen(8000, function () {
    console.log("Server running at http://localhost:8000")
})