exports.area = function (rad) {
    return Math.PI * (rad ** 2)
}

exports.perimeter = function (rad) {
    return 2 * Math.PI * rad
}

exports.diameter = function (rad) {
    return rad * 2
}