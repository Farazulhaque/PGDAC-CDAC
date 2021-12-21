// 1. Write a code to create a Object from given number range
// -If the input is 4 then the keys in object are 1,2,3,4
// -And value is square of the key
// {1:1, 2:4, 3:9 ,4:16, 5:25}

var obj = {};
var n = parseInt(prompt("Enter range"));
for (var i = 1; i <= n; i++) {
    obj[i] = i * i;
}

for (var i = 1; i <= n; i++) {
    document.write(i + " " + obj[i] + "<br>");
}