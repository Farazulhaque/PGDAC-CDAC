using SharedDll;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace UsingSharedLib
{
    internal class Program
    {
        static void Main(string[] args)
        {
            SharedLib sharedLib = new SharedLib();
            sharedLib.Display();
            sharedLib.Show();
            Calculator calculator = new Calculator();
            Console.WriteLine(calculator.Add(30, 30, 30));
            Console.WriteLine(calculator.Multiply(40, 5, 4));

        }
    }
}
