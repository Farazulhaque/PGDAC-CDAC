var express = require("express") //importing express module
var app = express() // express function returns object

//it'll server static files (all files for browser CSS,HTML,JS,IMAGE etc...)
app.use(express.static("public"))

app.get("/data", function (req, res) {
    res.send("this is data")
})

//app.request_type(URL,function)
app.get("/", function (req, res) {
    res.send("THis is /")
})


app.get("/xyz", function (req, res) {
    res.send("this is xyz")
})

//app.get()
//app.post()
//app.put()
//starting server at 8000 port
app.listen(8000, function () {
    //this callback function executes after server launch
    console.log("Server is running at 8000")
})