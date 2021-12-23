var obj = {
    a: 10,
    b: 20
}

var obj = {} //empty object


// function sum(a,b){
//     return a + b
// }
// var calc = {
//     sum : function(a,b){
//              return a + b;
//           },
//     sub : function(a,b){
//              return a-b
//           },
//     mul : function(a,b){
//              return a * b
//           }
// }
//____________________________________________________________________

var calc = {
    a: 10,
    b: 30,
    sum: function () {
        return this.a + this.b;
    },
    sub: function () {
        return this.a - this.b
    },
    mul: function () {
        return this.a * this.b
    }
}
//Dont use arrow inside the above object

document.write(calc.sum() + "<br>")