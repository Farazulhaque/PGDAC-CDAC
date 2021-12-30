// 5. File handling: Assume I have a file emp.txt that contains employee data in fixed record size the following format:
// 1001:Harry :Sales :23000
// 1002:Sarita :Accounts :20000
// 1003:Monika:TechSupport:35000
// Read the file. Display sum of salary of all employees

var fs = require("fs")

fs.readFile("emp.txt", function (err, data) {
    if (!err) {
        var sum_salary = 0;
        var emp = (data.toString().split("\r\n"));
        emp.forEach(emp => {
            // console.log(emp.split(":"))
            sum_salary += Number(emp.split(":")[3])
        });
        console.log("Sum of salary of all employees: " + sum_salary)
    }
})