var calc = require("./calc_module")
var readline = require("readline")

var inp = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

inp.question("Enter first number ", function (firstNumber) {
    inp.question("Enter second number", function (secondNumber) {
        inp.question("Enter 1 for add and 2 for sub", function (choice) {
            switch (choice) {
                case "1":
                    var result = calc.add(parseInt(firstNumber), parseInt(secondNumber))
                    console.log(result)
                    break;
                case "2":
                    var result = calc.sub(parseInt(firstNumber), parseInt(secondNumber))
                    console.log(result)
                    break;
                default:
                    console.log("Wrong choice")
            }
            inp.close()
        })
    })
})