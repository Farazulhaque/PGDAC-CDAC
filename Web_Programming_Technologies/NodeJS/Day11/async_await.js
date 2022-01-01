//Normal function syntax
async function add(a, b) {
    return a + b;
}



// add(10,30)
// 	.then(function(data){console.log(data + 100)})
// 	.catch(function(err){console.log(err)})
//     //.finally(function(){})it always executes

async function calc() {
    var x = await add(10, 30)
    console.log(x)
}

calc()