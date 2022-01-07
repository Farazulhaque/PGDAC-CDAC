var mongoose = require("mongoose");
mongoose
	.connect("mongodb://localhost:27017/fruitshop",{useNewUrlParser : true ,useUnifiedTopology:true})
	.then(() => {console.log("Database Connected")})
	.catch((err) => {console.log("Error: " + err)})
