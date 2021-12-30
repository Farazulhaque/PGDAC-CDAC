var fs = require("fs")

//For async file reading use fs.readFile()
fs.readFile("demo.txt", function (err, data) { // here order of argument is fixed
    //callback function will be called after reading data from file
    console.log(data.toString())
})

console.log("Hi")