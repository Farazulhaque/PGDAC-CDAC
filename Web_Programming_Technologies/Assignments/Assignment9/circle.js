exports.calcArea = function (r) {
    var area = (Math.PI * r * r).toFixed(2)
    console.log("Area of circle having radius " + r + " is: " + area)
}

exports.calcCircumference = function (r) {
    var circumference = (2 * Math.PI * r).toFixed(2)
    console.log("Circumference of circle having radius " + r + " is: " + circumference)
}

exports.calcDiameter = function (r) {
    var diameter = r * r;
    console.log("Diameter of circle having radius " + r + " is: " + diameter)
}