//Normal function syntax
async function add(a, b) {
	return a + b;
}

//For anonymous function
// var add = async function(a,b){
// 	return a + b
// }

//For arrow function
// var add = async (a,b) =>{
// 	return a + b
// }


// var x = add(10,30);
// console.log(x)
// x.then(function(data){	console.log(data + 100)})
//  .catch(function(err){console.log(err)})
add(10, 30)
	.then(function (data) {
		console.log(data + 100)
	})
	.catch(function (err) {
		console.log(err)
	})