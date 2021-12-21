// 1.Write a program to print even number from 1 to 20
function print_even() {
    for (var i = 1; i < 20; i++) {
        if (i % 2 == 0)
            document.write(i + "<br>");
    }
}

print_even()