var obj = { // object literal
	a: 10,
	b: 30
}

//_______________________________________________________
//Create instance by using Object.create() function

var student = { // Object literal
	name: "Siddhant",
	email: "sid0308v@gmai.com",
	phone: "2384798790",
	get_grade: function () {
		return "A"
	}
}

//Creating instance
var s1 = Object.create(student)
var s2 = Object.create(student)
var s3 = Object.create(student)
s1.gender = "male";
s2.country = "India"

//____________________________________________________________
//Create instance by ES6 standard JS Syntax

// class Employee{
// 	constructor(){ // Initialize the data members
// 		this.id = 1;
// 		this.name ="Sid";
// 		this.salary = 4000;
// 	}

// 	get_tax(){ // Here we dont use function keyword and dont use arrow key function
// 		return 0.10 * this.salary
// 	}

// }

// var e1 = new Employee() //creating object of Class
// var e2 = new Employee()



class Employee {
	//parameterized consturctor
	constructor(id, name, salary) { // Initialize the data members
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	get_tax() { // Here we dont use function keyword and dont use arrow key function
		return 0.10 * this.salary
	}

}

var e1 = new Employee(1, "sid", 3000) //creating object of Class
var e2 = new Employee(2, "anubhav", 3000)

//Accessing e1 instance data
console.log(e1.name)
e1.email = "sid0308v@ghm.com"
console.log(e1)


//___________________________________________________________
//Create Object by new keyword with function


// //When we use new keyword this function act as a constructor
// function Emp(){ 
// 	this.id = 1;
// 	this.name = "Siddhant";
// 	this.salary = 4900
// }

// Emp() //normal function calling
// var emp1 = new Emp() //creating instance
// var emp2 = new Emp() // crearing instance
// var emp3 = new Emp() // creating instance

//parameterized constructor
function Emp(id, name, salary) {
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.get_tax = function () {
		return 0.18 * this.salary
	}
}

var emp1 = new Emp(1, "Sid", 3000)
var emp2 = new Emp(2, "Anubhav", 4000)
var emp3 = new Emp(3, "Rajat", 6000)

//__________________________________________________________
//Arrow functions

//Creates a function scope
//NOrmal and anonymous got "this" pointer
var get_scope = function () {
	console.log("Inside get_scope function: ");
	console.log(this)

	function scope1() {
		console.log("Inside scope1 function: ");
		console.log(this)
	}
	var scope2 = () => {
		console.log("Inside scope2 function: ");
		console.log(this)
	}
	scope1()
	scope2()
}

get_scope()




var obj = {
	scope1: function () {
		console.log("Inside scope1 function: ");
		console.log(this)
	},
	scope2: () => {
		console.log("Inside scope2 function: ");
		console.log(this)
	}

}
obj.scope1()
obj.scope2()
//_________________________________________________________
// Prototypes
var data = {
	a: 10,
	b: 20
}

function School() {
	this.schName = "Public School"
}

// It is prototyping the Object

function Student(id, name, marks) {
	this.id = id;
	this.name = name;
	this.marks = marks;
	this.get_cgpa = function () {
		return this.marks / 10
	}
}
//Overriding (Polymorphism)
Student.prototype.toString = function () {
	return "My Id is :" + this.id + " and Name is : " + this.name
}

Student.prototype.valueOf = function () {
	return this.id
}

var st1 = new Student(1, "sid", 60)

//Here setting the prototype of st1 to School
Object.setPrototypeOf(st1, School)

//_________________________________________________________
//ES6 standard Inheritance syntax
//Here Inheriting Employee class using extends keyword

class Tester extends Employee {
	constructor(id, name, salary, dept) {
		super(id, name, salary) // Here calling super class constructor and passing parameters
		this.dept = dept
	}
	get_salary() {
		return this.salary + 1000;
	}
	get_tax() {
		return this.salary * 0.05;
	}
}

var t1 = new Tester(5, "Rajat", 5000, "testing")
console.log(t1.get_salary()) // It'll execute the child function
console.log(t1.get_tax())