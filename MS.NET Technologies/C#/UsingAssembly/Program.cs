using Calculator;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UsingAssembly
{
    internal class Program
    {
        static void Main(string[] args)
        {
            MyCalc calc = new MyCalc();
            Console.WriteLine(calc.Add(300, 100));
            Console.WriteLine(calc.Multiply(300, 100));
        }
    }
}
