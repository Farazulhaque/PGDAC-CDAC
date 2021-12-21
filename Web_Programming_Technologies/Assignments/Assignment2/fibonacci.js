// 2.Write a code to print fibonnaci series( 1,1,2,3,5,8,13,21...) till 100.
function print_fibonacci_series() {
    var a = 1;
    var b = 1;
    while (a <= 100) {
        document.write(a + " ");
        var temp = a;
        a = b;
        b = temp + a;
    }
}

print_fibonacci_series()