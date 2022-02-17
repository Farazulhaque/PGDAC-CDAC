using System;

namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class Employee
    {
        int _IdNo;
        string _Name;

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
        }
    }
}
