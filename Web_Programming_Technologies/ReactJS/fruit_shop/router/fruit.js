var express = require("express")
var router = express.Router()
var fruits = require('../Model/Fruit')

router.post("/addFruit",(req,res) =>{
	var fruit = new fruits.fruitModel(req.body);
	fruit.save()
		.then(() => res.status(200).send({msg : "Fruit Saved"}))
		.catch((err) => res.status(503).send({msg : "Some error occured"}))
})


router.post("/fetchFruit",(req,res)=>{
	fruits.fruitModel.find({})
					.then((data) => res.status(200).send(data))
					.catch((err) => res.status(500).send({msg : "Some error occured"}))
})

module.exports = router