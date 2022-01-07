var express = require("express");
var bodyParser = require("body-parser");
var app = express();
var fruitRouter = require('./router/fruit')
require("./db/db") //connecting to database



app.use(express.static("public"));
app.use(bodyParser.urlencoded({extended : true}));
app.use(bodyParser.json())

// app.get("/",(req,res) =>{
// 	res.send("Its working")
// })

app.use('/',fruitRouter)


app.listen(8000,()=>{
	console.log("Server running at 8000")
})

