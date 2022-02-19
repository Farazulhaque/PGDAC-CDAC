using System;

namespace ConsoleDemoApp.Day6
{
    internal class Employee
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public int Age { get; set; }
        // Expression body read only property
        public string FullName => $"{FirstName} {LastName}";

        static void Main(string[] args) => Console.WriteLine("Hello");

    }
}
