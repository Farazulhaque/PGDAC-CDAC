var http = require("http")

//here we are creating server object
var server = http.createServer(function (req, res) { //the order of argument is fixed
    //this will execute for every request
    //request handler
    console.log("Hi");
    res.write("Hi Sid") //here writing in response object
    res.end() //here close the response
})

server.listen(8000, function () { // starting the server
    //this callback will execute after launch of server
    console.log("Server running at 8000")
})