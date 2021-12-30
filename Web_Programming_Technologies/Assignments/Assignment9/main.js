// import greet.js module and call the functions of greet module from this file
var g = require("./greet")

g.greet()
console.log("------------------------------------------------------------")

var c = require("./circle")
c.calcArea(3)
c.calcCircumference(3)
c.calcDiameter(3)
console.log("------------------------------------------------------------")

var r = require("./rectangle")
r.calcArea(3, 4)
r.calcPerimeter(3, 4)
console.log("------------------------------------------------------------")

var t = require("./triangle")
t.isEquilateral(2, 2, 2)
t.calcPerimeter(2, 3, 4)