using System;

namespace ConsoleDemoApp.Day6
{
    internal static class EmployeeExtension
    {
        public static void Display(this Employee employee, int x)
        {
            Console.WriteLine($"{employee.FirstName}\t{employee.LastName}");
        }
        public static void DisplayAge(this Employee employee)
        {
            Console.WriteLine($"{employee.Age + 10}");
        }
    }

    class Extensiontest
    {
        static void Main(string[] args)
        {
            Employee emp = new Employee();
            emp.FirstName = "Arisha";
            emp.LastName = "Aftab";
            emp.Age = 25;
            emp.Display(100);
            emp.DisplayAge();
        }
    }
}
