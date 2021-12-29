// print all prime numbers less than number
function prime(n) {
    for (var j = 1; j <= n; j++) {
        var i, flag = true;

        for (i = 2; i <= j - 1; i++)
            if (j % i == 0) {
                flag = false;
                break;
            }

        if (flag == true)
            console.log(j + " is prime");
        else
            console.log(j + " is not prime");
    }
}

prime(20)