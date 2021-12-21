// 4. Write a code to take string input from user and remove duplicate words.
function remove_duplicates(str) {
    var originalArr = str.split(" ");
    var uniqueArr = [];

    for (var i = 0; i < originalArr.length; i++) {
        if (uniqueArr.indexOf(originalArr[i]) == -1) {
            uniqueArr.push(originalArr[i]);
        }
    }
    document.write(uniqueArr.join(" "));
}

var str = prompt("Enter a senetence");
remove_duplicates(str);