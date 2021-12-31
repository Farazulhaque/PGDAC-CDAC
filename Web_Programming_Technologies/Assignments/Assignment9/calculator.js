var calc = require("./calc_module")
var readline = require("readline")
var inp = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})


inp.question("Enter First Number: ", function (num1) {
    inp.question("Enter Second Number: ", function (num2) {
        inp.question("Enter 1 to add, 2 to sub: ", function (choice) {
            switch (choice) {
                case "1":
                    var result = calc.add(parseInt(num1), parseInt(num2))
                    console.log(result)
                    break;
                case "2":
                    var result = calc.sub(parseInt(num1), parseInt(num2))
                    console.log(result)
                    break;
                default:
                    console.log("Wrong choice")
            }
            inp.close()
        })
    })
})