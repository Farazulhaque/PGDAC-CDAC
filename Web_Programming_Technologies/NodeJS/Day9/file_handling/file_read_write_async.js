var fs = require("fs")

var str = "This is data"
fs.writeFile("demo.txt", str, function () {
    console.log("success")
    // var x = fs.readFileSync("demo.txt")
    // console.log(x.toString())
    fs.readFile("demo.txt", function (err, data) {
        if (err) {
            console.log(err)
        } else {
            console.log(data.toString())
        }
    })
})

console.log("Hi")



// fs.readFile("demo.txt",function(err,data){
//     if(err){
//         console.log(err)
//     }else{
//         console.log(data.toString())
//     }
// })

//console.log("Hi")