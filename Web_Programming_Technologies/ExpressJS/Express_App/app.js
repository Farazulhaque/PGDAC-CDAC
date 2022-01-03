var express = require("express");
var bodyParser = require("body-parser");

//importing circle module
var circle = require("./shapes/circle")


var app = express()

//app.use() is used to add middleware
app.use(express.static("public")) //from here we are serving all static files
//parsing request body before handling
app.use(bodyParser.urlencoded({extended:true})) //Using bodyparser middleware
app.use(bodyParser.json()) //parsing the json



app.get("/",function(req,res){
    res.send("Hi")
    
})

app.post("/calccirc",function(req,res){
    var data = req.body //get POST data from req.body in object format
    console.log(data)
    switch(data.choice){
        case "area" : var result = circle.circleArea(parseInt(data.radius))
                     res.send("Area is : "+result)
                break;
        case "circumference": var result = circle.circleCircumference(parseInt(data.radius))
                                res.send("Circumference is : "+result)
                                break;
        default : res.send("Wrong choice")
    }
  
})


app.listen(8000,function(){
    console.log("Server running at 8000")
})