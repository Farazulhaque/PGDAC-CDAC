/*
Console.Read() -> used to read single char from console and returns the int unicode of tha
Console.ReadLine() -> used to read multi chars from console and returns the value as string
Console.ReadKey()
*/
using System;
class Consoleinput
{
    static void Main()
    {
        // int CharUnicode;
        // Console.WriteLine("Enter any char: ");
        // CharUnicode = Console.Read();
        // Console.WriteLine("Charcode:" + CharUnicode);

        // Console.Write($"Charcode: (CharUnicode)"); // C#6.0
        // --------------------------------------------------------------

        int id;
        string name;
        float salary;
        char grade;

        Console.WriteLine("Enter Id value: ");
        id = Int32.Parse(Console.ReadLine());

        Console.WriteLine("Enter name value: ");
        name = Console.ReadLine();

        Console.WriteLine("Enter Salary value: ");
        salary = Single.Parse(Console.ReadLine());

        Console.WriteLine("Enter Grade value: ");
        grade = char.Parse(Console.ReadLine());

        Console.WriteLine("ID: " + id + "\nName: " + name + "\nSalary: " + salary + "\nGrade: " + grade);

        // for parsing
        // Int32.Parse(string)

    }
}