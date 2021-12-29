// generate fibonacci series
function fibonacci(num) {
    var num1 = 1;
    var num2 = 1;
    var num3;

    console.log(num1);
    console.log(num2);
    for (var i = 2; i < num; i++) {
        num3 = num1 + num2;
        num1 = num2;
        num2 = num3;

        console.log(num3);
    }
}

fibonacci(10)