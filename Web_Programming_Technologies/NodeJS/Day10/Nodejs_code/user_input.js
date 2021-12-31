var readline = require('readline') // module for taking input from user

//configure readline
//Connect it to Standard input and output
var inp = readline.createInterface({
    input: process.stdin, // Interfacing input here
    output: process.stdout //Interfacing output here
})

//question is asynchronous function
inp.question("Enter name: ", function (data) {
    console.log("Hi " + data);
    inp.close() // here close the input and output
})