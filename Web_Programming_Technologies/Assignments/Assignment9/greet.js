// 3. Create a user defined local module greet.js containing a function greet() 
// that greets user based on time of the day. If its morning, greet user as "Good morning", 
// if its afternoon, greet user as "Good Afternoon" else as "Good Evening"
// Create a main module that will bring in the greet.js module and invoke the greet function


var date = new Date()
d = date.getHours()

// use exports.variblename to use it in another file
exports.greet = function () {
    if (d < 12) {
        console.log("Good Morning")
    } else if (d < 5) {
        console.log("Good Afternoon")
    } else {
        console.log("Good Evening")
    }
}