using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day10.InterfaceExp
{
    interface ICalc1
    {
        int Add(int x, int y); // public and abstract by default
        int Subtract(int x, int y); // public and abstract by default
        //void show();
    }

    // interface inheritance
    interface ICalc2 : ICalc1
    {
        // int Add(int x, int y); // public and abstract by default
        new int Subtract(int x, int y); // public and abstract by default
    }
    // Multiple inheritance implementation
    class Calulator : ICalc2
    {
        public int Add(int x, int y) // Use public access modifier, same as parent
        {
            return x + y;
        }
        public int Subtract(int x, int y) // Use public access modifier, same as parent
        {
            return x - y;
        }
    }
    internal class InterfaceDemo1
    {
        static void Main(string[] args)
        {
            Calulator cal = new Calulator();
            Console.WriteLine("Sum: " + cal.Add(30, 20));
            Console.WriteLine("Difference: " + cal.Subtract(50, 30));
            //ICalc1 icalc1 = new Calulator();

            ICalc1 icalc1 = cal;
            Console.WriteLine("Sum: " + icalc1.Add(30, 20));
            Console.WriteLine("Difference: " + icalc1.Subtract(50, 30));

            ICalc2 icalc2 = cal;
            Console.WriteLine("Sum: " + icalc2.Add(30, 20));
            Console.WriteLine("Difference: " + icalc2.Subtract(50, 30));
        }
    }
}
