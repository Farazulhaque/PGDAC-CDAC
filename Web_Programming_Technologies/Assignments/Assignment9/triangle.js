exports.isEquilateral = function (s1, s2, s3) {
    if (s1 == s2 && s2 == s3) {
        console.log("Is Equilateral Triangle")
    } else {
        console.log("Is Not Equilateral Triangle")
    }
}

exports.calcPerimeter = function (s1, s2, s3) {
    var perimeter = s1 + s2 + s3
    console.log("Perimeter of triangle is: " + perimeter)
}