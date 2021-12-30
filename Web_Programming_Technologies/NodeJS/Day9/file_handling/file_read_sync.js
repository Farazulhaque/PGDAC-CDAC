//read the file synchronously
var x = require("fs")

//use fs.readFileSync to read file synchronously
var data = x.readFileSync("demo.txt") //return buffer
console.log(data.toString()) // .toString() will return the string value of buffer