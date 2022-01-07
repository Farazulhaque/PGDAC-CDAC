var mongoose = require("mongoose")

var FruitSchema = new  mongoose.Schema({
	fruitName : String,
	rate : Number,
	stock : Number
})

exports.fruitModel = mongoose.model('fruit',FruitSchema);