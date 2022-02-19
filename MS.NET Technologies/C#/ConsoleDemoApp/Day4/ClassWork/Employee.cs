using System;

namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class Employee
    {
        int _IdNo;
        string _Name;
        static int id; // object independent

        public Employee()
        {
            Console.WriteLine("Default Constructor");
            //this._IdNo = 100;
            this._IdNo = id++;
            this._Name = "Admin";
        }

        public Employee(int _IdNo)
        {
            Console.WriteLine("Parameterised constructor for Id No");
            this._IdNo = _IdNo;
            id = _IdNo + 1; // updating static id with user value
        }

        public Employee(string _Name)
        {
            Console.WriteLine("Parameterised constructor for Name");
            this._Name = _Name;
            this._IdNo = id++;
        }

        public Employee(int _Idno, string _Name)
        {
            Console.WriteLine("Parameterised constructor for Id No and Name");
            this._IdNo = _Idno;
            this._Name = _Name;
            id = _IdNo + 1; // updating static id with user value
        }

        // Static constructor, by default it is private
        // public access modifier is not allowed
        // It is called when object is cretated
        // It is called only one time
        static Employee()
        {
            id = 1000; // initial/default value
            Console.WriteLine("Static constructor Called");
            Console.WriteLine("Used to initialize the class static data fields");
            //Employee[] employees = new Employee[10];
        }

        public Employee SetEmpData(int IdNo, string Name)
        {
            this._IdNo = IdNo;
            this._Name = Name;
            Console.WriteLine("Employee details saved");
            return this;
        }
        public void DisplayEmpData()
        {
            Console.WriteLine($"Id: {_IdNo}\tName: {_Name}");
        }

        public override string ToString()
        {
            return $"Id: {_IdNo}\tName: {_Name}";
        }
    }
    class EmployeeMain
    {
        static void Main(string[] args)
        {
            /*
            Employee emp1 = new Employee();
            emp1.DisplayEmpData();


            Employee emp2 = new Employee();
            emp2.SetEmpData(2, "Arisha");
            Console.WriteLine(emp2);

            Employee emp3 = emp2;
            emp3.SetEmpData(3, "Kashaf");

            Console.WriteLine(emp3);
            Console.WriteLine(emp2);


            Console.WriteLine(emp3.GetHashCode());
            Console.WriteLine(emp2.GetHashCode());

            new Employee().SetEmpData(4, "Faraz").DisplayEmpData();
            //new Employee().DisplayEmpData();

            //Employee emp = new(); // C#9.0 or above
            */


            Employee emp1 = new Employee();
            Console.WriteLine(emp1);

            Employee emp2 = new Employee(10000);
            Console.WriteLine(emp2);

            Employee emp3 = new Employee("Arisha");
            Console.WriteLine(emp3);

            Employee emp4 = new Employee(1, "Kashaf");
            Console.WriteLine(emp4);

            Employee emp5 = new Employee();
            Console.WriteLine(emp5);

        }
    }
}
