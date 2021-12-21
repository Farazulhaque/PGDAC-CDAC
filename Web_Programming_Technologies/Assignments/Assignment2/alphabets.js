// 2. Write a code to iterate through the given string and store the alphabet and count(occurance) in object
// -{A:2,a:1, s:10, d:20 ,f:30}
// "A computer is a machine that can be programmed to carry out sequences of arithmetic or logical operations automatically. 
// Modern computers can perform generic sets of operations known as programs. 
// These programs enable computers to perform a wide range of tasks. 
// A computer system is a complete computer that includes the hardware operating system 
// main software  and peripheral equipment needed and used for full operation. 
// This term may also refer to a group of computers that are linked and function together"

var occurences = {}
var str = "A computer is a machine that can be programmed to carry out sequences\
 of arithmetic or logical operations automatically. Modern computers can perform \
 generic sets of operations known as programs. These programs enable computers to \
 perform a wide range of tasks. A computer system is a complete computer that includes \
 the hardware operating system main software  and peripheral equipment needed and used  \
 for full operation. This term may also refer to a group of computers that are linked and \
 function together"

console.log(str);

for (var i = 0; i < str.length; i++) {
    if ((str[i].charCodeAt(0) >= 65 && str[i].charCodeAt(0) <= 90) || (str[i].charCodeAt(0) >= 97 && str[i].charCodeAt(0) <= 122)) {
        if (occurences[str[i]] == undefined)
            occurences[str[i]] = 1;
        else
            occurences[str[i]] += 1;

    }
}
alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
for (var i = 0; i < alphabets.length; i++) {
    if (occurences[alphabets[i]] != undefined)
        document.write(alphabets[i] + " :" + occurences[alphabets[i]] + "<br>");
}