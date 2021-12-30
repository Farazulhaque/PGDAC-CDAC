// 2. Write a code to read list of numbers from file and perform addition and write into another file
// (Create two file ,First file have comma seperated numbers )

var fs = require("fs")

fs.readFile("nums.txt", function (err, data) {
    // if succesfully read file
    if (!err) {
        // store all data written in file nums.txt into nums variable
        var nums = data.toString();
        // split by "," so that it become array of numbers
        nums = nums.split(",");
        var sum = 0;
        nums.forEach(num => {
            // add to sum each number one by one
            sum += Number(num);
        });
        // Write to new file sum.txt the result i.e sum of numbers stored in nums.txt
        fs.writeFile("sum.txt", sum.toString(), function () {

        })
    }
    // if face error in reading the file
    else {
        console.log("ERROR!!!", err.message)
    }

})