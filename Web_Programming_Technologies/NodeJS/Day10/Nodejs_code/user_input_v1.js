var readline = require('readline') // module for taking input from user

//configure readline
//Connect it to Standard input and output
var inp = readline.createInterface({
    input: process.stdin, // Interfacing input here
    output: process.stdout //Interfacing output here
})

//question is asynchronous function
inp.question("Enter name: ", function (name) { //input is always string
    inp.question("Enter phone: ", function (phone) {
        console.log("Phone : " + phone)
        console.log("Name : " + name)
        inp.close()
    })
})

// inp.question("Enter phone: ",function(data){ // this will not take input
//     console.log("Phone " + data);
//     inp.close() // here close the input and output
// })