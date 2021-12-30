var fs = require("fs")

var data = "THis is other data"
//fs.writeFileSync() is used to write data synchronously
fs.writeFileSync("demo.txt", data) // pass the data in string format
//fs.writeFileSync() overwites the current file data


//Append data to the file
//use fs.appendFileSync to append into file synchronously
data = "\nTHis is append data"
fs.appendFileSync("demo.txt", data)
//fs.appendFileSync() does not overwites the current file data