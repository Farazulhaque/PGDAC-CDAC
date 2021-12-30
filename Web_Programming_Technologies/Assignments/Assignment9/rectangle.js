exports.calcArea = function (l, b) {
    var area = l * b;
    console.log("Area of rectangle having length " + l + " and breadth " + b + " is: " + area)
}

exports.calcPerimeter = function (l, b) {
    var perimeter = 2 * (l + b)
    console.log("Perimeter of rectangle having length " + l + " and breadth " + b + " is: " + perimeter)
}