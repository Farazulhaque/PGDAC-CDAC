// 3.Write a code to check the given string is palindrome or not. (abba)
function check_palindrome(str) {
    var newstr = str.split('');
    newstr = newstr.reverse();
    revstr = newstr.join('');
    if (str == revstr) {
        document.write("It is a palindrome");
    } else {
        document.write("It is not a palindrome");
    }
}

check_palindrome("abba")